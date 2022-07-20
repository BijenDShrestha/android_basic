package com.example.demoapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demoapplication.R;
import com.example.demoapplication.movie.MovieResult;
import com.example.demoapplication.viewholder.MovieViewHolder;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class MovieAdapter extends RecyclerView.Adapter<MovieViewHolder> {
    private Context context;
    private List<MovieResult> movieResultList = new ArrayList<>();

    public MovieAdapter(Context context, List<MovieResult> movieResultList) {
        this.context = context;
        this.movieResultList = movieResultList;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_adapter, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        Picasso.get()
                .load("https://image.tmdb.org/t/p/w500/" + movieResultList.get(position).getPosterPath())
                .into(holder.movieImage);
        holder.movieTitle.setText(movieResultList.get(position).getOriginalTitle());
        holder.movieDescription.setText(movieResultList.get(position).getOverview());
    }

    @Override
    public int getItemCount() {
        return movieResultList.size();
    }
}
