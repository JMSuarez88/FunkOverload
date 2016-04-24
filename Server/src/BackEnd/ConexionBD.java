package BackEnd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionBD {
	
	
	private static ConexionBD instance = null;
	private final String stringConection = "jdbc:mysql://localhost:3306/kusodb?autoReconnect=true&useSSL=false";
	private Connection conexion ;
	
	public ConexionBD()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	public void Conectar(){

		try {
			conexion = DriverManager.getConnection (stringConection,"root","123456");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void Desconectar(){ try {
		conexion.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}}
	
	public static ConexionBD getConexion(){
		if(instance == null){
			instance = new ConexionBD();
		}
		return instance;
	}
	// Select consultas a bdd
	public ResultSet ConsultaDatos(String sql){
		try
		{
			Statement s = conexion.createStatement(); 
			ResultSet rs = s.executeQuery (sql);
			return rs;
		}
		catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
	//Insert Update Delete consultas a bdd
	public boolean insertarDatos(String sql){
		try
		{
			Statement s = conexion.createStatement(); 
			int rs = s.executeUpdate(sql);
			return true;
		}
		catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
	}
}
