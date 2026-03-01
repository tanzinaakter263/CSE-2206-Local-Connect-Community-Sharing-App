package com.example.localconnectcommunitysharingapp;

import android.os.Bundle;
import android.widget.*;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegisterActivity extends AppCompatActivity {

        EditText username, password;
        Button btnRegister;
        DBHelper db;

        @Override
        protected void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_register);

            username = findViewById(R.id.username);
            password = findViewById(R.id.password);
            btnRegister = findViewById(R.id.btnRegister);
            db = new DBHelper(this);

            btnRegister.setOnClickListener(v -> {
                if (db.register(username.getText().toString(), password.getText().toString())) {
                    Toast.makeText(this, "Registered!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "User already exists", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }