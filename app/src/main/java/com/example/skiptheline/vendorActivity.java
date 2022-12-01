package com.example.skiptheline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class vendorActivity extends AppCompatActivity {

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
    }
}