package com.ftn.sbnz.fraud.model.facts;

public class ImpossibleTravel {
    private String cardId;
    private String firstCountry;
    private String secondCountry;
    private long timeDiffMinutes;

    public ImpossibleTravel(String cardId, String firstCountry, String secondCountry, long timeDiffMinutes) {
        this.cardId = cardId;
        this.firstCountry = firstCountry;
        this.secondCountry = secondCountry;
        this.timeDiffMinutes = timeDiffMinutes;
    }

    public String getCardId() { return cardId; }
    public void setCardId(String cardId) { this.cardId = cardId; }

    public String getFirstCountry() { return firstCountry; }
    public void setFirstCountry(String firstCountry) { this.firstCountry = firstCountry; }

    public String getSecondCountry() { return secondCountry; }
    public void setSecondCountry(String secondCountry) { this.secondCountry = secondCountry; }

    public long getTimeDiffMinutes() { return timeDiffMinutes; }
    public void setTimeDiffMinutes(long timeDiffMinutes) { this.timeDiffMinutes = timeDiffMinutes; }
}
