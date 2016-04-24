package com.sata.testapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import com.sata.testapp.classes.Connection;
import com.sata.testapp.classes.GPS;
import com.sata.testapp.classes.Send;
import com.sata.testapp.classes.UserData;

public class MainActivity extends AppCompatActivity implements OnClickListener{
    TextView tv_texto;
    ImageButton bt_Button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_texto =(TextView)findViewById(R.id.tv_userDataField);
        bt_Button=(ImageButton) findViewById(R.id.bt_Connect);
        bt_Button.setOnClickListener(this);//preparar

        // Don't remember what is this for
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

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
