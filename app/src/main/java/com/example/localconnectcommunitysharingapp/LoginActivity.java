package com.example.localconnectcommunitysharingapp;
import android.content.Intent;

import android.os.Bundle;
import android.widget.*;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {
    EditText username, password;
    Button btnLogin;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        btnLogin = findViewById(R.id.btnLogin);
        db = new DBHelper(this);

        btnLogin.setOnClickListener(v -> {
            if (db.login(username.getText().toString(), password.getText().toString())) {
                startActivity(new Intent(this, DashboardActivity.class));
            } else {
                Toast.makeText(this, "Invalid Login", Toast.LENGTH_SHORT).show();
            }


        });
    }
}