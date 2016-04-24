package com.sata.testapp.classes;

import java.io.Serializable;
import java.util.List;

public class Mensaje implements Serializable{
	private static final long serialVersionUID = -6374678792440967465L;
	private int idMensaje;
	private String city;
	private Airport airport;
	private List<Airport> airportList;
	// City
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	private double gps_x,gps_y;
	private int minutesDelay;
	public int getIdMensaje() {
		return idMensaje;
	}
	public void setIdMensaje(int idMensaje) {
		this.idMensaje = idMensaje;
	}
	public double getGpsA_x() {
		return gps_x;
	}
	public void setGpsA_x(double gpsA_x) {
		this.gps_x = gpsA_x;
	}
	public double getGpsA_y() {
		return gps_y;
	}
	public void setGpsA_y(double gpsA_y) {
		this.gps_y = gpsA_y;
	}
	public int getMinutesDelay() {
		return minutesDelay;
	}
	public void setMinutesDelay(int minutesDelay) {
		this.minutesDelay = minutesDelay;
	}
	public Airport getAirport() {
		return airport;
	}
	public void setAirport(Airport airport) {
		this.airport = airport;
	}
	public List<Airport> getAirportList() {
		return airportList;
	}
	public void setAirportList(List<Airport> airportList) {
		this.airportList = airportList;
	}
}
