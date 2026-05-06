package com.ftn.sbnz.fraud.model.facts;

public class VelocityAttack {
    private String cardId;
    private long transactionCount;

    public VelocityAttack(String cardId, long transactionCount) {
        this.cardId = cardId;
        this.transactionCount = transactionCount;
    }

    public String getCardId() { return cardId; }
    public void setCardId(String cardId) { this.cardId = cardId; }

    public long getTransactionCount() { return transactionCount; }
    public void setTransactionCount(long transactionCount) { this.transactionCount = transactionCount; }
}
