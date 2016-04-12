package com.sata.testapp.classes;

import android.content.Context;
import android.location.Location;
import android.os.Parcel;
import android.os.UserHandle;

import com.sata.testapp.GPSTracker;

/**
 * Created by kaotiks on 11/04/16.
 */
public class User {
    // Attributes
    private static User instance = null;
    private Location userLocation;
    private int id;
    private double lat;
    private double lon;
    private String city;
    private String state;
    private String country;
    private GPSTracker gps;

    // Private constructor for Singleton
    private User(Context context) {
        this.gps = new GPSTracker(context);
        this.setupUserLocation(gps);
    }

    // Method for User creation (allow just one instance of User across the app)
    public static User createUser(Context context){
        if(instance == null) {
            instance = new User(context);
            return instance;
        } else {
            System.out.println("User already created");
            return null;
        }
    }

    public String getLatString() {
        return "Latitude: " + lat + "\n";
    }

    public String getLonString() {
        return "Longitude: " + lon + "\n";
    }

    private void setupUserLocation(GPSTracker gps){
        this.lat = gps.getLattitude();
        this.lon = gps.getLongitude();
    }
}
