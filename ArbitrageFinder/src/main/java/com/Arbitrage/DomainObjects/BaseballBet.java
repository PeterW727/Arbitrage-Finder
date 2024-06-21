package com.Arbitrage.DomainObjects;

import java.security.PublicKey;
import java.sql.Date;

public class BaseballBet extends Bet{
    Pair<String, Integer> homeTeam;
    Pair<String, Integer> awayTeam;

    public BaseballBet(Pair<String, Integer> homeTeam, Pair<String, Integer> awayTeam, String BettingWebsite, String key, Date lastUpdate) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.BettingWebsite = BettingWebsite;
        this.key = key;
        this.lastUpdate = lastUpdate;
    }

    public Pair<String, Integer> getHomeTeam() {
        return homeTeam;
    }
    public void setHomeTeam(Pair<String, Integer> homeTeam) {
        this.homeTeam = homeTeam;
    }
    public Pair<String, Integer> getAwayTeam() {
        return awayTeam;
    }
    public void setAwayTeam(Pair<String, Integer> awayTeam) {
        this.awayTeam = awayTeam;
    }

    public int getHomeOdds(){
        return homeTeam.getValue();
    }

    public int getAwayOdds(){
        return homeTeam.getValue();
    }
}
