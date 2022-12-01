package com.example.skiptheline;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.skiptheline.adapter.checkoutAdapter;
import com.example.skiptheline.adapter.vendorItemAdapter;
import com.example.skiptheline.model.checkout;
import com.example.skiptheline.model.vendorItem;

import java.util.ArrayList;
import java.util.List;

public class vendorActivity extends AppCompatActivity {

    RecyclerView vendorRecycler;
    com.example.skiptheline.adapter.vendorItemAdapter vendorItemAdapter;
    ImageButton bStats,bLogOut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendor);
        bStats =findViewById(R.id.imageButtonStats);
        bLogOut =findViewById(R.id.imageButtonLogOut);
        bStats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(vendorActivity.this, VendorAnalyticsActivity.class);
                startActivity(intent);
            }
        });

        bLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        List<vendorItem> vendorItemList = new ArrayList<>();
        vendorItemList.add(new vendorItem("#XYZ123","Tuna roll","Salmon roll", "Noodles","$33.49"));
        vendorItemList.add(new vendorItem("#XYZ124","Avocado roll","Sashimi", "Noodles", "$42.99"));
        vendorItemList.add(new vendorItem("#XYZ125", "Tuna roll","Salmon roll", "Avocado roll","$22.59"));
        vendorItemList.add(new vendorItem("#XYZ126", "Crab roll","Chicken roll", "Beef roll","$30.99"));
        vendorRecycler(vendorItemList);

    }

    private void vendorRecycler(List<vendorItem> vendorItemList) {
        vendorRecycler = findViewById(R.id.vendor_Recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        vendorRecycler.setLayoutManager(layoutManager);
        vendorItemAdapter = new vendorItemAdapter(this, vendorItemList);
        vendorRecycler.setAdapter(vendorItemAdapter);

    }
}