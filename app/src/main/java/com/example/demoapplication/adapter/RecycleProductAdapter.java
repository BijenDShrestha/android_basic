package com.example.demoapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demoapplication.Product;
import com.example.demoapplication.R;
import com.example.demoapplication.viewholder.RecycleProductViewHolder;

import java.util.ArrayList;
import java.util.List;

public class RecycleProductAdapter extends RecyclerView.Adapter<RecycleProductViewHolder> {
    private List<Product> productList = new ArrayList<>();
    private Context context;

    public RecycleProductAdapter(List<Product> productList, Context context) {
        this.productList.addAll(productList);
        this.context = context;
    }

    @NonNull
    @Override
    public RecycleProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_product_adapter, parent, false);
        return new RecycleProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleProductViewHolder holder, int position) {
        holder.txtTitle.setText(productList.get(position).getTitle());
        holder.txtDescription.setText(productList.get(position).getDescription());
        holder.txtUnit.setText(productList.get(position).getUnit());
        holder.txtPrice.setText(productList.get(position).getPrice());
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }
}
