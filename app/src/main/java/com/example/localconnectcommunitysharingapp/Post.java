package com.example.localconnectcommunitysharingapp;

public class Post {
    public String title, description;
    public double latitude, longitude;

    public Post(String title, String description, double latitude, double longitude) {
        this.title = title;
        this.description = description;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}

