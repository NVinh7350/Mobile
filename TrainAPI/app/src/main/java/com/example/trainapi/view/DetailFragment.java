package com.example.trainapi.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.trainapi.R;
import com.example.trainapi.databinding.FragmentDetailBinding;
import com.example.trainapi.model.Dog;
import com.squareup.picasso.Picasso;

public class DetailFragment extends Fragment {
    private Dog dog;
    private FragmentDetailBinding binding;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.inflate(getLayoutInflater(),R.layout.fragment_detail,null, false);
        if (getArguments() != null) {
            dog =(Dog) getArguments().getSerializable("dog");
            Picasso.get().load(dog.getUrl()).into(binding.imageDetail);
            binding.setDog(dog);
        }
        binding.buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return  binding.getRoot();
    }
}