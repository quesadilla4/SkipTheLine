package com.example.skiptheline;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.skiptheline.adapter.RestaurantsAdapter;
import com.example.skiptheline.adapter.quickItemsAdapter;
import com.example.skiptheline.model.quickItems;

import java.util.ArrayList;
import java.util.List;

public class ShowRestaurantItemsActivity extends AppCompatActivity {

    RecyclerView quickRecycler;

    quickItemsAdapter quickItemsAdapter;
    TextView restNameTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_restaurant_items);

        Intent intent = getIntent();
        String name = intent.getStringExtra("restaurantName");

        restNameTV = findViewById(R.id.showRestName);
        restNameTV.setText(name);
        List<quickItems> quickItemsList = new ArrayList<>();
        if (name.equals("Koi Sushi")) {
            quickItemsList.add(new quickItems("Tuna roll\nPrep Time: 10-15 Minutes", R.drawable.tuna, "Koi Sushi", "7.49"));
            quickItemsList.add(new quickItems("Salmon roll\nPrep Time: 10-15 Minutes", R.drawable.salmon, "Koi Sushi", "$8.99"));
            quickItemsList.add(new quickItems("California Rolls\nPrep Time: 5-10 Minutes", R.drawable.sushi, "Koi Sushi", "$12.49"));
            quickItemsList.add(new quickItems("Combo A\nPrep Time: 5-10 Minutes", R.drawable.combo, "Koi Sushi", "$17.49"));
        } else if (name.equals("Fusion Express"))
        {
            quickItemsList.add(new quickItems("Butter Chicken\nPrep Time: 10-15 Minutes", R.drawable.butterchicken, "Fusion Express", "10.99"));
            quickItemsList.add(new quickItems("Samosa roll\nPrep Time: 10-15 Minutes", R.drawable.samosa, "Fusion Express", "$8.99"));
            quickItemsList.add(new quickItems("Energy Drink\nPrep Time: 1 Minute", R.drawable.rockstar, "Fusion Express", "3.49"));
        }
        else if (name.equals("The Well Pub"))
        {
            quickItemsList.add(new quickItems("Cheese/Chicken Quesadilla\nPrep Time: 10-15 Minutes", R.drawable.quesadilla, "The Well Pub", "10.99"));
            quickItemsList.add(new quickItems("BLT sandwich\nPrep Time: 10-15 Minutes", R.drawable.blt, "The Well Pub", "$11.99"));
            quickItemsList.add(new quickItems("Brownie\nPrep Time: 5-10 Minutes", R.drawable.brownie, "The Well Pub", "5.49"));
        }
        else if(name.equals("Comma"))
        {
            quickItemsList.add(new quickItems("Vanilla Latte\nPrep Time: 3-5 Minutes", R.drawable.latte, "Comma", "$7.49"));
        }
        else if(name.equals("Sunshine"))
        {
            quickItemsList.add(new quickItems("Sunshine burger\nPrep Time: 20 - 30 Minutes", R.drawable.burger, "Sunshine", "$17.49"));
        }
        else {
            quickItemsList.add(new quickItems("Cheese/Chicken Quesadilla\nPrep Time: 10-15 Minutes", R.drawable.quesadilla, "The Well Pub", "$13.49"));
            quickItemsList.add(new quickItems("Butter Chicken\nPrep Time: 10-15 Minutes", R.drawable.butterchicken, "Fusion Express", "$10.99"));
            quickItemsList.add(new quickItems("California Rolls\nPrep Time: 5-10 Minutes", R.drawable.sushi, "Koi Sushi", "$12.49"));
            quickItemsList.add(new quickItems("Vanilla Latte\nPrep Time: 3-5 Minutes", R.drawable.latte, "Comma", "$7.49"));
        }
        setQuickRecycler((quickItemsList));
    }

    private void setQuickRecycler(List<quickItems> quickItemsList){
        quickRecycler = findViewById(R.id.food_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        quickRecycler.setLayoutManager(layoutManager);
        quickItemsAdapter = new quickItemsAdapter(this, quickItemsList);
        quickRecycler.setAdapter(quickItemsAdapter);
    }
}