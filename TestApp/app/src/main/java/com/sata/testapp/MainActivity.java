package com.sata.testapp;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.sata.testapp.classes.Connection;
import com.sata.testapp.classes.GPS;
import com.sata.testapp.classes.Send;
import com.sata.testapp.classes.UserData;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private UserData userData;
    private TextView userDataField;
    private Connection cs;
    private Button buttonConnect;
    private GPS userGps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // Don't remember what is this for
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        
        // Start server
        this.startServer();

        // Instantiate objects
        this.userData = UserData.createUserData();
        //this.userDataField = (TextView) findViewById(R.id.userDataField);
        //this.buttonConnect = (Button) findViewById(R.id.buttonConnect);
        this.userGps = new GPS(this);
        
        // Set up user location
        this.userData.getUser().setLat(userGps.getLatitude());
        this.userData.getUser().setLon(userGps.getLongitude());
        this.userData.getUser().setCity(userGps.getCity());

        // Send user location
        Send send = Send.createSend();
        this.userData.setIdMensaje(2);
        send.sendObject(userData);

        // Set up Flight
        this.userData.getFlight().setupAirports(this.userData.getAirportFrom(), this.userData.getAirportTo());

        // Button
        /*buttonConnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick() {
                
            }
        });*/

        // Set text field content
        this.userDataField.setText(
                "Conecta o no conecta?"
                //this.userData.getUser().toString() + "\n" +
                //this.userData.getAirportFrom().toString() + "\n
                //this.userData.getFlight().toString() + "\n"
                //this.userData.getAirportTo().toString() + "\n" +
                //this.userData.getFlight().toString()
        );
    }
    
    public void startServer() {
		this.cs = new Connection();
		Thread t = new Thread(cs);
		t.start();
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
}
