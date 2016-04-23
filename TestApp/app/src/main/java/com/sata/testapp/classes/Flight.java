package com.sata.testapp.classes;

/**
 * Created by kaotiks on 12/04/16.
 */
 
public class Flight {
    // Attributes
    private String takeOffHour;
    private String landHour;
    // Used for "Vuelos con escala"
    //private List<Airport> flightPath;
    private int id;
    public String airline;
    private Airport from;
    private Airport to;
    
    // Constructor
    public Flight(){}

    public String toString(){
        return "Airline: In progress ..\n" +
                "From: " + this.from + "\n" +
                "To: " + this.to + "\n"
                ;
    }

    // Setup Airports
    public void setupAirports(Airport aFrom, Airport aTo){
        this.from = aFrom;
        this.to = aTo;
    }

    // Airport From
    public Airport getFrom() {
        return from;
    }
    public void setFrom(Airport from) {
        this.from = from;
    }

    // Airport To
    public Airport getTo() {
        return to;
    }
    public void setTo(Airport to) {
        this.to = to;
    }

    // Take off hour
    public String getTakeOffHour() {
        return takeOffHour;
    }
    public void setTakeOffHour(String takeOffHour) {
        this.takeOffHour = takeOffHour;
    }

    // Land hour
    public String getLandHour() {
        return landHour;
    }
    public void setLandHour(String landHour) {
        this.landHour = landHour;
    }
}
