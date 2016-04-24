package com.sata.testapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
<<<<<<< Updated upstream
=======
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
>>>>>>> Stashed changes
import com.sata.testapp.classes.Connection;
import com.sata.testapp.classes.GPS;
import com.sata.testapp.classes.Mensaje;
import com.sata.testapp.classes.UserData;
import com.sata.testapp.classes.Weather;

<<<<<<< Updated upstream
public class MainActivity extends AppCompatActivity {
    private UserData userData;
    private Connection cs;
    private GPS userGps;
    private Weather w = new Weather("-54","-60");
=======
public class MainActivity extends AppCompatActivity implements OnClickListener{
    TextView tv_texto;
    ImageButton bt_Button;

>>>>>>> Stashed changes

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
<<<<<<< Updated upstream

        // Used to avoid the android.os.NetworkOnMainThreadException
=======
        setContentView(R.layout.activity_main);

        tv_texto =(TextView)findViewById(R.id.tv_userDataField);
        bt_Button=(ImageButton) findViewById(R.id.bt_Connect);
        bt_Button.setOnClickListener(this);//preparar

        // Don't remember what is this for
>>>>>>> Stashed changes
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

<<<<<<< Updated upstream
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
=======
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_Connect:
                //hacer al connectar
                tv_texto.setText("@string/disconnect");//en caso de falla solo escribir disconected

                /*
                 en caso de ser falso
                 if(condicion ){

                 }
                Recibe los datos del aeropuerto y de los aeropuertos  que hay que pasar a la siguiente layout
                 */



                //paso al segundo layout
                Intent intent01 =new Intent(MainActivity.this,Second_Activity.class);
                startActivity(intent01);

                break;


        }


    }
}
>>>>>>> Stashed changes
