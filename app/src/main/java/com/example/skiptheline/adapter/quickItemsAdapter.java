package com.example.skiptheline.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.skiptheline.R;
import com.example.skiptheline.model.quickItems;

import java.util.List;

public class quickItemsAdapter extends RecyclerView.Adapter<quickItemsAdapter.QuickItemsViewHolder> {

    Context context;
    List<quickItems> quickItemsList;

    public quickItemsAdapter(Context context, List<quickItems> quickItemsList) {
        this.context = context;
        this.quickItemsList = quickItemsList;
    }

    @NonNull
    @Override
    public QuickItemsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.quick_items_row_item, parent, false);
        return new QuickItemsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(QuickItemsViewHolder holder, int position) {

        holder.foodImage.setImageResource(quickItemsList.get(position).getImageUrl());
        holder.name.setText(quickItemsList.get(position).getName());
        holder.price.setText(quickItemsList.get(position).getPrice());
        holder.restaurantName.setText(quickItemsList.get(position).getRestaurantName());

    }

    @Override
    public int getItemCount() {
        return quickItemsList.size();
    }


    public static final class QuickItemsViewHolder extends RecyclerView.ViewHolder{

        ImageView foodImage;
        TextView name, price, restaurantName;

        public QuickItemsViewHolder(@NonNull View itemView) {
            super(itemView);

            foodImage = itemView.findViewById(R.id.food);
            name = itemView.findViewById(R.id.food_name);
            price = itemView.findViewById(R.id.price);
            restaurantName = itemView.findViewById(R.id.restaurantName);

        }
    }

}
