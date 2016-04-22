package BackEnd;

import java.net.*;
import java.util.Vector;

import java.io.*;
import com.sata.testapp.classes.*;
import FrontEnd.MainWindow;

public class Servidor implements Runnable{
	
	private static Servidor _singletonServidor = null;
	
	private ServerSocket ss;
	private Socket s;
	private boolean Connected = false;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private Vector<NodoConexion> nc;
	private MainWindow mw;
	private final int PORT = 3535;
	
	private Servidor(){
	}
	public static Servidor getInstance(){
		if(_singletonServidor == null){
			_singletonServidor = new Servidor();
		}
		return _singletonServidor;
	}
	public void setMw(MainWindow mw){
		this.mw = mw;		
	}
	public void StartServer(){
		this.Connected = true;
		try {
			ss = new ServerSocket(PORT);// Instancia el servidor como ip defecto LocalHost el puerto seria el que pasamos por parametro la variable PORT
			mw.getAreaLogs().append("Servidor iniciado correctamente IP: "+ Inet4Address.getLocalHost().getHostAddress()+" Puerto: "+PORT);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		try{
			while(Connected){
				s = ss.accept();   //Acepta clientes
				oos = new ObjectOutputStream(s.getOutputStream()); // instancia el canal de salida de datos del cliente
				ois = new ObjectInputStream(s.getInputStream()); // instancia el canal de entrada de datos del cliente
				this.readLine();				
				System.out.println("Conectado");
			}
		}catch(Exception ex){
			this.closeServer();
			ex.printStackTrace();
		}
	}
	
	public void DisconectNodo(NodoConexion nc){
		this.nc.remove(nc);
	}
	
	
	public void readLine(){
		try{
			UserData aux = (UserData)ois.readObject();
			Thread.sleep(15);
			mw.getAreaLogs().setText("Mensaje Llego");
			if(aux.getIdMensaje() == 1) // Linea que enviaria la aplicacion APK para conectarse en primera instancia sino lo revotaria
			{
				nc.addElement(new NodoConexion(oos,ois)); // Se agrega el cliente a un vector con la oos y ois que sirven para recibir mensajes del cliente y enviarselos
				aux.getAirportFrom().setCity("Hola SrSata");
				oos.writeObject(aux);
			}
			else{
				aux.setIdMensaje(0);
				oos.writeObject(aux);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void closeServer(){
		try{
			oos.close();
			ois.close();
			s.close();
			ss.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
