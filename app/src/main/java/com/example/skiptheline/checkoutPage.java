package com.example.skiptheline;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.skiptheline.adapter.checkoutAdapter;
import com.example.skiptheline.model.checkout;

import java.util.List;

public class checkoutPage extends AppCompatActivity {
    RecyclerView checkoutRecycler;
    com.example.skiptheline.adapter.checkoutAdapter checkoutAdapter;
    public static TextView tvSubtotal, tvTax, tvTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout_page);
        Button b = (Button) findViewById(R.id.buttonCheckoutUBC);
        Button b2 = (Button) findViewById(R.id.buttonCheckoutCredit);
        Intent intent1 = new Intent(checkoutPage.this, CheckoutWithUBCActivity.class);
        Intent intent2 = new Intent(checkoutPage.this, CheckoutWithCreditActivity.class);
        //set static textviews that will be updated in checkout adapter
        tvSubtotal = findViewById(R.id.textView10);
        tvTax = findViewById(R.id.textView11);
        tvTotal = findViewById(R.id.textView12);
/*
        List<checkout> checkoutList = new ArrayList<>();
        checkoutList.add(new checkout("Crispy Chicken Quesadilla\nPrep Time: 5-10 Minutes", "$13.49"));
        checkoutList.add(new checkout("Butter Chicken\nPrep Time: 15-20 Minutes", "$10.99"));
        checkoutList.add(new checkout("Peppperoni Pizza\nPrep Time: 10-15 Minutes", "$11.59"));
        checkoutList.add(new checkout("Crispy Chicken Parm\nPrep Time: 5-10 Minutes", "$12.99"));
*/
        checkoutRecycler((HomePage.listOfAddedItems));

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                intent1.putExtra("total",tvTotal.getText());
                startActivity(intent1);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent2.putExtra("total",tvTotal.getText());
                startActivity(intent2);
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