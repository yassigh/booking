package com.example.myhotel;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class login extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText emailEditText, passwordEditText;
    private Button continueButton;
    private ImageView visibilityIcon;
    private boolean isPasswordVisible = false;
    private TextView skip,Error;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();
        Error=findViewById(R.id.error);

        emailEditText = findViewById(R.id.email);
        passwordEditText = findViewById(R.id.password);
        continueButton = findViewById(R.id.continueButton);
        visibilityIcon = findViewById(R.id.visibilityIcon);
        skip = findViewById(R.id.skipLink);

        skip.setOnClickListener(view -> {
            Intent intent = new Intent(login.this, registre.class);
            startActivity(intent);
            finish();
        });

        // Listener pour le bouton continueee
        continueButton.setOnClickListener(view -> {
            String email = emailEditText.getText().toString().trim();
            String password = passwordEditText.getText().toString().trim();

            if (TextUtils.isEmpty(email)) {
                Error.setText("Email is required");
                return;
            }

            if (TextUtils.isEmpty(password)) {
                Error.setText("Password is required");
                return;
            }

            loginUser(email, password);
        });

        // visibilite du mot de passe
        visibilityIcon.setOnClickListener(view -> {
            isPasswordVisible = !isPasswordVisible;
            passwordEditText.setInputType(isPasswordVisible ? android.text.InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                    : android.text.InputType.TYPE_CLASS_TEXT | android.text.InputType.TYPE_TEXT_VARIATION_PASSWORD);
            passwordEditText.setSelection(passwordEditText.getText().length());
        });
    }

    private void loginUser(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        FirebaseUser user = mAuth.getCurrentUser();
                        Toast.makeText(login.this, "Login successful! Welcome " + user.getEmail(), Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(login.this, home.class));
                        finish();
                    } else {
                        String errorMessage = task.getException() != null ? task.getException().getMessage() : "Unknown error";
                        Toast.makeText(login.this, "Login failed: " + errorMessage, Toast.LENGTH_LONG).show();
                    }
                });
    }
}
