package com.ftn.sbnz.fraud.model.facts;

public class AmountSpike {
    private String customerId;
    private double currentAmount;
    private double avgAmount;

    public AmountSpike(String customerId, double currentAmount, double avgAmount) {
        this.customerId = customerId;
        this.currentAmount = currentAmount;
        this.avgAmount = avgAmount;
    }

    public String getCustomerId() { return customerId; }
    public void setCustomerId(String customerId) { this.customerId = customerId; }

    public double getCurrentAmount() { return currentAmount; }
    public void setCurrentAmount(double currentAmount) { this.currentAmount = currentAmount; }

    public double getAvgAmount() { return avgAmount; }
    public void setAvgAmount(double avgAmount) { this.avgAmount = avgAmount; }
}
