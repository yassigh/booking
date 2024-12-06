package com.example.myhotel;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class home extends AppCompatActivity {
    private LinearLayout l11, l12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        l11 = findViewById(R.id.l11);
        l12 = findViewById(R.id.l12);

        l11.setOnClickListener(v -> {
            Intent intent = new Intent(home.this, recherche_categories.class);
            startActivity(intent);
        });

        l12.setOnClickListener(v -> {
            Intent intent = new Intent(home.this, recherche_categories.class);
            startActivity(intent);
        });
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
