package com.example.localconnectcommunitysharingapp;

import android.os.Bundle;
import android.widget.*;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PostActivity extends AppCompatActivity {
    EditText title, description, latitude, longitude;
    Button btnPost;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        title = findViewById(R.id.title);
        description = findViewById(R.id.description);
        latitude = findViewById(R.id.latitude);
        longitude = findViewById(R.id.longitude);
        btnPost = findViewById(R.id.btnPost);
        db = new DBHelper(this);

        btnPost.setOnClickListener(v -> {
            String t = title.getText().toString();
            String d = description.getText().toString();
            double lat = Double.parseDouble(latitude.getText().toString());
            double lng = Double.parseDouble(longitude.getText().toString());

            db.insertPost(t, d, lat, lng);
            Toast.makeText(this, "Post Added", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}
