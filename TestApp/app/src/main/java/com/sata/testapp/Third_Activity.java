package com.sata.testapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.sata.testapp.classes.UserData;

import java.util.List;

public class Third_Activity extends AppCompatActivity {

    private ListView lv_Airports;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_);
        this.lv_Airports = (ListView)findViewById(R.id.lv_Airports);
        final String [] airports = new String[UserData.createUserData().getAirports().size()];
        for(int i = 0 ; i< UserData.createUserData().getAirports().size(); i++){
            airports[i] = UserData.createUserData().getAirports().get(i).getFormalName();
        }
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,airports);
        lv_Airports.setAdapter(adaptador);
        lv_Airports.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long id) {
                // TODO Auto-generated method stub
                for(int i = 0 ; i< UserData.createUserData().getAirports().size(); i++){
                    if(UserData.createUserData().getAirports().get(i).getFormalName() == airports[position]) {
                        //Toast.makeText(getApplicationContext(), "Se encontro :" + position, Toast.LENGTH_SHORT).show();
                        UserData.createUserData().setAirportFrom(UserData.createUserData().getAirports().get(i));
                        Intent myIntent = new Intent(Third_Activity.this, Fourth_Activity.class);
                        startActivity(myIntent);
                        break;
                    }
                }
            }

        });
    }

}
