package com.example.demoapplication.api;

import com.example.demoapplication.movie.MovieContainer;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("movie/upcoming")
    Call<MovieContainer> getMovieData(@Query("api_key") String apiKey);
}
