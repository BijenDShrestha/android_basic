package com.example.demoapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.demoapplication.adapter.ListAdapter;
import com.example.demoapplication.Product;
import com.example.demoapplication.R;
import com.example.demoapplication.api.ApiService;
import com.example.demoapplication.api.RetrofitHelper;
import com.example.demoapplication.movie.MovieContainer;
import com.example.demoapplication.movie.MovieResult;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SettingActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private ListView listView;
    private ListAdapter adapter;
    private List<Product> productList = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        initToolbar();
        setData();
        findViews();

    }


    private void initToolbar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.setting);

        //for back button in toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setDisplayShowTitleEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    private void findViews(){
        listView = findViewById(R.id.listView);
        adapter = new ListAdapter(productList, this);
        listView.setAdapter(adapter);
    }

    private void setData() {
        Product p1 = new Product();
        Product p2 = new Product();
        Product p3 = new Product();
        Product p4 = new Product();
        Product p5 = new Product();

        p1.setTitle("apple");
        p2.setTitle("app");
        p3.setTitle("ape");
        p4.setTitle("aple");
        p5.setTitle("aple");

        p1.setDescription("This is apple");
        p2.setDescription("This is pple");
        p3.setDescription("This  apple");
        p4.setDescription("The is apple");
        p5.setDescription("Ts is apple");

        p1.setPrice("100");
        p2.setPrice("00");
        p3.setPrice("10");
        p4.setPrice("100.00");
        p5.setPrice("10.789");


        p1.setUnit("1334");
        p2.setUnit("133");
        p3.setUnit("134");
        p4.setUnit("134");
        p5.setUnit("334");


        productList.add(p1);
        productList.add(p2);
        productList.add(p3);
        productList.add(p4);
        productList.add(p5);
    }


}