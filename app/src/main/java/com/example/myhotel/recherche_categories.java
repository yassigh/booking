package com.example.myhotel;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class recherche_categories extends AppCompatActivity {
    private AutoCompleteTextView titleTextView;
    private TextView hotelMediterraneeTextView;
    private TextView hotelbelTextView;
    private LinearLayout l1, l2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recherche_categories);

        titleTextView = findViewById(R.id.hotel_search);
        hotelMediterraneeTextView = findViewById(R.id.m);
        hotelbelTextView = findViewById(R.id.b);
        l1 = findViewById(R.id.l1);
        l2 = findViewById(R.id.l2);

        String[] hotels = {"Hotel Méditerrannée", "Hotel Bel Azur"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, hotels);
        titleTextView.setAdapter(adapter);

        titleTextView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable editable) {
                String query = editable.toString().toLowerCase();

                boolean showL1 = hotelMediterraneeTextView.getText().toString().toLowerCase().contains(query);
                boolean showL2 = hotelbelTextView.getText().toString().toLowerCase().contains(query);

                l1.setVisibility(showL1 ? LinearLayout.VISIBLE : LinearLayout.GONE);
                l2.setVisibility(showL2 ? LinearLayout.VISIBLE : LinearLayout.GONE);

                // Gérer l'affichage des sections
                if (!showL1 && !showL2) {
                    l1.setVisibility(LinearLayout.VISIBLE);
                    l2.setVisibility(LinearLayout.VISIBLE);
                }


                l1.setOnClickListener(v -> {
                    Hotel hotelMediterranee = new Hotel("Hotel Méditerrannée", "Description de l'Hotel Méditerrannée", "21612345678", 4.5);
                    Intent intent = new Intent(recherche_categories.this, detail.class);
                    intent.putExtra("hotelName", hotelMediterranee.getName());
                    intent.putExtra("phoneNumber", hotelMediterranee.getTelephone());
                    startActivity(intent);
                });


                l2.setOnClickListener(v -> {
                    Hotel hotelBelAzur = new Hotel("Hotel Bel Azur", "Description de l'Hotel Bel Azur", "0987654321", 3.8);
                    Intent intent = new Intent(recherche_categories.this, detail.class);
                    intent.putExtra("hotelName", hotelBelAzur.getName());
                    intent.putExtra("phoneNumber", hotelBelAzur.getTelephone());
                    startActivity(intent);
                });
            }
        });

        // Configuration du BottomNavigationView
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
       bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();

            if (itemId == R.id.navigation_home) {
                startActivity(new Intent(this, home.class));
                return true;
            }
           if (itemId == R.id.navigation_login) {
               startActivity(new Intent(this, login.class));
               return true;
           }
             else if (itemId == R.id.navigation_profile) {
                startActivity(new Intent(this, Profile.class));
                return true;
            }
            return false;
        });
    }
}
