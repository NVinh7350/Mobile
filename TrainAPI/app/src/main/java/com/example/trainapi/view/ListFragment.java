package com.example.trainapi.view;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.trainapi.R;
import com.example.trainapi.databinding.FragmentListBinding;
import com.example.trainapi.model.Dog;
import com.example.trainapi.viewmodel.ApiService;
import com.example.trainapi.viewmodel.AppDao;
import com.example.trainapi.viewmodel.AppDatabase;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.observers.DisposableSingleObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;
public class ListFragment extends Fragment {
    private ApiService dogsApiService;
    private FragmentListBinding binding;
    private ArrayList<Dog> dogList;
    private AppDatabase appDatabase;
    private AppDao appDao;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentListBinding.inflate(getLayoutInflater());
        return binding.getRoot();

    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        appDatabase = AppDatabase.getInstance(getContext());
        appDao = appDatabase.contactDao();

        dogList = new ArrayList<Dog>();
        dogsApiService = new ApiService();
        dogsApiService.getDogs()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<List<Dog>>() {
                    @Override
                    public void onSuccess(@NonNull List<Dog> dogBreeds) {
                        for (Dog dog : dogBreeds) {
                            dogList.add(dog);
                            Log.e("Success",dog.getName());
                            AsyncTask.execute(new Runnable() {
                                @Override

                                public void run() {
                                    try{
                                        appDao.insertAll(dog);
                                        Log.e("Success","Done save database");
                                    }
                                    catch (Exception e)
                                    {
                                        Log.e("Exception","Fail");
                                    }
                                }
                            });
                        }
                        binding.recyclerview.setLayoutManager(new GridLayoutManager(getContext(), 2));
                        binding.recyclerview.setAdapter(new Adapter(getContext(), dogList));
                    }

                    @Override
                    public void onError(@io.reactivex.rxjava3.annotations.NonNull Throwable e) {
                    }
                });
    }
}