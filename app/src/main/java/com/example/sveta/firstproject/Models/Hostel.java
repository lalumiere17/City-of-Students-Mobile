package com.example.sveta.firstproject.Models;

import com.google.android.gms.maps.model.LatLng;

public class Hostel {
    public LatLng coordinates;
    public String name;

    public  Hostel(double latitude, double longitude, String _name) {
        coordinates = new LatLng(latitude, longitude);
        name = _name;
    }

    public LatLng Return_Coordinates(){
        return coordinates;
    }
}
