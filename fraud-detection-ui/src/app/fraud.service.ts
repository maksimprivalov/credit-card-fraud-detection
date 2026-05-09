import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface FraudDecision {
  transactionId: string;
  customerId: string;
  decision: 'APPROVE' | 'REVIEW' | 'BLOCK';
  riskScore: number;
  reasons: string[];
}

export interface Transaction {
  id: string;
  cardId: string;
  customerId: string;
  amount: number;
  currency: string;
  timestamp: string;
  type: 'ONLINE' | 'POS' | 'ATM';
  country: string;
  city: string | null;
  mccCode: string;
  ipAddress: string | null;
  deviceFingerprint: string | null;
}

export interface CustomerProfile {
  customerId: string;
  age: number;
  homeCountry: string;
  avgMonthlySpending: number;
  bankRelationshipYears: number;
  knownCountries: string[];
  usualMccCodes: string[];
  nightActivityFlag: boolean;
}

export interface AnalyzeRequest {
  transaction: Transaction;
  customerProfile: CustomerProfile;
  historicalTransactions: Transaction[];
}

@Injectable({ providedIn: 'root' })
export class FraudService {
  constructor(private http: HttpClient) {}

  runDemo(): Observable<FraudDecision> {
    return this.http.get<FraudDecision>('/fraud-detection/demo');
  }

  analyze(request: AnalyzeRequest): Observable<FraudDecision> {
    return this.http.post<FraudDecision>('/fraud-detection/analyze', request);
  }
}
