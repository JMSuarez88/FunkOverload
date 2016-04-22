package com.sata.testapp.classes;

import java.io.ObjectOutputStream;

/**
 * Created by kaotiks on 22/04/16.
 */

public class Send {
    // Attributes
    private static Send send = null;
    private ObjectOutputStream oos;

    // Constructor
    private Send(){

    }

    // Method for Send creation (allow just one instance of Send across the app)
    public static Send createSend(){
        if(send == null) {
            send = new Send();
            return send;
        } else {
            System.out.println("User already created");
            return null;
        }
    }

    // Object Output Stream
    public void setOos(ObjectOutputStream oos) {
        this.oos = oos;
    }

    public void sendObject(UserData uData){
        try {
            oos.writeObject(uData);
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
