package com.sata.testapp.classes;

import java.util.Vector;

public class UserData {
    // Available airports (set values from server)
    private Vector<Airport> airports;
    // Message id from server. Indicates know how to proceed according to the id number
    private int idMensaje;
    // Final result
    private int result;
    // User instance
    private User user;
    // Airport From
    private Airport airportFrom;
    // Airport To
    private Airport airportTo;
    // Flight instance
    private Flight flight;

    // Private constructor for singleton
    public UserData() {
        this.user = new User();
        this.airportFrom = new Airport();
        this.airportTo = new Airport();
        this.flight = new Flight();
        this.airports = new Vector<Airport>();

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
<<<<<<< Updated upstream

=======
>>>>>>> Stashed changes

    // Airport To
    public Airport getAirportTo() {
        return airportTo;
    }
    public void setAirportTo(Airport airportTo) {
        this.airportTo = airportTo;
    }

    // Flight
    public Flight getFlight() {
        return flight;
    }
    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    // Available airports
    public Vector<Airport> getAirports() {
        return airports;
    }
    public void setAirports(Vector<Airport> airports) {
        this.airports = airports;
    }

    // toString method
    public String toString(){
        return "lo que se te ocurra";
    }
}
