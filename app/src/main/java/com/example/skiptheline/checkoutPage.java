package com.example.skiptheline;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
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
        Button b = (Button) findViewById(R.id.button2);
        Intent intent1 = new Intent(checkoutPage.this, OrderSummaryActivity.class);


        List<checkout> checkoutList = new ArrayList<>();
        checkoutList.add(new checkout("Crispy Chicken Quesadilla\nPrep Time: 5-10 Minutes", "$13.49"));
        checkoutList.add(new checkout("Butter Chicken\nPrep Time: 15-20 Minutes", "$10.99"));
        checkoutList.add(new checkout("Peppperoni Pizza\nPrep Time: 10-15 Minutes", "$11.59"));
        checkoutList.add(new checkout("Crispy Chicken Parm\nPrep Time: 5-10 Minutes", "$12.99"));

        checkoutRecycler((checkoutList));

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent1);
            }
        });
    }

    private void checkoutRecycler(List<checkout> checkoutList) {
        checkoutRecycler = findViewById(R.id.checkout_Recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        checkoutRecycler.setLayoutManager(layoutManager);
        checkoutAdapter = new checkoutAdapter(this, checkoutList);
        checkoutRecycler.setAdapter(checkoutAdapter);
    }


}