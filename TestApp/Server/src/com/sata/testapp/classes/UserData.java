package com.sata.testapp.classes;

import java.io.Serializable;

public class UserData implements Serializable{
    private static final long serialVersionUID = 1L;
    private int idMensaje;
    private User user;
    private Airport airportFrom;
    private Airport airportTo;
    private Flight flight;

    public UserData() {
        this.user = User.createUser();
        this.airportFrom = new Airport();
        this.airportTo = new Airport();
        this.flight = new Flight();
    }

    // User
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    // Id Mensaje
    public int getIdMensaje() {
        return idMensaje;
    }
    public void setIdMensaje(int idMensaje) {
        this.idMensaje = idMensaje;
    }

    // Airport From
    public Airport getAirportFrom() {
        return airportFrom;
    }
    public void setAirportFrom(Airport airportFrom) {
        this.airportFrom = airportFrom;
    }
    public void setupAirportFrom(String iata) {
        this.airportFrom.setupAirport(iata);
    }

    // Airport To
    public Airport getAirportTo() {
        return airportTo;
    }
    public void setAirportTo(Airport airportTo) {
        this.airportTo = airportTo;
    }
    public void setupAirportTo(String iata) {
        this.airportTo.setupAirport(iata);
    }

    // Flight
    public Flight getFlight() {
        return flight;
    }
    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public String toString(){
        return "From: " + getAirportFrom().getPublicName() + "\n" +
                "To: " + getAirportTo().getPublicName() + "\n"
                ;
    }
}
