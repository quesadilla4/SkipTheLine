package com.example.skiptheline;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.skiptheline.adapter.checkoutAdapter;
import com.example.skiptheline.model.checkout;

import java.util.ArrayList;
import java.util.List;

public class checkoutPage extends AppCompatActivity {
    RecyclerView checkoutRecycler;
    com.example.skiptheline.adapter.checkoutAdapter checkoutAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout_page);


        List<checkout> checkoutList = new ArrayList<>();
        checkoutList.add(new checkout("Crispy Chicken Quesadilla\nPrep Time: 5-10 Minutes", "$13.49"));
        checkoutList.add(new checkout("Butter Chicken\nPrep Time: 15-20 Minutes", "$10.99"));
        checkoutList.add(new checkout("Peppperoni Pizza\nPrep Time: 10-15 Minutes", "$11.59"));
        checkoutList.add(new checkout("Crispy Chicken Parm\nPrep Time: 5-10 Minutes", "$12.99"));

        checkoutRecycler((checkoutList));
    }

    private void checkoutRecycler(List<checkout> checkoutList) {
        checkoutRecycler = findViewById(R.id.checkout_Recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        checkoutRecycler.setLayoutManager(layoutManager);
        checkoutAdapter = new checkoutAdapter(this, checkoutList);
        checkoutRecycler.setAdapter(checkoutAdapter);
    }
}