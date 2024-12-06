package com.example.myhotel;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Arrays;
import java.util.List;

public class detail extends AppCompatActivity {

    private String hotelName;
    private String phoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Récupérer les informations de l'hôtel depuis l'intent
        hotelName = getIntent().getStringExtra("hotelName");
        phoneNumber = getIntent().getStringExtra("phoneNumber");

        TextView hotelTitle = findViewById(R.id.hotelTitle);
        hotelTitle.setText(hotelName);

        List<Amenity> amenities = Arrays.asList(
                new Amenity("Car Parking", R.drawable.parking),
                new Amenity("Telephone", R.drawable.telephone),
                new Amenity("Place", R.drawable.place)
        );


//RecyclerView


        RecyclerView recyclerView = findViewById(R.id.amenityRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new AmenityAdapter(amenities));

        // Configurer le BottomNavigationView
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();

            if (itemId == R.id.navigation_home) {
                startActivity(new Intent(this, home.class));
                return true;
            } else if (itemId == R.id.navigation_login) {
                startActivity(new Intent(this, login.class));
                return true;
            } else if (itemId == R.id.navigation_profile) {
                startActivity(new Intent(this, Profile.class));
                return true;
            }
            return false;
        });
    }

    public void onPhoneClick(View view) {

        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        startActivity(intent);
        if (checkSelfPermission(android.Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
            startActivity(intent);
        } else {
            Toast.makeText(this, "Permission d'appel requise", Toast.LENGTH_SHORT).show();
        }      BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

    }

}
