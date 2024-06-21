package com.Arbitrage.DomainObjects;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Event {
    protected String id;
    protected String sportKey;
    protected Date commencementTime;
    protected List<Bet> bets;
    protected String game;

    public Event(String id, String sportKey, Date commencementTime, String game) {
        this.id = id;
        this.sportKey = sportKey;
        this.commencementTime = commencementTime;
        bets = new ArrayList<>() {};
        this.game = game;
    }

    public Event(String id, String sportKey, Date commencementTime, List<Bet> bets, String game) {
        this.id = id;
        this.sportKey = sportKey;
        this.commencementTime = commencementTime;
        this.bets = bets;
        this.game = game;
    }


    public void addBet(Bet bet){
        bets.add(bet);
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSportKey() {
        return sportKey;
    }

    public void setSportKey(String sportKey) {
        this.sportKey = sportKey;
    }

    public Date getCommencementTime() {
        return commencementTime;
    }

    public void setCommencementTime(Date commencementTime) {
        this.commencementTime = commencementTime;
    }

    public List<Bet> getBets() {
        return bets;
    }

    public void setBets(List<Bet> bets) {
        this.bets = bets;
    }
}
