package com.sata.testapp;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.sata.testapp.classes.UserData;

public class Second_Activity extends MainActivity implements View.OnClickListener {
    Button next,change;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_);
        next = (Button) findViewById(R.id.bt_next);
        change = (Button)findViewById(R.id.bt_change);
        next.setOnClickListener(this);
        change.setOnClickListener(this);
        UserData.createUserData().setConnect(false);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_next:
                /* Pasar a layout 4, recibir en la layout 4 el destino */
                break;
            case R.id.bt_change:
                /* Pasar a la layout 3 y re celeccionar el destino(list view) luego pasar a layout4 */
                break;
        }

    }
}
