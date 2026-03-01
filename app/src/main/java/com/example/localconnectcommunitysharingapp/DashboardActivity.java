package com.example.localconnectcommunitysharingapp;

import android.os.Bundle;
import android.content.Intent;
import android.database.Cursor;
import android.widget.*;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.ArrayList;

public class DashboardActivity extends AppCompatActivity {

        Button btnAddPost, btnMap;
        ListView postList;
        DBHelper db;
        ArrayList<String> posts = new ArrayList<>();
        ArrayAdapter<String> adapter;

        @Override
        protected void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_dashboard);

            btnAddPost = findViewById(R.id.btnAddPost);
            btnMap = findViewById(R.id.btnMap);
            postList = findViewById(R.id.postList);
            db = new DBHelper(this);

            btnAddPost.setOnClickListener(v -> startActivity(new Intent(this, PostActivity.class)));
            btnMap.setOnClickListener(v -> startActivity(new Intent(this, MapActivity.class)));

            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, posts);
            postList.setAdapter(adapter);
            loadPosts();
        }

        private void loadPosts () {
            posts.clear();
            Cursor c = db.getAllPosts();
            while (c.moveToNext()) {
                posts.add(c.getString(1) + ": " + c.getString(2)); // title + desc
            }
            adapter.notifyDataSetChanged();
        }
    }
