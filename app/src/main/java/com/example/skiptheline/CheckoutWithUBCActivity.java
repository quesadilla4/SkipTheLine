package com.example.skiptheline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheckoutWithUBCActivity extends AppCompatActivity {

    Button bCheckout;
    TextView textViewShowTotal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout_with_ubcactivity);

        textViewShowTotal = findViewById(R.id.tvShowTotal);

        Intent sendingIntent = getIntent();
        String total = sendingIntent.getStringExtra("total");
        textViewShowTotal.setText(total);

        Intent intent1 = new Intent(CheckoutWithUBCActivity.this, OrderSummaryActivity.class);
        bCheckout = findViewById(R.id.payCreditCardBtn);

        bCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent1);
            }
        });
    }
}