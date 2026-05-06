package com.ftn.sbnz.fraud.model.facts;

public class MediumTransaction {
    private String transactionId;

    public MediumTransaction(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionId() { return transactionId; }
    public void setTransactionId(String transactionId) { this.transactionId = transactionId; }
}
