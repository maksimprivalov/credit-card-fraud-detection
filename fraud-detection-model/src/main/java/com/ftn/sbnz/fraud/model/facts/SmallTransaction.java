package com.ftn.sbnz.fraud.model.facts;

public class SmallTransaction {
    private String transactionId;

    public SmallTransaction(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionId() { return transactionId; }
    public void setTransactionId(String transactionId) { this.transactionId = transactionId; }
}
