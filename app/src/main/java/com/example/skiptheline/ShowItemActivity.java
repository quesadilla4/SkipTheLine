package com.example.skiptheline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.skiptheline.model.checkout;

public class ShowItemActivity extends AppCompatActivity {

    ImageView imageView;
    TextView tvName, tvPrepTime, tvPrice;

    Button bAdd;
    String itemName, itemPrepTime, itemPrice;
    int imageUrl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_item);

        Intent intent = getIntent();
        Bundle dataBundle = intent.getExtras();

        itemName = dataBundle.getString("itemName");
        itemPrepTime = dataBundle.getString("restaurantName");
        itemPrice = dataBundle.getString("itemPrice");
        imageUrl = dataBundle.getInt("imageUrl");



        imageView = findViewById(R.id.imageViewShow);
        imageView.setImageResource(imageUrl);

        tvName = findViewById(R.id.textViewShowName);
        tvName.setText(itemName);

        tvPrepTime = findViewById(R.id.textViewShowTime);
        tvPrepTime.setText(itemPrepTime);


        tvPrice = findViewById(R.id.textViewItemPrice);
        tvPrice.setText(itemPrice);

        bAdd = findViewById(R.id.btnAddToCart);
        bAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HomePage.listOfAddedItems.add(new checkout(itemName,itemPrice));
                HomePage.cartSum+=Double.parseDouble(itemPrice.substring(1));
                Toast.makeText(ShowItemActivity.this, "Added to Cart!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }
}