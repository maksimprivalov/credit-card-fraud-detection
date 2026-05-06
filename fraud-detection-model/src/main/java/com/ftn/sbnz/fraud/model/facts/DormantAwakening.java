package com.ftn.sbnz.fraud.model.facts;

public class DormantAwakening {
    private String cardId;
    private long inactiveMonths;

    public DormantAwakening(String cardId, long inactiveMonths) {
        this.cardId = cardId;
        this.inactiveMonths = inactiveMonths;
    }

    public String getCardId() { return cardId; }
    public void setCardId(String cardId) { this.cardId = cardId; }

    public long getInactiveMonths() { return inactiveMonths; }
    public void setInactiveMonths(long inactiveMonths) { this.inactiveMonths = inactiveMonths; }
}
