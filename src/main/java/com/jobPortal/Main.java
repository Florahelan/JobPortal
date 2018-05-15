package com.jobPortal;

import org.json.simple.JSONObject;

import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;


public class Main {

    public static void main(String[] args){
        String git=Constants.github;
        String stack=Constants.stackoverflow;

        JSONObject json;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(git)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
        ApiEndPoint gitHub= retrofit.create(ApiEndPoint.class);

        RetrieveContent retrieve= new RetrieveContent(gitHub);
        try {
            retrieve.display();
        }catch(Exception e){
            e.printStackTrace();
        }
        ControllerStackOverflow ctrl= new ControllerStackOverflow();
        ctrl.start();
    }
}
