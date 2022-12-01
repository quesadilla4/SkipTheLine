package com.example.skiptheline.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.skiptheline.HomePage;
import com.example.skiptheline.R;
import com.example.skiptheline.checkoutPage;
import com.example.skiptheline.model.checkout;

import java.text.DecimalFormat;
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
        DecimalFormat f = new DecimalFormat("##.00");
        holder.bDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Toast.makeText(context, "To be deleted "+position, Toast.LENGTH_SHORT).show();
                checkoutList.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, checkoutList.size());
                //decrease cart sum


                HomePage.cartSum-=Double.parseDouble(holder.price.getText().toString().substring(1));
                if(checkoutList.size()==0)HomePage.cartSum=0;
                checkoutPage.tvSubtotal.setText("$"+String.format("%.2f",HomePage.cartSum));
                checkoutPage.tvTax.setText("$"+String.format("%.2f",HomePage.cartSum*0.12));
                checkoutPage.tvTotal.setText("$"+String.format("%.2f",HomePage.cartSum+HomePage.cartSum*0.12));
            }
        });
        checkoutPage.tvSubtotal.setText("$"+String.format("%.2f",HomePage.cartSum));
        checkoutPage.tvTax.setText("$"+String.format("%.2f",HomePage.cartSum*0.12));
        checkoutPage.tvTotal.setText("$"+String.format("%.2f",HomePage.cartSum+HomePage.cartSum*0.12));


    }

    @Override
    public int getItemCount() {
        return checkoutList.size();
    }


    public static final class checkoutViewHolder extends RecyclerView.ViewHolder{

        TextView name, price;
        ImageButton bDelete;

        public checkoutViewHolder(@NonNull View itemView) {
            super(itemView);


            name = itemView.findViewById(R.id.food_name);
            price = itemView.findViewById(R.id.price);
            bDelete= itemView.findViewById(R.id.delete);



        }
    }

}
