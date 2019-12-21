package com.redcells.api;

import com.redcells.models.News;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("https://newsapi.org/v2/top-headlines?country=in&category=health&apiKey=e3eb00e5f12847e19524191b4e9ca54a")
    Call<News> getNews(

            @Query("country") String country,
            @Query("apiKey") String apiKey

    );

    @GET("everything")
    Call<News> getNewsSearch(

            @Query("q") String keyword,
            @Query("language") String language,
            @Query("sortBy") String sortBy,
            @Query("apiKey") String apiKey

    );

}
