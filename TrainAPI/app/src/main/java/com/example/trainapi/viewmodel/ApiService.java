package com.example.trainapi.viewmodel;

import com.example.trainapi.model.Dog;

import java.util.List;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import io.reactivex.rxjava3.core.Single;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {
    private static final String BASE_URL="https://raw.githubusercontent.com";
    private DogsApi api;

    public ApiService()
    {
        api = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build()
                .create(DogsApi.class);
    }

    public Single<List<Dog>> getDogs(){
        return api.getDogs();
    }
}
