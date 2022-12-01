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
import com.example.skiptheline.model.vendorItem;

import java.text.DecimalFormat;
import java.util.List;

public class vendorItemAdapter extends RecyclerView.Adapter<vendorItemAdapter.checkoutViewHolder> {

    Context context;
    List<vendorItem> vendorItemList;

    public vendorItemAdapter(Context context, List<vendorItem> checkoutList) {
        this.context = context;
        this.vendorItemList = checkoutList;
    }

    @NonNull
    @Override
    public checkoutViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.vendor_page_row_item, parent, false);
        return new checkoutViewHolder(view);
    }


    public void onBindViewHolder(vendorItemAdapter.checkoutViewHolder holder, int position) {
        holder.orderNumber.setText("Order number: "+vendorItemList.get(position).getOrderNumber());
        holder.item1.setText(vendorItemList.get(position).getOrderItem1());
        holder.item2.setText(vendorItemList.get(position).getOrderItem2());
        holder.item3.setText(vendorItemList.get(position).getOrderItem3());
        holder.pricetopay.setText(vendorItemList.get(position).getPriceToPay());
        DecimalFormat f = new DecimalFormat("##.00");
        holder.bCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Order "+vendorItemList.get(position).getOrderNumber()+" canceled!", Toast.LENGTH_SHORT).show();
                vendorItemList.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, vendorItemList.size());
                //decrease cart sum

            }
        });

        holder.bAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Order "+vendorItemList.get(position).getOrderNumber()+" confirmed!", Toast.LENGTH_SHORT).show();
                vendorItemList.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, vendorItemList.size());
                //decrease cart sum

            }
        });

    }

    @Override
    public int getItemCount() {
        return vendorItemList.size();
    }


    public static final class checkoutViewHolder extends RecyclerView.ViewHolder{

        TextView orderNumber, item1,item2,item3,pricetopay;
        ImageButton bCancel, bAccept;

        public checkoutViewHolder(@NonNull View itemView) {
            super(itemView);


            orderNumber = itemView.findViewById(R.id.order_number);
            item1 = itemView.findViewById(R.id.order_item1);
            item2 = itemView.findViewById(R.id.order_item2);
            item3 = itemView.findViewById(R.id.order_item3);
            pricetopay = itemView.findViewById(R.id.price_to_pay);
            bCancel= itemView.findViewById(R.id.cancel_order);
            bAccept= itemView.findViewById(R.id.confirm_order);



        }
    }

}
