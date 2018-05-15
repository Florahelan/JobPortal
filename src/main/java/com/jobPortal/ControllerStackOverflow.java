package com.jobPortal;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class ControllerStackOverflow implements Callback<RSSFeed> {

    static final String BASE_URL = Constants.stackoverflow;
    String title="java";
    String location="California";

    public void start() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(SimpleXmlConverterFactory.create()).build();

        ApiEndPoint apiEndPoint = retrofit.create(ApiEndPoint.class);

        Call<RSSFeed> call = apiEndPoint.loadRSSFeed(title, location);
        call.enqueue(this);
    }

    public void onResponse(Call<RSSFeed> call, Response<RSSFeed> response) {
        if (response.isSuccessful()) {
            RSSFeed rss = response.body();
            if (rss != null) {
                System.out.println("Channel title: " + rss.getChannelTitle());
                rss.getElementList().forEach(
                        elementsList -> System.out.println("Title: " + elementsList.getTitle() + " Link: " + elementsList.getLink()));
            }
        } else {
            System.out.println(response.errorBody());
        }
    }
    public void onFailure(Call<RSSFeed> call, Throwable t) {
        t.printStackTrace();
    }
}