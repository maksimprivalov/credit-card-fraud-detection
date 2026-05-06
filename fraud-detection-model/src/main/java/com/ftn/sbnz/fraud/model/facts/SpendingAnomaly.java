package com.ftn.sbnz.fraud.model.facts;

public class SpendingAnomaly {
    private String transactionId;

    public SpendingAnomaly(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionId() { return transactionId; }
    public void setTransactionId(String transactionId) { this.transactionId = transactionId; }
}
