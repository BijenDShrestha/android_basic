package com.example.demoapplication.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demoapplication.R;

public class MovieViewHolder extends RecyclerView.ViewHolder {
    public ImageView movieImage;

    public TextView movieTitle, movieDescription;

    public MovieViewHolder(@NonNull View itemView) {
        super(itemView);
        movieImage = itemView.findViewById(R.id.movie_image);
        movieTitle = itemView.findViewById(R.id.movie_title);
        movieDescription = itemView.findViewById(R.id.movie_description);
    }
}
