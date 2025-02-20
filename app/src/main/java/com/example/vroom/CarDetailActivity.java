package com.example.vroom;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

public class CarDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_detail);

        // Get data from intent
        String carId = getIntent().getStringExtra("car_id");
        String carName = getIntent().getStringExtra("car_name");
        String carBrand = getIntent().getStringExtra("car_brand");
        double carPrice = getIntent().getDoubleExtra("car_price", 0.0);
        String carImage = getIntent().getStringExtra("car_image");

        // Initialize views
        ImageView imageView = findViewById(R.id.carDetailImage);
        TextView nameText = findViewById(R.id.carDetailName);
        TextView priceText = findViewById(R.id.carDetailPrice);
        Button purchaseButton = findViewById(R.id.purchaseButton);

        // Set data to views
        nameText.setText(carName);
        priceText.setText(String.format("$%,.2f", carPrice));

        // Load image
        int resourceId = getResources().getIdentifier(carImage, "drawable", getPackageName());
        imageView.setImageResource(resourceId);

        // Handle purchase button click
        purchaseButton.setOnClickListener(v -> {
            // Implement purchase logic here
            Toast.makeText(this, "Processing purchase for " + carName, Toast.LENGTH_SHORT).show();
        });
    }
} 