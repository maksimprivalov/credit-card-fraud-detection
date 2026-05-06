package com.ftn.sbnz.fraud.model.facts;

import java.util.List;

public class FraudDecision {

    public enum Decision {
        APPROVE,
        REVIEW,
        BLOCK
    }

    private String transactionId;
    private String customerId;
    private Decision decision;
    private int riskScore;
    private List<String> reasons;

    public FraudDecision(String transactionId, String customerId, Decision decision,
                         int riskScore, List<String> reasons) {
        this.transactionId = transactionId;
        this.customerId = customerId;
        this.decision = decision;
        this.riskScore = riskScore;
        this.reasons = reasons;
    }

    public String getTransactionId() { return transactionId; }
    public void setTransactionId(String transactionId) { this.transactionId = transactionId; }

    public String getCustomerId() { return customerId; }
    public void setCustomerId(String customerId) { this.customerId = customerId; }

    public Decision getDecision() { return decision; }
    public void setDecision(Decision decision) { this.decision = decision; }

    public int getRiskScore() { return riskScore; }
    public void setRiskScore(int riskScore) { this.riskScore = riskScore; }

    public List<String> getReasons() { return reasons; }
    public void setReasons(List<String> reasons) { this.reasons = reasons; }

    @Override
    public String toString() {
        return "FraudDecision{transactionId='" + transactionId + "', decision=" + decision +
               ", riskScore=" + riskScore + ", reasons=" + reasons + "}";
    }
}
