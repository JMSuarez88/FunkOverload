package com.sata.testapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.sata.testapp.classes.User;

public class MainActivity extends AppCompatActivity {
    private User user;
    private TextView userDataField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.user = User.createUser(this);
        this.userDataField = (TextView) findViewById(R.id.userDataField);

        this.userDataField.setText(
                /*this.user.getLatString() +
                this.user.getLonString() +*/
                this.user.getCity(user.getLat(),user.getLon())
        );
    }


    // EXAMPLE [Button]: SHOW USER LOCATION
    /*private Button button;
    private Button button1;
    private GPSTracker gps;
    private TextView latitudeField;
    private TextView longitudeField;
    private TextView geoPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.gpsLocationButton);
        button1 = (Button) findViewById(R.id.locationResetButton);
        latitudeField = (TextView) findViewById(R.id.locationTextField);
        longitudeField = (TextView) findViewById(R.id.locationTextField1);
        geoPosition = (TextView) findViewById(R.id.locationTextField2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gps = new GPSTracker(MainActivity.this);

                if(gps.canGetLocation()){
                    double lattitude = gps.getLattitude();
                    double longitude = gps.getLongitude();

                    latitudeField.setText("Lat: " + lattitude);
                    longitudeField.setText("Lon: " + longitude);
                    geoPosition.setText(gps.getGeoLocation(lattitude,longitude));
                }
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                latitudeField.setText("");
                longitudeField.setText("");
                geoPosition.setText("");
            }
        });
    }*/
}
