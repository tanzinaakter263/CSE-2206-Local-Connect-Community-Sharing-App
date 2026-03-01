package com.example.localconnectcommunitysharingapp;
import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;



import com.google.android.gms.maps.*;

public class MapActivity extends FragmentActivity implements OnMapReadyCallback {

    GoogleMap mMap;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        db = new DBHelper(this);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        Cursor c = db.getAllPosts();
        while (c.moveToNext()) {
            String title = c.getString(1);
            String desc = c.getString(2);
            double lat = c.getDouble(3);
            double lng = c.getDouble(4);
            LatLng loc = new LatLng(lat, lng);
            mMap.addMarker(new MarkerOptions().position(loc).title(title).snippet(desc));
        }
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(23.8103, 90.4125), 10));
    }
}
