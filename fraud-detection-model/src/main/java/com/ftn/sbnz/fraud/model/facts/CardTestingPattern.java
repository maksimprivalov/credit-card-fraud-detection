package com.ftn.sbnz.fraud.model.facts;

public class CardTestingPattern {
    private String cardId;

    public CardTestingPattern(String cardId) {
        this.cardId = cardId;
    }

    public String getCardId() { return cardId; }
    public void setCardId(String cardId) { this.cardId = cardId; }
}
