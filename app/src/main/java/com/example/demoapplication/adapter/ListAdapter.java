package com.example.demoapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.demoapplication.Product;
import com.example.demoapplication.R;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends BaseAdapter {
    private List<Product> productList = new ArrayList<>();
    private Context context;

    public ListAdapter(List<Product> productList, Context context) {
        //pass by value
        this.productList.addAll(productList);
        this.context = context;

        //pass by reference
        // when the constructor is called with .clear() function then, it will erase the whole list of product since it is pass by reference
//        this.productList = productList;
    }

    @Override
    public int getCount() {
        return productList.size();
    }

    @Override
    public Object getItem(int i) {
        return productList.get(i);
    }

    //position
    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View viewData = layoutInflater.inflate(R.layout.adapter_product, null);
        ViewHolder holder = new ViewHolder(viewData);

        holder.txtTitle.setText(productList.get(position).getTitle());
        holder.txtDescription.setText(productList.get(position).getDescription());
        holder.txtUnit.setText(productList.get(position).getUnit());
        holder.txtPrice.setText(productList.get(position).getPrice());

        return viewData;
    }

    public static class ViewHolder {
        public TextView txtTitle, txtDescription, txtUnit, txtPrice;

        public ViewHolder(View view) {
            txtTitle = view.findViewById(R.id.product_title);
            txtDescription = view.findViewById(R.id.product_description);
            txtUnit = view.findViewById(R.id.product_unit);
            txtPrice = view.findViewById(R.id.product_price);
        }
    }

}
