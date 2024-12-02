package com.example.myhotel;

import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent;
public class home extends AppCompatActivity {
    private LinearLayout l11, l12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);

        // Gérer les bords pour une expérience fluide
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        l11 = findViewById(R.id.l11);
        l12 = findViewById(R.id.l12);  l11.setOnClickListener(v -> {
            Intent intent = new Intent(home.this, recherche_categories.class);
            startActivity(intent);
        });

        // Ajouter un gestionnaire de clic pour l12 si nécessaire
        l12.setOnClickListener(v -> {
            Intent intent = new Intent(home.this, recherche_categories.class);
            startActivity(intent);
        });
    }
}
