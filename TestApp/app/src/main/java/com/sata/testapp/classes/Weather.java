package com.sata.testapp.classes;

import com.github.dvdme.ForecastIOLib.FIOCurrently;
import com.github.dvdme.ForecastIOLib.FIOHourly;
import com.github.dvdme.ForecastIOLib.ForecastIO;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by kaotiks on 14/04/16.
 */

public class Weather {
    // Attributes
    private final String key = "542d1369c43cfb0a85122e17142de63a";
    private FIOCurrently fioCurrently;
    private FIOHourly fioHourly;
    private ForecastIO fio;
    private Date currentDate;
    private WeatherData weatherData;
    private Flight flight;

    public Weather(String  lat, String lon) {
        this.fio = new ForecastIO(lat,lon,key);
        this.fioCurrently = new FIOCurrently(this.fio);
        this.fioHourly = new FIOHourly(this.fio);
        this.currentDate = new Date();
        this.flight = new Flight();
    }

    public void setupWeatherData(){
        int toh = Integer.parseInt(this.flight.getTakeOffHour().substring(0,2));
        int diff = toh - getHour();
        if(diff < 3){
            this.weatherData = new WeatherData(this.fioCurrently);
        } else {
            this.weatherData = new WeatherData(this.fioHourly,diff-3);
        }

    }
    public WeatherData getWeatherData(){
        return this.weatherData;
    }

    public int getHour(){
        int hour;
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(this.currentDate);
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        return hour;
    }

    public int getWeatherHour(){
        int hour;
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(new Date((long)Integer.parseInt(this.fioHourly.getHour(0).getByKey("time"))*1000));
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        return hour;
    }
}
