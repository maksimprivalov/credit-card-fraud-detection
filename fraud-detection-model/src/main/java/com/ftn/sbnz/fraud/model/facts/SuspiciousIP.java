package com.ftn.sbnz.fraud.model.facts;

public class SuspiciousIP {
    private String transactionId;

    public SuspiciousIP(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionId() { return transactionId; }
    public void setTransactionId(String transactionId) { this.transactionId = transactionId; }
}
