package com.example.demoapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.demoapplication.R;
import com.example.demoapplication.adapter.MovieAdapter;
import com.example.demoapplication.adapter.RecycleProductAdapter;
import com.example.demoapplication.api.ApiService;
import com.example.demoapplication.api.RetrofitHelper;
import com.example.demoapplication.database.DBHandler;
import com.example.demoapplication.movie.MovieContainer;
import com.example.demoapplication.movie.MovieResult;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private RecyclerView recycleView;
    private MovieAdapter adapter;
    private DBHandler dbHandler;

    //for api
    private ApiService service = RetrofitHelper.getClient().create(ApiService.class);
    private List<MovieResult> movieResultList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        initToolbar();
        dbHandler = new DBHandler(this);
        setAPICall();
    }

    private void initToolbar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.movie);

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
        recycleView = findViewById(R.id.MovieRecycleView);
        adapter = new MovieAdapter(this, movieResultList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recycleView.setLayoutManager(linearLayoutManager);
        recycleView.setAdapter(adapter);
    }


    //for api
    private void setAPICall() {
        Call<MovieContainer> call = service.getMovieData("ef8f48b43832a9e95b87408bf739ed51");
        call.enqueue(new Callback<MovieContainer>() {
            @Override
            public void onResponse(Call<MovieContainer> call, Response<MovieContainer> response) {
                if(response.isSuccessful()) {
                    MovieContainer movieContainer = response.body();
                    movieResultList.addAll(movieContainer.getMovieList());

                    findViews();

                    for (MovieResult result :
                            movieResultList) {
                        dbHandler.insertNewData(result.getOriginalTitle(),
                                result.getReleaseDate(),
                                result.getOverview(),
                                result.getPosterPath());
                    }
                }
//                else {
//
//                }
            }

            @Override
            public void onFailure(Call<MovieContainer> call, Throwable t) {

            }
        });
    }

    //for img render from url
//    Picaso.get()
//    .Load("https://image.tmdb.org/t/b/w500" + movieresult.getPosterPath)
//        .into(holder.imgMovie);


}