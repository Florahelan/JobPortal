package com.jobPortal;

import com.google.gson.Gson;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import retrofit2.Call;
import retrofit2.Response;

public class RetrieveContent {

    private ApiEndPoint api;
    private Gson gson;
    private JSONParser jsonParser;
    JSONObject result;

    public RetrieveContent(ApiEndPoint api) {
        this.api = api;
    }

    public String display() throws Exception {
        Call<String> requestCall = api.githubDisplay();
        Response<String> serverResponse = requestCall.execute();
        System.out.println("server response is: " + serverResponse);
        if (serverResponse.isSuccessful()) {
            String responseFromServer = serverResponse.body();
            System.out.println("response From Server is: " + responseFromServer);
            //JSONParser parser = new JSONParser();
            //JSONObject json = (JSONObject) parser.parse(responseFromServer);
            //JSONArray arr = (JSONArray) json.get("title");
            //System.out.println("title is: " + arr.get(0));
            //String title = json.get("title").toString();
            return responseFromServer;
        } else {
            int responseCode = serverResponse.code();
            System.out.println("Error is : " + responseCode);
        }
        return null;
    }
}
