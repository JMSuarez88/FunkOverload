package com.sata.testapp.classes;


import android.util.Log;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by klincaja on 20/04/16.
 */

public class Conexion implements Runnable{
    public static  String SERVERIP = "127.0.0.1" ; // your computer IP
    public static final int SERVERPORT = 3535;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;
    private Socket s;
    private boolean connectedCliente = false;


    public Conexion(){
    }

    @Override
    public void run() {
        connectedCliente = true;

        try {

            // here you must put your computer's IP address.
            InetAddress serverAddr = InetAddress.getByName(SERVERIP);
            Log.e("serverAddr", serverAddr.toString());
            Log.e("TCP Client", "C: Connecting...");

            // create a socket to make the connection with the server
            s = new Socket(serverAddr, SERVERPORT);
            Log.e("TCP Server IP", SERVERIP);
            try {

                // send the message to the server

                oos = new ObjectOutputStream(s.getOutputStream());
                ois = new ObjectInputStream(s.getInputStream());

                Log.e("TCP Client", "C: Sent.");
                Mensaje msj = new Mensaje();
                msj.setIdMensaje(1);
                oos.writeObject(msj);
                Log.e("TCP Client", "C: Done.");

                // receive the message which the server sends back
                // in this while the client listens for the messages sent by the
                // server
                while (connectedCliente) {
                    try{
                        Mensaje aux = (Mensaje)ois.readObject();
                        Comandos(aux);
                    }catch (Exception ex){
                        ex.printStackTrace();
                    }
                }


            } catch (Exception e) {

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
    private void Comandos(Mensaje msj) {
        switch (msj.getIdMensaje()) {
            case 1:
                break;
            case 2:
                break;

        }
    }

}
