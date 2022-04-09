package com.example.trainapi.viewmodel;

import com.example.trainapi.model.Dog;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;

public interface DogsApi {
    @GET("DevTides/DogsApi/master/dogs.json")
    public Single<List<Dog>> getDogs();
}
