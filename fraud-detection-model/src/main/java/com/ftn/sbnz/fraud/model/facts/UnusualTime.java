package com.ftn.sbnz.fraud.model.facts;

public class UnusualTime {
    private String transactionId;

    public UnusualTime(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionId() { return transactionId; }
    public void setTransactionId(String transactionId) { this.transactionId = transactionId; }
}
