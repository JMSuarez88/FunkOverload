package com.sata.testapp.classes;

import com.github.dvdme.ForecastIOLib.FIOCurrently;
import com.github.dvdme.ForecastIOLib.FIOHourly;

/**
 * Created by kaotiks on 23/04/16.
 */


// toDo : CONVERTIR VALORES TEMPERATURA, ETC


public class WeatherData {
    private int time;
    private double precipIntensity,
    precipProbability,
    temperature,
    dewPoint,
    humidity,
    windSpeed,
    windBearing,
    visibility,
    cloudCover,
    pressure;
    private boolean nieblaRadiacion;

    public WeatherData(FIOCurrently fc){
        this.time = Integer.parseInt(fc.get().getByKey("time"));
        this.precipIntensity = Double.parseDouble(fc.get().getByKey("precipIntensity"));
        this.precipProbability = Double.parseDouble(fc.get().getByKey("precipProbability"));
        this.temperature = Double.parseDouble(fc.get().getByKey("temperature"));
        this.dewPoint = Double.parseDouble(fc.get().getByKey("dewPoint"));
        this.humidity = Double.parseDouble(fc.get().getByKey("humidity"));
        this.windSpeed = Double.parseDouble(fc.get().getByKey("windSpeed"));
        this.windBearing = Double.parseDouble(fc.get().getByKey("windBearing"));
        this.visibility = Double.parseDouble(fc.get().getByKey("visibility"));
        this.cloudCover = Double.parseDouble(fc.get().getByKey("cloudCover"));
        this.pressure = Double.parseDouble(fc.get().getByKey("pressure"));
        setNieblaRadiacion();
    }

    public WeatherData(FIOHourly fh, int n){
        this.time = Integer.parseInt(fh.getHour(n).getByKey("time"));
        this.precipIntensity = Double.parseDouble(fh.getHour(n).getByKey("precipIntensity"));
        this.precipProbability = Double.parseDouble(fh.getHour(n).getByKey("precipProbability"));
        this.temperature = Double.parseDouble(fh.getHour(n).getByKey("temperature"));
        this.dewPoint = Double.parseDouble(fh.getHour(n).getByKey("dewPoint"));
        this.humidity = Double.parseDouble(fh.getHour(n).getByKey("humidity"));
        this.windSpeed = Double.parseDouble(fh.getHour(n).getByKey("windSpeed"));
        this.windBearing = Double.parseDouble(fh.getHour(n).getByKey("windBearing"));
        this.visibility = Double.parseDouble(fh.getHour(n).getByKey("visibility"));
        this.cloudCover = Double.parseDouble(fh.getHour(n).getByKey("cloudCover"));
        this.pressure = Double.parseDouble(fh.getHour(n).getByKey("pressure"));
    }

    public void setNieblaRadiacion(){
        if(this.temperature == 5 && this.humidity == 85 && this.cloudCover <= 0.3)
            this.nieblaRadiacion = true;
    }
}
