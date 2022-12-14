package com.example.skiptheline.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.skiptheline.HomePage;
import com.example.skiptheline.R;
import com.example.skiptheline.ShowItemActivity;
import com.example.skiptheline.model.checkout;
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
        holder.bAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(context, "Added item num"+position, Toast.LENGTH_SHORT).show();
                HomePage.listOfAddedItems.add(new checkout(holder.name.getText().toString(), holder.price.getText().toString()));
                HomePage.cartSum+=Double.parseDouble(holder.price.getText().toString().substring(1));
            }
        });

        holder.foodImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle dataBundle = new Bundle();
                dataBundle.putInt("imageUrl",quickItemsList.get(position).getImageUrl());
                dataBundle.putString("itemName",quickItemsList.get(position).getName());
                dataBundle.putString("itemPrice",quickItemsList.get(position).getPrice());
                dataBundle.putString("restaurantName",quickItemsList.get(position).getRestaurantName());

                Intent intent = new Intent(context, ShowItemActivity.class);
                intent.putExtras(dataBundle);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return quickItemsList.size();
    }


    public static final class QuickItemsViewHolder extends RecyclerView.ViewHolder{

        ImageView foodImage;
        TextView name, price, restaurantName;
        ImageButton bAdd;

        public QuickItemsViewHolder(@NonNull View itemView) {
            super(itemView);

            foodImage = itemView.findViewById(R.id.food);
            name = itemView.findViewById(R.id.food_name);
            price = itemView.findViewById(R.id.price);
            restaurantName = itemView.findViewById(R.id.restaurantName);
            bAdd = itemView.findViewById(R.id.imageButton3);
        }
    }

}
