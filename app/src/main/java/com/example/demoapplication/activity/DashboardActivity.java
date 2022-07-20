package com.example.demoapplication.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.demoapplication.HomeFragment;
import com.example.demoapplication.ProfileFragment;
import com.example.demoapplication.R;
import com.example.demoapplication.adapter.ViewPagerAdapter;
import com.example.demoapplication.map.MapsActivity;
import com.google.android.material.tabs.TabLayout;

public class DashboardActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;
    private String username;
    private Integer userId;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        username = getIntent().getStringExtra("username");
//        userId = getIntent().getIntExtra("userId", 0);
//        password = getIntent().getStringExtra("password");

        Toast.makeText(DashboardActivity.this, "Welcome " + username, Toast.LENGTH_SHORT).show();

        initToolbar();
        findViews();

        setUpViewPager();
        tabLayout.setupWithViewPager(viewPager);

    }

    private void findViews() {
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);


    }

    private void initToolbar() {
        toolbar = findViewById(R.id.toolbar);

        getMenuInflater().inflate(R.menu.main_menu, toolbar.getMenu());

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.welcome);

        //for back button in toolbar
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setDisplayShowTitleEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            case(R.id.logOutButton):
                Intent intent = new Intent(DashboardActivity.this, LoginActivity.class);
                startActivity(intent);
                return true;

            case(R.id.settingButton):
                Intent newIntent = new Intent(DashboardActivity.this, SettingActivity.class);
                startActivity(newIntent);
                return true;

            case(R.id.gridButton):
                Intent newIntentGrid = new Intent(DashboardActivity.this, GridActivity.class);
                startActivity(newIntentGrid);
                return true;

            case(R.id.recycleButton):
                Intent newIntentRecycle = new Intent(DashboardActivity.this, RecycleActivity.class);
                startActivity(newIntentRecycle);
                return true;

            case(R.id.uploadImage):
                Intent newIntentUploadImage = new Intent(DashboardActivity.this, ImagePickActivity.class);
                startActivity(newIntentUploadImage);
                return true;

            case(R.id.viewMovie):
                Intent newIntentViewMovie = new Intent(DashboardActivity.this, MovieActivity.class);
                startActivity(newIntentViewMovie);
                return true;

            case(R.id.viewMap):
                Intent newIntentViewMap = new Intent(DashboardActivity.this, MapsActivity.class);
                startActivity(newIntentViewMap);
                return true;

            default:
                return false;

        }

//        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    private void setUpViewPager(){
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new HomeFragment(), "Home");
        viewPagerAdapter.addFragment(new ProfileFragment(), "Profile");

        viewPager.setAdapter(viewPagerAdapter);
    }
}