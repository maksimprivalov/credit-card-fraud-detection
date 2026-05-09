import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { provideHttpClient } from '@angular/common/http';
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatDividerModule } from '@angular/material/divider';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { MatIconModule } from '@angular/material/icon';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { MatTooltipModule } from '@angular/material/tooltip';
import { HttpClient } from '@angular/common/http';
import { FraudService, FraudDecision, AnalyzeRequest } from './fraud.service';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    CommonModule,
    ReactiveFormsModule,
    MatCardModule,
    MatButtonModule,
    MatInputModule,
    MatSelectModule,
    MatFormFieldModule,
    MatDividerModule,
    MatProgressSpinnerModule,
    MatIconModule,
    MatSlideToggleModule,
    MatTooltipModule,
  ],
  templateUrl: './app.html',
  styleUrl: './app.scss'
})
export class App {
  form: FormGroup;
  result: FraudDecision | null = null;
  loading = false;
  error: string | null = null;

  constructor(private fb: FormBuilder, private fraudService: FraudService) {
    this.form = this.fb.group({
      txId:              ['tx-001', Validators.required],
      cardId:            ['card-001', Validators.required],
      customerId:        ['marko', Validators.required],
      amount:            [850, [Validators.required, Validators.min(0)]],
      currency:          ['EUR'],
      timestamp:         [new Date().toISOString().slice(0, 16), Validators.required],
      type:              ['ONLINE', Validators.required],
      country:           ['NG', Validators.required],
      city:              [''],
      mccCode:           ['electronics', Validators.required],
      ipAddress:         ['197.0.0.1'],
      profileId:         ['marko', Validators.required],
      age:               [34],
      homeCountry:       ['RS', Validators.required],
      avgMonthlySpending:[800, Validators.required],
      bankYears:         [4],
      knownCountries:    ['RS'],
      usualMccCodes:     ['supermarket,restaurant'],
      nightActivityFlag: [false],
    });
  }

  runDemo() {
    this.loading = true;
    this.result = null;
    this.error = null;
    this.fraudService.runDemo().subscribe({
      next:  (res) => { this.result = res;  this.loading = false; },
      error: ()    => { this.error = 'Backend nije dostupan. Pokreni service na :8080'; this.loading = false; }
    });
  }

  analyze() {
    if (this.form.invalid) return;
    const v = this.form.value;

    const request: AnalyzeRequest = {
      transaction: {
        id: v.txId,
        cardId: v.cardId,
        customerId: v.customerId,
        amount: +v.amount,
        currency: v.currency || 'EUR',
        timestamp: v.timestamp + ':00',
        type: v.type,
        country: v.country,
        city: v.city || null,
        mccCode: v.mccCode,
        ipAddress: v.ipAddress || null,
        deviceFingerprint: null,
      },
      customerProfile: {
        customerId: v.profileId,
        age: +v.age,
        homeCountry: v.homeCountry,
        avgMonthlySpending: +v.avgMonthlySpending,
        bankRelationshipYears: +v.bankYears,
        knownCountries: (v.knownCountries as string).split(',').map(s => s.trim()).filter(Boolean),
        usualMccCodes:  (v.usualMccCodes as string).split(',').map(s => s.trim()).filter(Boolean),
        nightActivityFlag: v.nightActivityFlag,
      },
      historicalTransactions: [],
    };

    this.loading = true;
    this.result = null;
    this.error = null;
    this.fraudService.analyze(request).subscribe({
      next:  (res) => { this.result = res;  this.loading = false; },
      error: ()    => { this.error = 'Backend nije dostupan. Pokreni service na :8080'; this.loading = false; }
    });
  }

  get decisionColor(): string {
    if (!this.result) return '';
    return ({ APPROVE: '#2e7d32', REVIEW: '#e65100', BLOCK: '#b71c1c' } as any)[this.result.decision] ?? '';
  }

  get decisionIcon(): string {
    if (!this.result) return '';
    return ({ APPROVE: 'check_circle', REVIEW: 'warning', BLOCK: 'block' } as any)[this.result.decision] ?? '';
  }

  get decisionLabel(): string {
    if (!this.result) return '';
    return ({ APPROVE: 'Odobreno', REVIEW: 'Na pregledu', BLOCK: 'Blokirano' } as any)[this.result.decision] ?? '';
  }
}
