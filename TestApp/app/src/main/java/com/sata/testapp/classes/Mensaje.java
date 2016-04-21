package com.sata.testapp.classes;

import java.io.Serializable;

public class Mensaje implements Serializable{
	private static final long serialVersionUID = -6374678792440967465L;
	private int idMensaje;
	private float gpsA_x,gpsA_y,gpsB_x,gpsB_y;
	private String codeString = "APK2016";
	private int minutesDelay;
	public int getIdMensaje() {
		return idMensaje;
	}
	public void setIdMensaje(int idMensaje) {
		this.idMensaje = idMensaje;
	}
	public float getGpsA_x() {
		return gpsA_x;
	}
	public void setGpsA_x(float gpsA_x) {
		this.gpsA_x = gpsA_x;
	}
	public float getGpsA_y() {
		return gpsA_y;
	}
	public void setGpsA_y(float gpsA_y) {
		this.gpsA_y = gpsA_y;
	}
	public float getGpsB_x() {
		return gpsB_x;
	}
	public void setGpsB_x(float gpsB_x) {
		this.gpsB_x = gpsB_x;
	}
	public float getGpsB_y() {
		return gpsB_y;
	}
	public void setGpsB_y(float gpsB_y) {
		this.gpsB_y = gpsB_y;
	}
	public String getCodeString() {
		return codeString;
	}
	public void setCodeString(String codeString) {
		this.codeString = codeString;
	}
	public int getMinutesDelay() {
		return minutesDelay;
	}
	public void setMinutesDelay(int minutesDelay) {
		this.minutesDelay = minutesDelay;
	}
}
