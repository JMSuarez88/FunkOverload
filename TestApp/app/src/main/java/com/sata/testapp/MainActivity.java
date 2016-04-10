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
    private TextView textView;
    private TextView textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.gpsLocationButton);
        button1 = (Button) findViewById(R.id.locationResetButton);
        textView = (TextView) findViewById(R.id.locationTextField);
        textView1 = (TextView) findViewById(R.id.locationTextField1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gps = new GPSTracker(MainActivity.this);

                if(gps.canGetLocation()){
                    double lattitude = gps.getLattitude();
                    double longitude = gps.getLongitude();

                    textView.setText("Lat: " + lattitude);
                    textView1.setText("Lon: " + longitude);
                }
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("");
                textView1.setText("");
            }
        });
    }
}
