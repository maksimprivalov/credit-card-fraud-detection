package com.ftn.sbnz.fraud.model.facts;

public class CompromisedCard {
    private String cardId;

    public CompromisedCard(String cardId) {
        this.cardId = cardId;
    }

    public String getCardId() { return cardId; }
    public void setCardId(String cardId) { this.cardId = cardId; }
}
