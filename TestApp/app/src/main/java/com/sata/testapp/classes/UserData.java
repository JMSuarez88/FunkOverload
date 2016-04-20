package com.sata.testapp.classes;

import android.content.Context;

/**
 * Created by kaotiks on 19/04/16.
 */

public class UserData {
    // Attributes
    private User user;
    private Airport airportFrom;
    private Airport airportTo;
    private Flight flight;

    public UserData(Context context) {
        this.user = User.createUser(context);
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
