package com.jobPortal;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface ApiEndPoint {
    @Headers("Content-type: application/json")
    @GET("/positions.json")
    Call<String> githubDisplay();

    @GET("article.rss")
    Call<RSSFeed> loadRSSFeed(@Path("title") String title, @Path("location") String location);
}
