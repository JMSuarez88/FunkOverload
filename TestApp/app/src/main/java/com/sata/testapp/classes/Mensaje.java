package com.sata.testapp.classes;

import java.io.Serializable;
import java.util.Vector;

public class Mensaje implements Serializable{
	private static final long serialVersionUID = -6374678792440967465L;
	private int idMensaje;
	private Vector<Airport> airports;
	private String city;

	public Airport getAirport() {
		return airport;
	}

	public void setAirport(Airport airport) {
		this.airport = airport;
	}

	// City
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	private Airport airport;
	private float gps_x,gps_y;
	private int minutesDelay;
	public int getIdMensaje() {
		return idMensaje;
	}
	public void setIdMensaje(int idMensaje) {
		this.idMensaje = idMensaje;
	}
	public float getGpsA_x() {
		return gps_x;
	}
	public void setGpsA_x(float gpsA_x) {
		this.gps_x = gpsA_x;
	}
	public float getGpsA_y() {
		return gps_y;
	}
	public void setGpsA_y(float gpsA_y) {
		this.gps_y = gpsA_y;
	}
	public int getMinutesDelay() {
		return minutesDelay;
	}
	public void setMinutesDelay(int minutesDelay) {
		this.minutesDelay = minutesDelay;
	}
	public Vector<Airport> getAirports() {
		return airports;
	}
	public void setAirports(Vector<Airport> airports) {
		this.airports = airports;
	}
}
