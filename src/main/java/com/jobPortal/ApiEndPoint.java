package com.jobPortal;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface ApiEndPoint {
    @Headers("Content-type: application/json")
    @GET("/positions.json")
    Call<String> githubDisplay();


}
