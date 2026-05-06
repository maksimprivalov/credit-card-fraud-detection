package com.ftn.sbnz.fraud.service.services;

import com.ftn.sbnz.fraud.model.facts.FraudDecision;
import com.ftn.sbnz.fraud.model.facts.RiskDependency;
import com.ftn.sbnz.fraud.model.facts.RiskFactor;
import com.ftn.sbnz.fraud.model.models.RiskScore;
import com.ftn.sbnz.fraud.model.models.CustomerProfile;
import com.ftn.sbnz.fraud.model.models.Transaction;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class FraudDetectionService {

    private final KieContainer kieContainer;

    @Autowired
    public FraudDetectionService(KieContainer kieContainer) {
        this.kieContainer = kieContainer;
    }

    public FraudDecision analyzeTransaction(Transaction transaction, CustomerProfile customerProfile) {
        KieSession kSession = kieContainer.newKieSession();
        try {
            insertRiskTree(kSession);
            kSession.insert(customerProfile);
            kSession.insert(transaction);
            kSession.insert(new RiskScore(transaction.getId(), transaction.getCustomerId()));
            kSession.fireAllRules();

            return kSession.getObjects(obj -> obj instanceof FraudDecision)
                    .stream()
                    .map(obj -> (FraudDecision) obj)
                    .findFirst()
                    .orElse(null);
        } finally {
            kSession.dispose();
        }
    }

    private void insertRiskTree(KieSession kSession) {
        // Stablo rizika za backward chaining (videti spec sekcija 1.3.5)
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
