package com.example.skiptheline;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import com.example.skiptheline.adapter.RestaurantsAdapter;
import com.example.skiptheline.adapter.quickItemsAdapter;
import com.example.skiptheline.model.Restaurants;
import com.example.skiptheline.model.quickItems;
import java.util.ArrayList;
import java.util.List;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toolbar;
import com.google.android.material.navigation.NavigationView;

public class HomePage extends AppCompatActivity {
    RecyclerView foodRecycler, quickRecycler;
    RestaurantsAdapter restaurantsAdapter;
    quickItemsAdapter quickItemsAdapter;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle actionBarDrawerToggle;


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_baseline_shopping_cart_24);
        getSupportActionBar().setTitle("             Skip-The-Line");
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigationView);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.menu_Open, R.string.close_menu);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_orders:
                        Log.i("MENU_DRAWER_TAG", "Orders item is clicked");
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.nav_payment:
                        Log.i("MENU_DRAWER_TAG", "Payment item is clicked");
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.nav_help:
                        Log.i("MENU_DRAWER_TAG", "Help item is clicked");
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                }
                return true;
            }
        });
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