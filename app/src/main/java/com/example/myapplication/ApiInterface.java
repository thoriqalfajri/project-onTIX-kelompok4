package com.example.myapplication;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("discover/movie")
    Call<MovieResponse> getMovie(@Query("api_key") String apiKey, @Query("language") String language);
}
