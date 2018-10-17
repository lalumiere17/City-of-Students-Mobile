package com.example.susu.presenters;

import com.example.susu.models.Hostel;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.Arrays;

public class MapPresenter {
    private MapPage activity;

    ArrayList<Hostel> hostels = new ArrayList<>( Arrays.asList(
            new Hostel(55.161443, 61.367476, "Общежитие №1."),
            new Hostel(55.160154, 61.367587, "Общежитие №2."),
            new Hostel(55.157257, 61.372223, "Общежитие №3."),
            new Hostel(55.161281, 61.366432, "Общежитие №5."),
            new Hostel(55.160990, 61.365635, "Общежитие №6."),
            new Hostel(55.159947, 61.366263, "Общежитие №7.1, №7.2."),
            new Hostel(55.157058, 61.370987, "Общежитие №8.1, №8.2.")
    ));

    public MapPresenter(MapPage activity) {
        this.activity = activity;
    }

    public void showHostels() {
        GoogleMap map = activity.getMap();
        LatLng chelyabinsk = new LatLng(55.160094, 61.370239);
        for (int i=0; i<=6; i++) {
            map.addMarker(new MarkerOptions().position(hostels.get(i).getCoordinates()).title(hostels.get(i).getName()));
        }
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(chelyabinsk, 16), 4000, null);
    }
}
