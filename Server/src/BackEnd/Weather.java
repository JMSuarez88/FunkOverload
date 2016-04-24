package BackEnd;
import com.eclipsesource.json.JsonObject;
import com.github.dvdme.ForecastIOLib.FIOCurrently;
import com.github.dvdme.ForecastIOLib.FIOHourly;
import com.github.dvdme.ForecastIOLib.ForecastIO;


import java.util.concurrent.TimeUnit;

/**
 * Created by kaotiks on 14/04/16.
 */

public class Weather {
    // Attributes
    private final String key = "542d1369c43cfb0a85122e17142de63a";
    private FIOCurrently fioHourly;
    private JsonObject hourly;
    private ForecastIO fio;

    public Weather(String  lat, String lon) {
        this.fio = new ForecastIO(lat,lon,key);
        this.fioHourly = new FIOCurrently(this.fio);
        this.hourly = this.fio.getHourly();
    }

    public long printWeatherData(){
        String result = "";
        int resultInt = 0;

        /*for(int i=0;i<10;i++){
            result += this.fioHourly.getHour(i).getByKey("time")+"\n";
        }*/
        result += this.fio.getCurrently().get("time");

        resultInt = 1461023940 - this.fio.getCurrently().get("time").asInt();

        TimeUnit.MICROSECONDS.toHours(resultInt);

        return TimeUnit.MICROSECONDS.toHours(resultInt);
        //return this.fioHourly.get().getByKey("time");
    }
}
