package com.example.sveta.firstproject.Pages;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;

import com.example.sveta.firstproject.Models.Hostel;
import com.example.sveta.firstproject.Models.Permissions;
import com.example.sveta.firstproject.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MapPage extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Navbar navbar;

    private boolean accessLocation = false;

    private static final int INITIAL_REQUEST_CODE            = 1001;
    private static final int SHOW_USER_LOCATION_REQUEST_CODE = 1002;

    ArrayList<Hostel> hostels = new ArrayList<>( Arrays.asList(
            new Hostel(55.161443, 61.367476, "Общежитие №1."),
            new Hostel(55.160154, 61.367587, "Общежитие №2."),
            new Hostel(55.157257, 61.372223, "Общежитие №3."),
            new Hostel(55.161281, 61.366432, "Общежитие №5."),
            new Hostel(55.160990, 61.365635, "Общежитие №6."),
            new Hostel(55.159947, 61.366263, "Общежитие №7.1, №7.2."),
            new Hostel(55.157058, 61.370987, "Общежитие №8.1, №8.2.")
    ));


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        Загрузка Layout`а
        setContentView(R.layout.activity_map_page);

//        Инициализация навигационнного бара
        navbar = new Navbar(this);


        if(Permissions.checkLocationPermissions(this, SHOW_USER_LOCATION_REQUEST_CODE)) {
//        Загрузка фрагмета
            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.map);

//        Загрузка карта
            mapFragment.getMapAsync(this);
        }

    }

//    метод сообщающий о готовности карты
    @Override
    @SuppressWarnings( {"MissingPermission"})
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        if(Permissions.checkLocationPermissions(this, SHOW_USER_LOCATION_REQUEST_CODE))
            mMap.setMyLocationEnabled(true);

        // Add a marker in Sydney and move the camera
        LatLng chelyabinsk = new LatLng(55.160094, 61.370239);
        for (int i=0; i<=6; i++) {
            mMap.addMarker(new MarkerOptions().position(hostels.get(i).coordinates).title(hostels.get(i).name));
        }
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(chelyabinsk, 16), 4000, null);


    }

    @Override
    @SuppressWarnings( {"MissingPermission"})
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case INITIAL_REQUEST_CODE:
                SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                        .findFragmentById(R.id.map);
                mapFragment.getMapAsync(this);
                break;

            case SHOW_USER_LOCATION_REQUEST_CODE:
                mMap.setMyLocationEnabled(true);
                break;
        }

    }
}
