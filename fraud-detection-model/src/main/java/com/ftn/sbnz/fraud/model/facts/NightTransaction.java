package com.ftn.sbnz.fraud.model.facts;

public class NightTransaction {
    private String transactionId;

    public NightTransaction(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionId() { return transactionId; }
    public void setTransactionId(String transactionId) { this.transactionId = transactionId; }
}
