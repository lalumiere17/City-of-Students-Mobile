package com.example.susu.models;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;

public final class Permissions {
    public static final String[] LOCATION_PERMISSIONS = new String[] {
            Manifest.permission.ACCESS_COARSE_LOCATION ,
            Manifest.permission.ACCESS_FINE_LOCATION
    };
//Build.VERSION.SDK_INT >= 23 &&
    public static final boolean checkLocationPermissions(Activity activity, int LOCATION_ACCESS_REQUEST_CODE) {
        if (
                ActivityCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(activity,
                    Permissions.LOCATION_PERMISSIONS,
                    LOCATION_ACCESS_REQUEST_CODE);

            return false;
        }

        return true;
    }
}
