package com.ftn.sbnz.fraud.model.facts;

public class RiskyMerchantCategory {
    private String transactionId;

    public RiskyMerchantCategory(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionId() { return transactionId; }
    public void setTransactionId(String transactionId) { this.transactionId = transactionId; }
}
