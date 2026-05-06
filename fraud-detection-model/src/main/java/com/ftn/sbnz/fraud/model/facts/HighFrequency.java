package com.ftn.sbnz.fraud.model.facts;

public class HighFrequency {
    private String customerId;
    private long transactionCount;

    public HighFrequency(String customerId, long transactionCount) {
        this.customerId = customerId;
        this.transactionCount = transactionCount;
    }

    public String getCustomerId() { return customerId; }
    public void setCustomerId(String customerId) { this.customerId = customerId; }

    public long getTransactionCount() { return transactionCount; }
    public void setTransactionCount(long transactionCount) { this.transactionCount = transactionCount; }
}
