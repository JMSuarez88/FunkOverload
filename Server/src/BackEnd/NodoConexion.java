package BackEnd;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sata.testapp.classes.*;


public class NodoConexion implements Runnable {
	
	private ConexionBD db = ConexionBD.getConexion();
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private Socket s;
	
	public NodoConexion(ObjectOutputStream oos, ObjectInputStream ois,Socket s) {
		this.oos = oos;
		this.ois = ois;
		this.s = s;
		Thread t = new Thread(this);
		t.start();
	}
	public void run(){
		try {
			Comandos((Mensaje)ois.readObject());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	private void Comandos(Mensaje aux) {
		ResultSet rs;
		switch(aux.getIdMensaje())
		{
			case 1:
			{
				Airport airport = null;
				List<Airport> airportList = new ArrayList<Airport>();
				System.out.println(aux.getCity());
				System.out.println("Se imprimio ciudad");
				double dif = 200;
				int id = 0 ;
			    db.Conectar();
			    boolean found = false;
			    rs = db.ConsultaDatos("Select * from Airport");
			    try {
			    	while(rs.next()){
				    	if (aux.getCity().equals(rs.getString(4)) && found == false){
							id = 0;
							airport = this.setupAirport(rs);
							found = true;
						} 
						if(found == false){
							if((aux.getGpsA_x()-rs.getDouble(8)) +
								(aux.getGpsA_y()-rs.getDouble(7))<dif){
							dif = aux.getGpsA_x()-rs.getDouble(8) +aux.getGpsA_y()-rs.getDouble(7);
							if(dif<0){
								dif = dif *(-1);
							}
							id = rs.getInt(1);
						}
						}
						airportList.add(this.setupAirport(rs));
					}	
					if(id != 0){
						rs = db.ConsultaDatos("Select * from Airport where idAirport = "+id+"");
					}
					db.Desconectar();
					Mensaje msj = new Mensaje();
					msj.setAirport(airport);
					msj.setAirportList(airportList);
					msj.setIdMensaje(1);
					this.SendObject(msj);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;	    
			}
			case 2:
			{
				db.Conectar();
				List<String> flight = new ArrayList<String>();
				int idairportFrom= 0;
				int idairportTo=0;
				try {
					rs = db.ConsultaDatos("Select *from Airport where name = '"+aux.getAirportList().get(0)+"'");
					idairportFrom = rs.getInt(1);
					rs = db.ConsultaDatos("Select *from Airport where name = '"+aux.getAirportList().get(1)+"'");
					idairportTo = rs.getInt(1);
					rs = db.ConsultaDatos("select *from Flight where idAirportFrom = "+idairportFrom+" and idAirportTo ="+idairportTo+"");
					while(rs.next()){
						flight.add("|SALIDA| "+rs.getString(5)+" - "+rs.getString(6)+"|LLEGADA|");							
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Mensaje msj = new Mensaje();
				msj.setFlight(flight);
				msj.setIdMensaje(2);
				this.SendObject(msj);
			    break;
			}
		}
		
	}
	private Airport setupAirport(ResultSet rs){
		try {
			Airport airport = new Airport();
			airport.setFormalName(rs.getString(3));
			airport.setCity(rs.getString(4));
			airport.setState(rs.getString(5));
			airport.setCountry(rs.getString(6));
			airport.setLongitude(rs.getDouble(7));
			airport.setLatitude(rs.getDouble(8));
			airport.setIata(rs.getString(9));
			return airport;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
			// TODO Auto-generated catch block
		}
		
	}
	private void SendObject(Mensaje msj){
	try{
		if(oos == null){
			oos = new ObjectOutputStream(s.getOutputStream());			
		}else{
			oos.writeObject(msj);	
		}
	}catch(Exception ex){
		ex.printStackTrace();
	}
	}
}
