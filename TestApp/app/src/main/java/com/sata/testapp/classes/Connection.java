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
    private ObjectOutputStream oos;
    private ObjectInputStream ois;
    private Socket s;
    private boolean connectedCliente = false;
    private InetAddress serverAddr = null;

    public Connection(){
        try{
            InetAddress serverAddr = InetAddress.getByName(SERVERIP);
            s = new Socket(serverAddr, SERVERPORT);
            oos = new ObjectOutputStream(this.s.getOutputStream());
            ois = new ObjectInputStream(s.getInputStream());
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        connectedCliente = true;

        try {

            // here you must put your computer's IP address.

            Log.e("serverAddr", serverAddr.toString());
            Log.e("TCP Client", "C: Connecting...");

            // create a socket to make the connection with the server

            Log.e("TCP Server IP", SERVERIP);
            try {

                // send the message to the server

                //oos = new ObjectOutputStream(s.getOutputStream());
                //ois = new ObjectInputStream(s.getInputStream());

                Send send = Send.createSend();
                send.setOos(oos);

                Log.e("TCP Client", "C: Sent.");
                UserData uData = new UserData();
                uData.setIdMensaje(1);
                send.sendObject(uData);
                Log.e("TCP Client", "C: Done.");

                // receive the message which the server sends back
                // in this while the client listens for the messages sent by the
                // server
                while (connectedCliente) {
                    try{
                        UserData aux = (UserData)ois.readObject();
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
    private void Comandos(UserData msj) {
        UserData aux = new UserData();
        switch (msj.getIdMensaje()) {
            case 1:
                aux = msj;
                System.out.println("Connected to server\n" + aux.getAirportFrom().getCity());
            case 2:
                aux = msj;
                System.out.println("Local airport setted");
            case 3:
                aux = msj;
                System.out.println("Local airport changed");
            case 4:
                aux = msj;
                System.out.println("Destination airport setted");
            case 5:
                aux = msj;
                System.out.println("Result");
        }
    }

}