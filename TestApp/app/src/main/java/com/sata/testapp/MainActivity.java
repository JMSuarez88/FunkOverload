package com.sata.testapp;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import com.sata.testapp.classes.Connection;
import com.sata.testapp.classes.GPS;
import com.sata.testapp.classes.Mensaje;
import com.sata.testapp.classes.UserData;
import com.sata.testapp.classes.Weather;

public class MainActivity extends AppCompatActivity {
    private UserData userData;
    private Connection cs;
    private GPS userGps;
    private Weather w = new Weather("-54","-60");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Used to avoid the android.os.NetworkOnMainThreadException
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        setContentView(R.layout.activity_main);

        // Start server
        this.startConnection();

        // Instantiate objects
        this.userData = new UserData();
        this.userGps = new GPS(this);
        
        // Set up user location
        this.userData.getUser().setLat(userGps.getLatitude());
        this.userData.getUser().setLon(userGps.getLongitude());
        //this.userData.getUser().setCity("Rosario");
        //this.userData.getUser().setCity(userGps.getCity());

        // Send user location
        Mensaje msj = new Mensaje();
        msj.setCity(this.userGps.getCity());
        msj.setIdMensaje(2);
        cs.sendObject(msj);
        // Set up Flight
        this.userData.getFlight().setupAirports(this.userData.getAirportFrom(), this.userData.getAirportTo());
    }
    
    public void startConnection() {
		this.cs = Connection.getInstance();
	}
}

// EXAMPLE [Button]
    /*private Button buton;
    private Button button1;

        button = (Button) findViewById(R.id.gpsLocationButton);
        button1 = (Button) findViewById(R.id.locationResetButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gps = new GPS(MainActivity.this);

                if(gps.canGetLocation()){
                    double lattitude = gps.getLatitude();
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
