package com.Arbitrage.DAOs;

import com.Arbitrage.DomainObjects.BaseballBet;
import com.Arbitrage.DomainObjects.Bet;
import com.Arbitrage.DomainObjects.Event;
import com.Arbitrage.DomainObjects.Pair;
import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class BaseBallBetDAO extends RootDAO{

    public BaseBallBetDAO(String sport) {
        super(sport);
    }

    public List<Event> parseBets(){
        JSONArray jsonArray = new JSONArray(getJSONData());
        List<Event> events = new ArrayList<>();

        for(int i = 0; i < jsonArray.length(); i++){
            List<Bet> bets = new ArrayList<>();
            JSONObject event = jsonArray.getJSONObject(i);
            String homeTeam = event.getString("home_team");
            String awayTeam = event.getString("away_team");
            String game = homeTeam + " vs. " + awayTeam;
            String sportTitle = event.getString("sport_title");
            String id = event.getString("id");
            JSONArray bookmakers = event.getJSONArray("bookmakers");
            Date commencementTime  = Date.valueOf(event.getString("commence_time").substring(0,10));
            for(int j = 0; j < bookmakers.length(); j++){
                JSONObject book = bookmakers.getJSONObject(j);
                String bettingWebsite = book.getString("title");
                String key = book.getString("key");
                Date lastUpdate = Date.valueOf(book.getString("last_update").substring(0,10));

                JSONArray markets = book.getJSONArray("markets");
                for(int k = 0; k < markets.length(); k++){
                    JSONObject market = markets.getJSONObject(k);

                    JSONArray outcomes = market.getJSONArray("outcomes");

                    Pair<String, Integer> homeOutcome = null;
                    Pair<String, Integer> awayOutcome = null;

                    for(int l = 0; l < outcomes.length(); l++){
                        JSONObject outcome = outcomes.getJSONObject(l);
                        String teamName = outcome.getString("name");
                        int price = outcome.getInt("price");

                        if(teamName.equals(homeTeam)){
                            homeOutcome = new Pair<>(teamName, price);
                        } else if (teamName.equals(awayTeam)) {
                            awayOutcome = new Pair<>(teamName, price);
                        }
                    }
                    if(homeOutcome != null && awayOutcome != null){
                        BaseballBet bet = new BaseballBet(homeOutcome, awayOutcome, bettingWebsite, key, lastUpdate);
                        bets.add(bet);
                    }
                }

            }
            Event event1 = new Event(id, sportTitle, commencementTime, bets, game);
            events.add(event1);
        }

        return events;
    }
}
