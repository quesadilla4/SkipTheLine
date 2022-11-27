package com.example.skiptheline.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.skiptheline.model.Restaurants;

public class RestaurantsAdapater extends RecyclerView.Adapter<RestaurantsAdapater.RestaurantsViewHolder> {

    Context context;
    List<Restaurants> RestaurantsList;

    @NonNull
    @Override
    public RestaurantsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantsViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return RestaurantsList.size();
    }


    public static final class RestaurantsViewHolder extends RecyclerView.ViewHolder{

        public RestaurantsViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}
