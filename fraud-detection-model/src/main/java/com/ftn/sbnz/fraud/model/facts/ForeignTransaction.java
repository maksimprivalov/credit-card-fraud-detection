package com.ftn.sbnz.fraud.model.facts;

public class ForeignTransaction {
    private String transactionId;

    public ForeignTransaction(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionId() { return transactionId; }
    public void setTransactionId(String transactionId) { this.transactionId = transactionId; }
}
