package com.ftn.sbnz.fraud.model.models;

import java.util.List;

public class CustomerProfile {

    private String customerId;
    private int age;
    private String homeCountry;
    private double avgMonthlySpending;
    private int bankRelationshipYears;
    private List<String> knownCountries;
    private List<String> usualMccCodes;
    private boolean nightActivityFlag;

    public CustomerProfile() {}

    public CustomerProfile(String customerId, int age, String homeCountry, double avgMonthlySpending,
                           int bankRelationshipYears, List<String> knownCountries,
                           List<String> usualMccCodes, boolean nightActivityFlag) {
        this.customerId = customerId;
        this.age = age;
        this.homeCountry = homeCountry;
        this.avgMonthlySpending = avgMonthlySpending;
        this.bankRelationshipYears = bankRelationshipYears;
        this.knownCountries = knownCountries;
        this.usualMccCodes = usualMccCodes;
        this.nightActivityFlag = nightActivityFlag;
    }

    public String getCustomerId() { return customerId; }
    public void setCustomerId(String customerId) { this.customerId = customerId; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getHomeCountry() { return homeCountry; }
    public void setHomeCountry(String homeCountry) { this.homeCountry = homeCountry; }

    public double getAvgMonthlySpending() { return avgMonthlySpending; }
    public void setAvgMonthlySpending(double avgMonthlySpending) { this.avgMonthlySpending = avgMonthlySpending; }

    public int getBankRelationshipYears() { return bankRelationshipYears; }
    public void setBankRelationshipYears(int bankRelationshipYears) { this.bankRelationshipYears = bankRelationshipYears; }

    public List<String> getKnownCountries() { return knownCountries; }
    public void setKnownCountries(List<String> knownCountries) { this.knownCountries = knownCountries; }

    public List<String> getUsualMccCodes() { return usualMccCodes; }
    public void setUsualMccCodes(List<String> usualMccCodes) { this.usualMccCodes = usualMccCodes; }

    public boolean isNightActivityFlag() { return nightActivityFlag; }
    public void setNightActivityFlag(boolean nightActivityFlag) { this.nightActivityFlag = nightActivityFlag; }

    @Override
    public String toString() {
        return "CustomerProfile{customerId='" + customerId + "', homeCountry='" + homeCountry +
               "', avgMonthlySpending=" + avgMonthlySpending + "}";
    }
}
