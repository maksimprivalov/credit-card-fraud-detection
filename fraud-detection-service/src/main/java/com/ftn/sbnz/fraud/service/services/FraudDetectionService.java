package com.ftn.sbnz.fraud.service.services;

import com.ftn.sbnz.fraud.model.facts.FraudDecision;
import com.ftn.sbnz.fraud.model.facts.RiskDependency;
import com.ftn.sbnz.fraud.model.models.CustomerProfile;
import com.ftn.sbnz.fraud.model.models.RiskScore;
import com.ftn.sbnz.fraud.model.models.Transaction;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class FraudDetectionService {

    private final KieContainer kieContainer;

    @Autowired
    public FraudDetectionService(KieContainer kieContainer) {
        this.kieContainer = kieContainer;
    }

    public FraudDecision analyzeTransaction(Transaction transaction,
                                             CustomerProfile customerProfile) {
        return analyzeTransaction(transaction, customerProfile, Collections.emptyList());
    }

    public FraudDecision analyzeTransaction(Transaction transaction,
                                             CustomerProfile customerProfile,
                                             List<Transaction> historicalTransactions) {
        KieSession kSession = kieContainer.newKieSession("FraudDetectionKSession");
        try {
            insertRiskTree(kSession);
            kSession.insert(customerProfile);

            // Istorijske transakcije daju kontekst za Nivo 3 (accumulate/CEP)
            for (Transaction hist : historicalTransactions) {
                kSession.insert(hist);
            }

            // Tekuca transakcija + njen RiskScore
            kSession.insert(transaction);
            kSession.insert(new RiskScore(transaction.getId(), transaction.getCustomerId()));

            kSession.fireAllRules();

            return kSession.getObjects(obj -> obj instanceof FraudDecision)
                    .stream()
                    .map(obj -> (FraudDecision) obj)
                    .filter(d -> d.getTransactionId().equals(transaction.getId()))
                    .findFirst()
                    .orElse(null);
        } finally {
            kSession.dispose();
        }
    }

    private void insertRiskTree(KieSession kSession) {
        // Stablo rizika za backward chaining
        kSession.insert(new RiskDependency("highRiskCustomer", "hasRecentBlock"));
        kSession.insert(new RiskDependency("highRiskCustomer", "hasFraudPattern"));
        kSession.insert(new RiskDependency("highRiskCustomer", "hasAnomalousScore"));

        kSession.insert(new RiskDependency("hasRecentBlock", "blockInLast7Days"));
        kSession.insert(new RiskDependency("hasRecentBlock", "cardFrozen"));

        kSession.insert(new RiskDependency("hasFraudPattern", "hasCardTesting"));
        kSession.insert(new RiskDependency("hasFraudPattern", "hasImpossibleTravel"));
        kSession.insert(new RiskDependency("hasFraudPattern", "hasVelocityAttack"));

        kSession.insert(new RiskDependency("hasAnomalousScore", "riskScoreAbove80"));
        kSession.insert(new RiskDependency("hasAnomalousScore", "spendingAnomaly"));
    }
}
