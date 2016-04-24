package com.sata.testapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;

import com.sata.testapp.classes.Connection;
import com.sata.testapp.classes.GPS;
import com.sata.testapp.classes.Mensaje;
import com.sata.testapp.classes.User;
import com.sata.testapp.classes.UserData;


public class MainActivity extends AppCompatActivity implements OnClickListener{
    private TextView tv_texto;
    private ImageButton bt_Button;
    private GPS gps ;
    private Mensaje msj;
    private UserData userData ;
    private Connection conexion = Connection.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.gps = new GPS(this);
        this.userData = UserData.createUserData();
        tv_texto =(TextView)findViewById(R.id.tv_userDataField);
        bt_Button=(ImageButton) findViewById(R.id.bt_Connect);
        bt_Button.setOnClickListener(this);//preparar

        // Don't remember what is this for
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        this.userData.getUser().setLat(gps.getLatitude());
        this.userData.getUser().setLon(gps.getLongitude());
        this.userData.getUser().setCity(gps.getCity());
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_Connect:
                msj = new Mensaje();
                msj.setIdMensaje(1);
                msj.setGpsA_y(this.userData.getUser().getLon());
                msj.setGpsA_x(this.userData.getUser().getLat());
                msj.setCity(this.userData.getUser().getCity());
                this.conexion.setMensaje(msj);
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
