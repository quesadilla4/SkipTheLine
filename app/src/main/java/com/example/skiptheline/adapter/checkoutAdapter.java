package com.example.skiptheline.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.skiptheline.R;
import com.example.skiptheline.model.checkout;

import java.util.List;

public class checkoutAdapter extends RecyclerView.Adapter<checkoutAdapter.checkoutViewHolder> {

    Context context;
    List<checkout> checkoutList;

    public checkoutAdapter(Context context, List<checkout> checkoutList) {
        this.context = context;
        this.checkoutList = checkoutList;
    }

    @NonNull
    @Override
    public checkoutViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.checkout_page_row_item, parent, false);
        return new checkoutViewHolder(view);
    }


    public void onBindViewHolder(checkoutAdapter.checkoutViewHolder holder, int position) {
        holder.name.setText(checkoutList.get(position).getName());
        holder.price.setText(checkoutList.get(position).getPrice());

    }

    @Override
    public int getItemCount() {
        return checkoutList.size();
    }


    public static final class checkoutViewHolder extends RecyclerView.ViewHolder{

        TextView name, price;

        public checkoutViewHolder(@NonNull View itemView) {
            super(itemView);


            name = itemView.findViewById(R.id.food_name);
            price = itemView.findViewById(R.id.price);


        }
    }

}
