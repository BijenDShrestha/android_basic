package com.example.demoapplication.viewholder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demoapplication.R;

public class RecycleProductViewHolder extends RecyclerView.ViewHolder {

    public TextView txtTitle, txtDescription, txtUnit, txtPrice;

    public RecycleProductViewHolder(@NonNull View itemView) {
        super(itemView);
        txtTitle = itemView.findViewById(R.id.product_title);
        txtDescription = itemView.findViewById(R.id.product_description);
        txtUnit = itemView.findViewById(R.id.product_unit);
        txtPrice = itemView.findViewById(R.id.product_price);
    }
}
