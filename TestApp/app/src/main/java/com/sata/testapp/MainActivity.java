package com.sata.testapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private Button button1;
    private GPSTracker gps;
    private TextView lattitudeField;
    private TextView longitudeField;
    private TextView geoPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.gpsLocationButton);
        button1 = (Button) findViewById(R.id.locationResetButton);
        lattitudeField = (TextView) findViewById(R.id.locationTextField);
        longitudeField = (TextView) findViewById(R.id.locationTextField1);
        geoPosition = (TextView) findViewById(R.id.locationTextField2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gps = new GPSTracker(MainActivity.this);

                if(gps.canGetLocation()){
                    double lattitude = gps.getLattitude();
                    double longitude = gps.getLongitude();

                    lattitudeField.setText("Lat: " + lattitude);
                    longitudeField.setText("Lon: " + longitude);
                    geoPosition.setText(gps.getGeoLocation(lattitude,longitude));
                }
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lattitudeField.setText("");
                longitudeField.setText("");
                geoPosition.setText("");
            }
        });
    }
}
