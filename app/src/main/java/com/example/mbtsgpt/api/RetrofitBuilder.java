package com.example.mbtsgpt.api;

import com.example.mbtsgpt.api.ApiInterface;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitBuilder extends ApiURL {
    private OkHttpClient client = new OkHttpClient.Builder()
            .addInterceptor(new AppInterceptor())
            .build();

    public ApiInterface retrofitBuilder = new Retrofit.Builder()
            .baseUrl(API_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(ApiInterface.class);

}



