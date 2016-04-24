package com.sata.testapp.classes;


import android.content.Context;
import android.util.Log;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by klincaja on 20/04/16.
 */

public class Connection implements Runnable{
    private final  String SERVERIP = "192.168.0.103" ; // your computer IP
    private final int SERVERPORT = 3535;
    private Mensaje mensaje;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;
    private Socket s;
    private InetAddress serverAddr = null;
    private static Connection instance = null;
    private Connection(){
    }
    public static Connection getInstance(){
        if(instance == null){
            instance = new Connection();
        }
        return instance;
    }
    public void setMensaje(Mensaje msj){
        this.mensaje = msj;
        Thread t = new Thread(this);
        t.start();
    }
    public Mensaje getMensaje(){
        return mensaje;
    }

    @Override
    public void run() {
        try {

            // here you must put your computer's IP address.
            this.serverAddr = InetAddress.getByName(SERVERIP);
            Log.e("serverAddr", serverAddr.toString());
            Log.e("TCP Client", "C: Connecting...");

            // create a socket to make the connection with the server

            Log.e("TCP Server IP", SERVERIP);
            try {

                s = new Socket(serverAddr, SERVERPORT);
                // send the message to the server
                oos = new ObjectOutputStream(s.getOutputStream());
                ois = new ObjectInputStream(s.getInputStream());


                Log.e("TCP Client", "C: Sent.");
                oos.writeObject(mensaje);
                Log.e("TCP Client", "C: Done.");

                Mensaje aux = (Mensaje) ois.readObject();
                Commandos(aux);
                Log.e("TCP Client", "C:Recived");
                // receive the message which the server sends back
                // in this while the client listens for the messages sent by the
                // server
            }
            catch (Exception e) {

                Log.e("TCP", "S: Error", e);

            } finally {
                // the socket must be closed. It is not possible to reconnect to
                // this socket
                // after it is closed, which means a new socket instance has to
                // be created.
                s.close();
            }

        } catch (Exception e) {

            Log.e("TCP", "C: Error", e);

        }

        close();

    }
    public void close(){
        try{

            oos.close();
            ois.close();
            s.close();

        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    private void Commandos(Mensaje msj) {
        switch (msj.getIdMensaje()) {
            case 1:
                System.out.println("Connected to server");
                break;
            case 2:
                System.out.println("Local airport setted");
                break;
            case 3:
                System.out.println("Local airport changed");
                break;
            case 4:
                System.out.println("Destination airport setted");
                break;
            case 5:
                System.out.println("Result");
                break;
        }
    }
}