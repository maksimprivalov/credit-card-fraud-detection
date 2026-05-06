package com.ftn.sbnz.fraud.model.facts;

public class UnusualMerchant {
    private String transactionId;

    public UnusualMerchant(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionId() { return transactionId; }
    public void setTransactionId(String transactionId) { this.transactionId = transactionId; }
}
