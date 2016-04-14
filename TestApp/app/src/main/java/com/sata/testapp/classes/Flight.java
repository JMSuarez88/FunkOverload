package com.sata.testapp.classes;

import java.util.List;

/**
 * Created by kaotiks on 12/04/16.
 */
 
public class Flight {
    // Attributes
    private int id;
    public String airline;
    private List<Airport> flightPath;
    private Airport from;
    private Airport to;
    
    // Constructor
    public Flight(Airport from, Airport to){
		this.from = from;
		this.to = to;
	}

}
