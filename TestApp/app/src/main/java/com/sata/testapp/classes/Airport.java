package com.sata.testapp.classes;

import java.io.Serializable;

/**
 * Created by kaotiks on 11/04/16.
 */
 
public class Airport implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1566295528601414613L;
	// Attributes
    private String formalName;
    private String iata;
    private double latitude;
    private double longitude;
    private String city;
    private String state;
    private String country;
    
    // Constructor
    public Airport(){}

    public String toString(){
        return "Formal name: " + formalName + "\n" +
                "City: " + city + "\n" +
                "State: " + state + "\n" +
                "Country: " + country + "\n"
                ;
    }

    // Airport name
    public String getFormalName() {
        return formalName;
    }
    public void setFormalName(String formalName) {
        this.formalName = formalName;
    }

    // IATA code
    public String getIata() {
        return iata;
    }
    public void setIata(String iata) {
        this.iata = iata;
    }

    // Latitude
    public double getLatitude() {
        return latitude;
    }
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    // Longitude
    public double getLongitude() {
        return longitude;
    }
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    // City
    public String getCity() {
        return this.city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    // State
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }

    // Country
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
}
