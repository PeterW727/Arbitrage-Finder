package com.Arbitrage.DAOs;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public abstract class RootDAO {
    protected static final String API_KEY = "9f3ca8b4b906c5416cb7e82f7c30390c";
    protected static final String ODDS_FORMAT = "american";  // Options: "decimal", "american", "fractional"
    protected String sport;
    protected static String  apiURL;

    public RootDAO(String sport){
        this.sport = sport;
        apiURL = "https://api.the-odds-api.com/v4/sports/" + sport + "/odds?regions=us&oddsFormat=" + ODDS_FORMAT + "&apiKey=" + API_KEY;
    }

    public static JSONArray getJSONData(){
        JSONArray jsonArray;
        try {
            // Create a URL object with the API endpoint
            URL url = new URL(apiURL);

            // Open a connection to the API endpoint
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // Set the request method to GET
            conn.setRequestMethod("GET");

            // Read the response from the input stream
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }

            // Close the connections
            in.close();
            conn.disconnect();


            String jsonResponseString = content.toString().trim();
            jsonArray = new JSONArray(jsonResponseString);



        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return jsonArray;
    }


}
