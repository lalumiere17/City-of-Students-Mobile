package com.example.susu.models;

import com.google.android.gms.maps.model.LatLng;

public class Hostel {
    private LatLng coordinates;
    private String name;

    public  Hostel(double latitude, double longitude, String _name) {
        coordinates = new LatLng(latitude, longitude);
        name = _name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCoordinates(LatLng coordinates) {
        this.coordinates = coordinates;
    }

    public String getName() {
        return name;
    }

    public LatLng getCoordinates(){
        return coordinates;
    }
}
