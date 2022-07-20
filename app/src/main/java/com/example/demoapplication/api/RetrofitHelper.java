package com.example.demoapplication.api;

import androidx.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitHelper {
    public static final String baseUrl = "http://api.themoviedb.org/3/";
    private static Retrofit retrofit = null;
    private static HttpLoggingInterceptor logging = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);

    public static Retrofit getClient() {
        Gson gson = new GsonBuilder().setLenient().create();

        OkHttpClient.Builder httpClient2 = new OkHttpClient.Builder();
        httpClient2.addInterceptor(logging)
                .addNetworkInterceptor(new Interceptor() {
                    @NonNull
                    @Override
                    public Response intercept(@NonNull Chain chain) throws IOException {
                        Request.Builder builder = chain.request().newBuilder();
                        return chain.proceed(builder.build());
                    }
                });
        OkHttpClient client = httpClient2.build();

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit;
    }
}
