package com.example.trainapi.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trainapi.R;
import com.example.trainapi.model.Dog;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>  {
    private Context context;
    private Dog dog;
    private static ArrayList<Dog> dogs;

    public Adapter(Context context, ArrayList<Dog> dogs)
    {
        this.dogs = dogs;
        this.context = context;
    }
    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        dog = dogs.get(position);
        holder.textViewName.setText(dog.getName());
        holder.textViewInfo.setText(dog.getTemperament());
        try{
            Picasso.get().load(dog.getUrl()).into(holder.imageView);

        }catch (Exception e){
            holder.imageView.setImageResource(R.drawable.ic_baseline_favorite_24);
        }

        holder.likeButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b == false)
                {
                    holder.likeButton.setBackgroundResource(R.drawable.ic_baseline_favorite_border_24);
                }
                else
                    holder.likeButton.setBackgroundResource(R.drawable.ic_baseline_favorite_24);
            }
        });
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dog = dogs.get(position);
                Intent intent= new Intent(context,DetailFragment.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("dog", dog);
                intent.putExtras(bundle);
                Navigation.findNavController(view).navigate(R.id.detailFragment,bundle);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dogs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public androidx.cardview.widget.CardView  cardView;
        public TextView textViewName;
        public TextView textViewInfo;
        public ImageView imageView;
        public ToggleButton likeButton;
        public ViewHolder(View view){
            super(view);
            cardView = view.findViewById(R.id.card_view);
            textViewName = view.findViewById(R.id.text_name);
            textViewInfo = view.findViewById(R.id.text_info);
            imageView = view.findViewById(R.id.image_dog);
            likeButton = view.findViewById(R.id.like_button);
        }
    }
}
