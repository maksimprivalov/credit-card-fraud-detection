package com.ftn.sbnz.fraud.model.models;

import java.time.LocalDateTime;

public class Transaction {

    private String id;
    private String cardId;
    private String customerId;
    private double amount;
    private String currency;
    private LocalDateTime timestamp;
    private TransactionType type;
    private String country;
    private String city;
    private String mccCode;
    private String ipAddress;
    private String deviceFingerprint;

    public Transaction() {}

    public Transaction(String id, String cardId, String customerId, double amount, String currency,
                       LocalDateTime timestamp, TransactionType type, String country, String city,
                       String mccCode, String ipAddress, String deviceFingerprint) {
        this.id = id;
        this.cardId = cardId;
        this.customerId = customerId;
        this.amount = amount;
        this.currency = currency;
        this.timestamp = timestamp;
        this.type = type;
        this.country = country;
        this.city = city;
        this.mccCode = mccCode;
        this.ipAddress = ipAddress;
        this.deviceFingerprint = deviceFingerprint;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getCardId() { return cardId; }
    public void setCardId(String cardId) { this.cardId = cardId; }

    public String getCustomerId() { return customerId; }
    public void setCustomerId(String customerId) { this.customerId = customerId; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }

    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }

    public TransactionType getType() { return type; }
    public void setType(TransactionType type) { this.type = type; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getMccCode() { return mccCode; }
    public void setMccCode(String mccCode) { this.mccCode = mccCode; }

    public String getIpAddress() { return ipAddress; }
    public void setIpAddress(String ipAddress) { this.ipAddress = ipAddress; }

    public String getDeviceFingerprint() { return deviceFingerprint; }
    public void setDeviceFingerprint(String deviceFingerprint) { this.deviceFingerprint = deviceFingerprint; }

    @Override
    public String toString() {
        return "Transaction{id='" + id + "', cardId='" + cardId + "', customerId='" + customerId +
               "', amount=" + amount + ", country='" + country + "', type=" + type + "}";
    }
}
