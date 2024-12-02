package com.example.myhotel;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        // Définir le listener pour les éléments du menu
        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.navigation_home) {
                // Rediriger vers la page d'accueil
                startActivity(new Intent(menu.this, home.class));
                return true;
            } else if (item.getItemId() == R.id.navigation_login) {
                // Rediriger vers la page de login
                startActivity(new Intent(menu.this, login.class));
                return true;
            } else if (item.getItemId() == R.id.navigation_profile) {
                // Rediriger vers la page de profil
                startActivity(new Intent(menu.this, Profile.class));
                return true;
            }
            return false;
        });
    }
}
