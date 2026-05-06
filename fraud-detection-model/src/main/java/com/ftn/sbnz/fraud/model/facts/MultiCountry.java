package com.ftn.sbnz.fraud.model.facts;

public class MultiCountry {
    private String customerId;
    private long countryCount;

    public MultiCountry(String customerId, long countryCount) {
        this.customerId = customerId;
        this.countryCount = countryCount;
    }

    public String getCustomerId() { return customerId; }
    public void setCustomerId(String customerId) { this.customerId = customerId; }

    public long getCountryCount() { return countryCount; }
    public void setCountryCount(long countryCount) { this.countryCount = countryCount; }
}
