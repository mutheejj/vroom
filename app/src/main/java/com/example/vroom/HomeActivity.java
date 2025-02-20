package com.example.vroom;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.core.view.GravityCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.vroom.adapters.CarAdapter;
import com.example.vroom.models.Car;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private RecyclerView recyclerView;
    private CarAdapter carAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Initialize Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Initialize DrawerLayout and NavigationView
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        // Set up navigation drawer
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawerLayout, toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        );
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        // Set up RecyclerView
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));

        // Create sample car data
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("1", "Audi Q3", "Luxury compact SUV with quattro all-wheel drive", 35000.00, "audi1"));
        cars.add(new Car("2", "Audi S8", "High-performance luxury sedan", 116000.00, "audi2"));
        cars.add(new Car("3", "Audi RS7", "Sportback with exceptional performance", 118500.00, "audi3"));
        cars.add(new Car("4", "Audi A5", "Sophisticated and sporty coupe", 44000.00, "audi4"));
        cars.add(new Car("5", "Audi e-tron", "All-electric luxury SUV", 65900.00, "audi5"));
        cars.add(new Car("6", "Audi A6", "Executive sedan with premium features", 55900.00, "audi6"));
        cars.add(new Car("7", "Audi RS3", "Compact high-performance sedan", 58900.00, "audi7"));
        cars.add(new Car("8", "Audi RS e-tron GT", "Electric performance grand tourer", 139900.00, "audi8"));
        cars.add(new Car("9", "Audi RS3 Sedan", "Sport sedan with racing DNA", 58900.00, "audi9"));
        cars.add(new Car("10", "Audi R8", "Supercar with everyday usability", 158900.00, "audi10"));

        // Set up adapter
        carAdapter = new CarAdapter(cars, car -> {
            // Button click handler will be implemented later
            Toast.makeText(this, "Selected: " + car.getName(), Toast.LENGTH_SHORT).show();
        });
        recyclerView.setAdapter(carAdapter);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // ... existing code ...
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
} 