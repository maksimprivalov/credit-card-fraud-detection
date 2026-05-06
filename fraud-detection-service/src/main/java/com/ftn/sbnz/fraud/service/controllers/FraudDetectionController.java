package com.ftn.sbnz.fraud.service.controllers;

import com.ftn.sbnz.fraud.model.facts.FraudDecision;
import com.ftn.sbnz.fraud.model.models.CustomerProfile;
import com.ftn.sbnz.fraud.model.models.Transaction;
import com.ftn.sbnz.fraud.model.models.TransactionType;
import com.ftn.sbnz.fraud.service.services.FraudDetectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/fraud-detection")
public class FraudDetectionController {

    private final FraudDetectionService fraudDetectionService;

    @Autowired
    public FraudDetectionController(FraudDetectionService fraudDetectionService) {
        this.fraudDetectionService = fraudDetectionService;
    }

    @PostMapping("/analyze")
    public FraudDecision analyzeTransaction(@RequestBody TransactionRequest request) {
        List<Transaction> history = request.getHistoricalTransactions() != null
                ? request.getHistoricalTransactions()
                : Collections.emptyList();
        return fraudDetectionService.analyzeTransaction(
                request.getTransaction(),
                request.getCustomerProfile(),
                history);
    }

    // Demo scenario iz specifikacije sekcija 2: Marko, Beograd -> Nigerija
    @GetMapping("/demo")
    public FraudDecision runDemo() {
        LocalDateTime base = LocalDateTime.now().withHour(10).withMinute(0).withSecond(0);

        CustomerProfile marko = new CustomerProfile(
                "marko", 34, "RS", 800.0, 4,
                Arrays.asList("RS"), Arrays.asList("supermarket", "restaurant"), false);

        // Istorijske transakcije (#1-#4 iz scenarija)
        Transaction t1 = new Transaction("t1", "card1", "marko", 23.0, "EUR",
                base.withHour(10).withMinute(15), TransactionType.POS,
                "RS", "Belgrade", "supermarket", null, null);

        Transaction t2 = new Transaction("t2", "card1", "marko", 3.0, "EUR",
                base.withHour(10).withMinute(47), TransactionType.ONLINE,
                "NG", null, "electronics", "197.0.0.1", null);

        Transaction t3 = new Transaction("t3", "card1", "marko", 5.0, "EUR",
                base.withHour(10).withMinute(48).withSecond(30), TransactionType.ONLINE,
                "NG", null, "gambling", "197.0.0.1", null);

        Transaction t4 = new Transaction("t4", "card1", "marko", 4.0, "EUR",
                base.withHour(10).withMinute(51), TransactionType.ONLINE,
                "NG", null, "streaming", "197.0.0.1", null);

        // Tekuca transakcija #5 - velika transakcija iz Nigerije
        Transaction t5 = new Transaction("t5", "card1", "marko", 850.0, "EUR",
                base.withHour(10).withMinute(52), TransactionType.ONLINE,
                "NG", null, "electronics", "197.0.0.1", null);

        return fraudDetectionService.analyzeTransaction(t5, marko, Arrays.asList(t1, t2, t3, t4));
    }

    public static class TransactionRequest {
        private Transaction transaction;
        private CustomerProfile customerProfile;
        private List<Transaction> historicalTransactions;

        public Transaction getTransaction() { return transaction; }
        public void setTransaction(Transaction transaction) { this.transaction = transaction; }

        public CustomerProfile getCustomerProfile() { return customerProfile; }
        public void setCustomerProfile(CustomerProfile customerProfile) { this.customerProfile = customerProfile; }

        public List<Transaction> getHistoricalTransactions() { return historicalTransactions; }
        public void setHistoricalTransactions(List<Transaction> historicalTransactions) {
            this.historicalTransactions = historicalTransactions;
        }
    }
}
