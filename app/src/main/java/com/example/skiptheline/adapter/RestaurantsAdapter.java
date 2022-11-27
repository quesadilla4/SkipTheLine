package com.example.skiptheline.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.skiptheline.R;
import com.example.skiptheline.model.Restaurants;

public class RestaurantsAdapter extends RecyclerView.Adapter<RestaurantsAdapter.RestaurantsViewHolder> {

    Context context;
    List<Restaurants> RestaurantsList;

    public RestaurantsAdapter(Context context, List<Restaurants> restaurantsList) {
        this.context = context;
        this.RestaurantsList = restaurantsList;
    }

    @NonNull
    @Override
    public RestaurantsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.restaurants_row_item, parent, false);
        return new RestaurantsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantsViewHolder holder, int position) {

        holder.foodImage.setImageResource(RestaurantsList.get(position).getImageUrl());
        holder.name.setText(RestaurantsList.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return RestaurantsList.size();
    }


    public static final class RestaurantsViewHolder extends RecyclerView.ViewHolder{

        ImageView foodImage;
        TextView name;

        public RestaurantsViewHolder(@NonNull View itemView) {
            super(itemView);

            foodImage = itemView.findViewById(R.id.well_logo);
            name = itemView.findViewById(R.id.food_name);

        }
    }

}
