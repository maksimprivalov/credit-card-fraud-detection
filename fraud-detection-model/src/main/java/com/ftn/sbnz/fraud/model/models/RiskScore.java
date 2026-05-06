package com.ftn.sbnz.fraud.model.models;

import java.util.ArrayList;
import java.util.List;

public class RiskScore {

    private String transactionId;
    private String customerId;
    private int score;
    private List<String> firedRules;

    public RiskScore(String transactionId, String customerId) {
        this.transactionId = transactionId;
        this.customerId = customerId;
        this.score = 0;
        this.firedRules = new ArrayList<>();
    }

    public void addScore(int points, String ruleName) {
        this.score = Math.min(100, this.score + points);
        this.firedRules.add(ruleName);
    }

    public String getTransactionId() { return transactionId; }
    public void setTransactionId(String transactionId) { this.transactionId = transactionId; }

    public String getCustomerId() { return customerId; }
    public void setCustomerId(String customerId) { this.customerId = customerId; }

    public int getScore() { return score; }
    public void setScore(int score) { this.score = score; }

    public List<String> getFiredRules() { return firedRules; }
    public void setFiredRules(List<String> firedRules) { this.firedRules = firedRules; }

    @Override
    public String toString() {
        return "RiskScore{transactionId='" + transactionId + "', score=" + score +
               ", firedRules=" + firedRules + "}";
    }
}
