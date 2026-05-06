package com.ftn.sbnz.fraud.model.facts;

public class DailyLimitExceeded {
    private String customerId;
    private double totalAmount;

    public DailyLimitExceeded(String customerId, double totalAmount) {
        this.customerId = customerId;
        this.totalAmount = totalAmount;
    }

    public String getCustomerId() { return customerId; }
    public void setCustomerId(String customerId) { this.customerId = customerId; }

    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }
}
