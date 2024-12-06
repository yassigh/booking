package com.example.myhotel;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Profile extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private TextView userNameTextView, userEmailTextView;
    private Button logoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();

        userNameTextView = findViewById(R.id.user_name);
        userEmailTextView = findViewById(R.id.user_email);
        logoutButton = findViewById(R.id.logout_button);

        if (currentUser != null) {
            userNameTextView.setText(currentUser.getDisplayName() != null ? currentUser.getDisplayName() : "User Name");
            userEmailTextView.setText(currentUser.getEmail());
        }

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
            } else if (itemId == R.id.navigation_profile) {
                startActivity(new Intent(this, Profile.class));
                return true;
            }
            return false;
        });

        logoutButton.setOnClickListener(v -> logoutUser());
    }

    private void logoutUser() {
        FirebaseAuth.getInstance().signOut();
        Toast.makeText(Profile.this, "Logged out successfully", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(Profile.this, login.class));
        finish();
    }
}
