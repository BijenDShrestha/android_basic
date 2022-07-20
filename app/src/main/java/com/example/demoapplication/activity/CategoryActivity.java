
package com.example.demoapplication.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.demoapplication.HomeFragment;
import com.example.demoapplication.ProfileFragment;
import com.example.demoapplication.R;

public class CategoryActivity extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        initToolbar();

        getSupportFragmentManager().beginTransaction().add(R.id.frameContainer, new HomeFragment()).commit();
    }

    private void initToolbar(){
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.welcome);

        //for back button in toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setDisplayShowTitleEnabled(true);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home ) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frameContainer, new ProfileFragment()).commit();
        }
        return super.onOptionsItemSelected(item);
    }
}