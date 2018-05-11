package com.jobPortal;

import org.json.simple.JSONObject;

import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;


public class Main {

    public static void main(String[] args){
        String baseUrl=Constants.baseUrl;
        JSONObject json;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
        ApiEndPoint gitHub= retrofit.create(ApiEndPoint.class);

        RetrieveContent retrieve= new RetrieveContent(gitHub);
        try {
            retrieve.display();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
