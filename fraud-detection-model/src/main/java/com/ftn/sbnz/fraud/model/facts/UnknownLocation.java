package com.ftn.sbnz.fraud.model.facts;

public class UnknownLocation {
    private String transactionId;

    public UnknownLocation(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionId() { return transactionId; }
    public void setTransactionId(String transactionId) { this.transactionId = transactionId; }
}
