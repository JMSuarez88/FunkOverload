package com.sata.testapp.classes;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Service;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;

import java.util.List;

/**
 * Created by kaotiks on 10/04/16.
 */
 
public class GPS extends Service implements LocationListener {
    // Attributes
    private final Context context;
    private boolean isGPSEnabled = false;
    private boolean isNetworkEnabled = false;
    private boolean canGetLocation = false;
    private double latitude;
    private double longitude;
    private static final long MIN_DISTANCE_CHANGE_FOR_UPDATES = 1;
    private static final long MIN_TIME_BW_UPDATES = 1000 * 10;
    protected LocationManager locationManager;
    private Location location;
    private Geocoder geo;
    private String city;

    // Constructor
    public GPS(Context context) {
        this.context = context;
        this.geo = new Geocoder(context);
        this.getLocation();
    }

	// Getters
	public double getLatitude(){
        if(location != null){
            this.latitude = location.getLatitude();
        }
        return this.latitude;
    }
    public double getLongitude(){
        if(location != null){
            this.longitude = location.getLongitude();
        }
        return this.longitude;
    }
    public LocationManager getLocationManager(){
        return this.locationManager;
    }
    // Get the user Location (lat, lon)
    // toDo: improve this section in order to open GPS/NETWORK settings if disabled
    public Location getLocation() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_NETWORK_STATE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(new Activity(),new String[]{
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION,
                        Manifest.permission.ACCESS_NETWORK_STATE,
                        Manifest.permission.INTERNET
                },10);
            }
        }
        try {
            locationManager = (LocationManager) context.getSystemService(LOCATION_SERVICE);

            isGPSEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);

            isNetworkEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);

            // Check if services are enabled
            if (!isGPSEnabled && !isNetworkEnabled) {

            } else {
                this.canGetLocation = true;

                if (isNetworkEnabled) {
                    locationManager.requestLocationUpdates(
                            LocationManager.GPS_PROVIDER,
                            //LocationManager.NETWORK_PROVIDER,
                            MIN_DISTANCE_CHANGE_FOR_UPDATES,
                            MIN_TIME_BW_UPDATES,
                            this);


                    if (locationManager != null) {
                        this.location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

                        if (location != null) {
                            this.latitude = location.getLatitude();
                            this.longitude = location.getLongitude();
                        }
                    }
                }

                if (isGPSEnabled) {
                    if (this.location == null) {
                        locationManager.requestLocationUpdates(
                                LocationManager.GPS_PROVIDER,
                                //LocationManager.NETWORK_PROVIDER,
                                MIN_DISTANCE_CHANGE_FOR_UPDATES,
                                MIN_TIME_BW_UPDATES,
                                this);

                        if (locationManager != null) {
                            this.location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

                            if (location != null) {
                                this.latitude = location.getLatitude();
                                this.longitude = location.getLongitude();
                            }
                        }
                    }
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return location;
    }
    
    // Return the user geo location (city, state, country)
    public String getGeoLocation(double lat, double lon){
		List<Address> addresses;
        String city, state, country;
        try {
            addresses = geo.getFromLocation(lat,lon,1);
            city = addresses.get(0).getAddressLine(1);
            state = addresses.get(0).getAddressLine(2);
            country = addresses.get(0).getAddressLine(3);
            System.out.println(addresses);
            return city + ", " + state + ", " + country;
        } catch (Exception e){
            e.printStackTrace();
            return "Geocoder not working";
        }
    }
    
    // Not sure what it does
    public void stopUsingGPS() {
        if (locationManager != null) {
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_NETWORK_STATE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(new Activity(),new String[]{
                            Manifest.permission.ACCESS_FINE_LOCATION,
                            Manifest.permission.ACCESS_COARSE_LOCATION,
                            Manifest.permission.ACCESS_NETWORK_STATE,
                            Manifest.permission.INTERNET
                    },10);
                }
            }
            locationManager.removeUpdates(GPS.this);
        }
    }

    public String getCity(){
        Geocoder geoCoder = new Geocoder(this);
        StringBuilder builder = new StringBuilder();
        String city = "";
        try {
            //List<Address> address = geoCoder.getFromLocation(this.getLatitude(), this.getLongitude(), 1);
            city = (this.geo.getFromLocation(this.getLatitude(), this.getLongitude(), 1)).get(0).getLocality().toString();
            //city = address.get(0).getLocality().toString();
        } catch (Exception e){
            e.printStackTrace();
        }
        return city;
    }

    
    public boolean canGetLocation(){
        return this.canGetLocation;
    }

    public void showSettingsAlert(){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);

        alertDialog.setTitle("GPS is settings");
        alertDialog.setMessage("GPS is not enabled. Do you want to enable it?");
        alertDialog.setPositiveButton("Settings", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                context.startActivity(intent);
            }
        });
        alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        alertDialog.show();
    }

    

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


}
