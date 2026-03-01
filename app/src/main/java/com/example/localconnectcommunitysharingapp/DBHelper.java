package com.example.localconnectcommunitysharingapp;
import android.content.*;
import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;

import android.database.sqlite.*;
public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, "LocalConnect.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE users(username TEXT PRIMARY KEY, password TEXT)");
        db.execSQL("CREATE TABLE posts(id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT, description TEXT, latitude REAL, longitude REAL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS users");
        db.execSQL("DROP TABLE IF EXISTS posts");
        onCreate(db);
    }

    public boolean register(String username, String password) {
        if (login(username, password)) return false;
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("username", username);
        cv.put("password", password);
        db.insert("users", null, cv);
        return true;
    }

    public boolean login(String username, String password) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM users WHERE username=? AND password=?", new String[]{username, password});
        return c.getCount() > 0;
    }

    public void insertPost(String title, String desc, double lat, double lng) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("title", title);
        cv.put("description", desc);
        cv.put("latitude", lat);
        cv.put("longitude", lng);
        db.insert("posts", null, cv);
    }

    public Cursor getAllPosts() {
        SQLiteDatabase db = getReadableDatabase();
        return db.rawQuery("SELECT * FROM posts", null);
    }
}

