package com.example.demoapplication.viewholder;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demoapplication.R;

public class QuestionThreeViewHolder extends RecyclerView.ViewHolder {
    public ImageView imageView;

    public QuestionThreeViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.questionThree);
    }
}
