package com.ftn.sbnz.fraud.model.facts;

public class LargeTransaction {
    private String transactionId;

    public LargeTransaction(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionId() { return transactionId; }
    public void setTransactionId(String transactionId) { this.transactionId = transactionId; }
}
