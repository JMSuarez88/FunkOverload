package com.sata.testapp.classes;

import java.io.Serializable;

/**
 * Created by kaotiks on 11/04/16.
 */
 
public class Airport implements Serializable {
    // Attributes
    private static final long serialVersionUID = 1L;
    private String formalName;
    private int iata;
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
    public int getIata() {
        return iata;
    }
    public void setIata(int iata) {
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
        return city;
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

    public void setupAirport(String iata){
        if(iata.equals("eze")){
            this.latitude = -34.820898;
            this.longitude = -58.534321;
            this.formalName = "Aeropuerto Internacional Ministro Pistarini (Ezeiza)";
            this.city = "CABA";
            this.state = "Buenos Aires";
            this.country = "Argentina";
        }
        if(iata.equals("mdq")){
            this.latitude = -37.933844;
            this.longitude = -57.583245;
            this.formalName = "Aeropuerto Internacional Ástor Piazzolla";
            this.city = "Mar del Plata";
            this.state = "Buenos Aires";
            this.country = "Argentina";
        }
        if(iata.equals("cor")){
            this.latitude = -31.314184;
            this.longitude = -64.214145;
            this.formalName = "Aeropuerto Internacional Ingeniero Ambrosio Taravella";
            this.city = "Córdoba";
            this.state = "Córdoba";
            this.country = "Argentina";
        }
        if(iata.equals("ush")){
            this.latitude = -54.841910;
            this.longitude = -68.308319;
            this.formalName = "Aeropuerto Internacional Malvinas Argentinas";
            this.city = "Ushuaia";
            this.state = "Tierra del fuego";
            this.country = "Argentina";
        }
        if(iata.equals("mns")){
            this.latitude = -25.737254;
            this.longitude = -54.473299;
            this.formalName = "Aeropuerto Internacional Cataratas del Iguazú";
            this.city = "Iguazú";
            this.state = "Misiones";
            this.country = "Argentina";
        }
    }
}
