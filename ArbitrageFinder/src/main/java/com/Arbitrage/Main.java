package com.Arbitrage;

import com.Arbitrage.DAOs.BaseBallBetDAO;
import com.Arbitrage.DAOs.RootDAO;
import com.Arbitrage.DomainObjects.Event;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        BaseBallBetDAO baseBallBetDAO = new BaseBallBetDAO("baseball_mlb");

        List<Event> bets = baseBallBetDAO.parseBets();

        System.out.println(bets.size());

    }



}
