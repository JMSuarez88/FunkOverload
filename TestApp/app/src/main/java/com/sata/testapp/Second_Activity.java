package com.sata.testapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.sata.testapp.classes.UserData;

public class Second_Activity extends MainActivity implements View.OnClickListener {
    private Button next,change;
    private TextView tv_airportSelect;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_);
        next = (Button) findViewById(R.id.bt_next);
        change = (Button)findViewById(R.id.bt_change);
        tv_airportSelect = (TextView)findViewById(R.id.tv_airportSelect);
        next.setOnClickListener(this);
        change.setOnClickListener(this);
        UserData.createUserData().setConnect(false);
        try {
            tv_airportSelect.setText(UserData.createUserData().getAirportFrom().getFormalName()+"\n("+UserData.createUserData().getUser().getCity()+")");
        }catch (Exception ex){
            tv_airportSelect.setText("GPS NOT FOUND");

        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_next:
                /* Pasar a layout 4, recibir en la layout 4 el destino */
                break;
            case R.id.bt_change:
                Intent i = new Intent(this, Third_Activity.class );
                startActivity(i);
                break;
        }

    }
}
