package com.ilianxin.learn.hackerrank.rest;

import com.google.gson.*;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;


class GetTotalGoals {

    /*
     * Complete the 'getTotalGoals' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING team
     *  2. INTEGER year
     */

    public static int getTotalGoals(String team, int year){
        String url = "https://jsonmock.hackerrank.com/api/football_matches?";

        String yearStr  = "year=" + year;
        String teamStr = "team1=" + team;
        String teamStr2 = "team2=" + team;

        String url1 = url + yearStr + "&" + teamStr;
        String url2 = url + yearStr + "&" + teamStr2;

        int result = 0;

        try {

            result = getTeamGoals(url1, "team1", 1, 0) + getTeamGoals(url2, "team2", 1, 0) ;
            System.out.println(result);
        } catch (Exception e) {

        }

        return result ;
    }

    private static int getTeamGoals(String teamUrl, String teamtype, int page, int totalGoals) throws Exception {

        String response = getResponsePerPage(teamUrl, page);

        System.out.println(response);

        JsonObject jsonResponse = new Gson().fromJson(response, JsonObject.class);
        int totalPages = jsonResponse.get("total_pages").getAsInt();
        JsonArray data = jsonResponse.getAsJsonArray("data");
        for (JsonElement e : data) {
            totalGoals += e.getAsJsonObject().get(teamtype+"goals").getAsInt();
        }

        return totalPages==page? totalGoals : getTeamGoals(teamUrl, teamtype, page+1, totalGoals);
    }

    private static String getResponsePerPage(String endpoint, int page) throws Exception {

        System.out.println(String.format(" URL: %s and page: %d", endpoint, page));

        URL url = new URL(endpoint+"&page="+page);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.addRequestProperty("Content-Type", "application/json");

        int status = con.getResponseCode();
        if(status<200 || status>=300) {
            throw new IOException("Error in reading data with status:"+status);
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String response;
        StringBuilder sb = new StringBuilder();
        while((response = br.readLine())!=null) {
            sb.append(response);
        }

        br.close();
        con.disconnect();

        return sb.toString();
    }


}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String team = bufferedReader.readLine();

        int year = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.getTotalGoals(team, year);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
