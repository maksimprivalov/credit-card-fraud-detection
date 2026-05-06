package com.ftn.sbnz.fraud.service.controllers;

import com.ftn.sbnz.fraud.model.facts.FraudDecision;
import com.ftn.sbnz.fraud.model.models.CustomerProfile;
import com.ftn.sbnz.fraud.model.models.Transaction;
import com.ftn.sbnz.fraud.service.services.FraudDetectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
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
        return fraudDetectionService.analyzeTransaction(request.getTransaction(), request.getCustomerProfile());
    }

    @GetMapping("/demo")
    public FraudDecision runDemo() {
        // Scenario iz specifikacije: Marko, Beograd -> Nigerija
        // TODO: popuniti demo scenariom iz sekcije 2
        return null;
    }

    public static class TransactionRequest {
        private Transaction transaction;
        private CustomerProfile customerProfile;

        public Transaction getTransaction() { return transaction; }
        public void setTransaction(Transaction transaction) { this.transaction = transaction; }

        public CustomerProfile getCustomerProfile() { return customerProfile; }
        public void setCustomerProfile(CustomerProfile customerProfile) { this.customerProfile = customerProfile; }
    }
}
