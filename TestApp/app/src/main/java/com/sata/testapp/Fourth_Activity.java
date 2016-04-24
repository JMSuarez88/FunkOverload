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

import com.sata.testapp.classes.Connection;
import com.sata.testapp.classes.Mensaje;
import com.sata.testapp.classes.UserData;

public class Fourth_Activity extends AppCompatActivity {

    private ListView lv_airportTo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth_);
        this.lv_airportTo = (ListView)findViewById(R.id.lv_airportTo);
        final String [] airports = new String[UserData.createUserData().getAirports().size()];
        for(int i = 0 ; i< UserData.createUserData().getAirports().size(); i++){
            airports[i] = UserData.createUserData().getAirports().get(i).getFormalName();
        }
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,airports);
        lv_airportTo.setAdapter(adaptador);
        lv_airportTo.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long id) {
                // TODO Auto-generated method stub
                for(int i = 0 ; i< UserData.createUserData().getAirports().size(); i++){
                    if(UserData.createUserData().getAirports().get(i).getFormalName() == airports[position]) {
                        //Toast.makeText(getApplicationContext(), "Se encontro :" + position, Toast.LENGTH_SHORT).show();
                        UserData.createUserData().setAirportTo(UserData.createUserData().getAirports().get(i));
                        Mensaje msj = new Mensaje();
                        msj.setIdMensaje(2);
                        msj.getAirportList().add(UserData.createUserData().getAirportFrom());
                        msj.getAirportList().add(UserData.createUserData().getAirportTo());
                        Connection.getInstance().setMensaje(msj);
                        try{
                            while (!UserData.createUserData().isConnect()) {
                                Thread.sleep(50);
                            }
                        }catch (InterruptedException ie){
                            ie.printStackTrace();
                        }
                        if(UserData.createUserData().isConnect()){

                        }
                        break;
                    }
                }
            }

        });
    }

}
