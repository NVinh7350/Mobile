package com.example.trainapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.trainapi.databinding.ActivityMainBinding;
import com.example.trainapi.model.Dog;
import com.example.trainapi.view.Adapter;
import com.example.trainapi.viewmodel.ApiService;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private ApiService dogsApiService;
    private ArrayList<Dog> dogBreedList;
    private Adapter dogAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}
