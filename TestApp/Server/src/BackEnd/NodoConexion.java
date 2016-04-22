package BackEnd;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import com.sata.testapp.classes.*;


public class NodoConexion implements Runnable {
	
	
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private boolean Connected = false;
	
	public NodoConexion(ObjectOutputStream oos, ObjectInputStream ois) {
		this.oos = oos;
		this.ois = ois;
		Connected = true;
	}
	public void run(){
		while(Connected)
		{
			try{
				UserData aux = (UserData)ois.readObject();
				Comandos(aux);
				Thread.sleep(15);
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
		
		}
	}
	private void Comandos(UserData aux) {
		switch(aux.getIdMensaje())
		{
			case 2:
				break;
		}
		
	}
	

}
