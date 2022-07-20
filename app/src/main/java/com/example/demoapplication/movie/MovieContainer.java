package com.example.demoapplication.movie;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieContainer {
    @SerializedName("results")
    @Expose
    List<MovieResult> movieList;

    public List<MovieResult> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<MovieResult> movieList) {
        this.movieList = movieList;
    }
}
