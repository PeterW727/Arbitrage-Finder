package com.Arbitrage.DomainObjects;

import java.sql.Date;

public abstract class Bet {
    protected String BettingWebsite;
    protected String key;
    protected Date lastUpdate;

    public String getBettingWebsite() {
        return BettingWebsite;
    }

    public void setBettingWebsite(String bettingWebsite) {
        BettingWebsite = bettingWebsite;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
