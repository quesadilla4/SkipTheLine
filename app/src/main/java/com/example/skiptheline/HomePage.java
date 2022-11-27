package com.example.skiptheline;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.skiptheline.adapter.RestaurantsAdapter;
import com.example.skiptheline.adapter.quickItemsAdapter;
import com.example.skiptheline.model.Restaurants;
import com.example.skiptheline.model.quickItems;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends AppCompatActivity {

    RecyclerView foodRecycler, quickRecycler;
    RestaurantsAdapter restaurantsAdapter;
    quickItemsAdapter quickItemsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        List<Restaurants> restaurantList = new ArrayList<>();
        restaurantList.add(new Restaurants("The Well Pub", R.drawable.well_logo_2022_23_outlined_grey_e1663865526920));
        restaurantList.add(new Restaurants("Koi Sushi", R.drawable.koi));
        restaurantList.add(new Restaurants("Fusion Express", R.drawable.fusion));
        restaurantList.add(new Restaurants("Comma", R.drawable.comma));
        restaurantList.add(new Restaurants("Sunshine", R.drawable.sunshine));

        setFoodRecycler(restaurantList);

        List<quickItems> quickItemsList = new ArrayList<>();
        quickItemsList.add(new quickItems("Cheese/Chicken Quesadilla\nPrep Time: 10-15 Minutes", R.drawable.quesadilla,"The Well Pub", "$13.49"));
        quickItemsList.add(new quickItems("Butter Chicken\nPrep Time: 10-15 Minutes", R.drawable.butterchicken,"Fusion Express", "$10.99"));
        quickItemsList.add(new quickItems("California Rolls\nPrep Time: 5-10 Minutes", R.drawable.sushi,"Koi Sushi", "$12.49"));
        quickItemsList.add(new quickItems("Vanilla Latte\nPrep Time: 3-5 Minutes", R.drawable.latte,"Comma", "$7.49"));

        setQuickRecycler((quickItemsList));
    }

    private void setFoodRecycler(List<Restaurants> restaurantsList){
        foodRecycler = findViewById(R.id.food_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        foodRecycler.setLayoutManager(layoutManager);
        restaurantsAdapter = new RestaurantsAdapter(this, restaurantsList);
        foodRecycler.setAdapter(restaurantsAdapter);
    }
    private void setQuickRecycler(List<quickItems> quickItemsList){
        quickRecycler = findViewById(R.id.quick_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        quickRecycler.setLayoutManager(layoutManager);
        quickItemsAdapter = new quickItemsAdapter(this, quickItemsList);
        quickRecycler.setAdapter(quickItemsAdapter);
    }
}