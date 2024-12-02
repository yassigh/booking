package com.example.myhotel;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

public class detail extends AppCompatActivity {

    private String hotelName;
    private String phoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail);

        // Get hotel details from the intent
        hotelName = getIntent().getStringExtra("hotelName");
        phoneNumber = getIntent().getStringExtra("phoneNumber");

        // Use hotelName to set the title, or other UI elements as needed
        TextView hotelTitle = findViewById(R.id.hotelTitle);
        hotelTitle.setText(hotelName);

        // Dummy data for amenities
        List<Amenity> amenities = Arrays.asList(
                new Amenity("Car Parking", R.drawable.parking),
                new Amenity("Telephone", R.drawable.telephone),
                new Amenity("Place", R.drawable.place)
        );

        // Set up RecyclerView
        RecyclerView recyclerView = findViewById(R.id.amenityRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new AmenityAdapter(amenities));
    }

    public void onPhoneClick(View view) {
        // Use the phone number passed through the intent
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phoneNumber));  // Use dynamic phone number
        startActivity(intent);

        // Verify if permission is granted for phone call
        if (checkSelfPermission(android.Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
            startActivity(intent);
        } else {
            Toast.makeText(this, "Permission d'appel requise", Toast.LENGTH_SHORT).show();
        }
    }
}
