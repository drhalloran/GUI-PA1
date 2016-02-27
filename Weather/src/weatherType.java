
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yli23797
 */
public class weatherType implements Comparable<weatherType>{

        private Date dateTime; 
        private float temperature;
        private float humidity;
        private float barometer;
        private float windspeed; 
        private String windDirection;
        private float windGust;
        private float windChill;
        private float headIndex;
        private float uvIndex;
        private float rainFall;
        weatherList weatherList = new weatherList();
        
        
    public weatherType()
    {
        this.dateTime = new Date();
        this.temperature = Float.MAX_VALUE;
        this.humidity = Float.MAX_VALUE;
        this.barometer = Float.MAX_VALUE;
        this.windspeed = Float.MAX_VALUE;
        this.windDirection = "";
        this.windGust = Float.MAX_VALUE;
        this.windChill = Float.MAX_VALUE;
        this.headIndex = Float.MAX_VALUE;
        this.uvIndex = Float.MAX_VALUE;
        this.rainFall = Float.MAX_VALUE;
    }
    
    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        
        //call destructor
        //initialize new object
        this.dateTime = dateTime;
    }
    
    public Float getTemperature() {
        return temperature;
    }
 
    public void setTemperature(Float temperature) {
        this.temperature = temperature;
    }

    public Float getHumidity() {
        return humidity;
    }

    public void setHumidity(Float humidity) {
        this.humidity = humidity;
    }

    public Float getBarometer() {
        return barometer;
    }

    public void setBarometer(Float barometer) {
        this.barometer = barometer;
    }

    public Float getWindspeed() {
        return windspeed;
    }

    public void setWindspeed(Float windspeed) {
        this.windspeed = windspeed;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }

    public Float getWindGust() {
        return windGust;
    }

    public void setWindGust(Float windGust) {
        this.windGust = windGust;
    }

    public Float getWindChill() {
        return windChill;
    }

    public void setWindChill(Float windChill) {
        this.windChill = windChill;
    }

    public Float getHeadIndex() {
        return headIndex;
    }

    public void setHeadIndex(Float headIndex) {
        this.headIndex = headIndex;
    }

    public Float getUvIndex() {
        return uvIndex;
    }

    public void setUvIndex(Float uvIndex) {
        this.uvIndex = uvIndex;
    }

    public Float getRainFall() {
        return rainFall;
    }

    public void setRainFall(Float rainFall) {
        this.rainFall = rainFall;
    }
    
    public int compareTo(weatherType a)
    {
        return this.getDateTime().compareTo(a.getDateTime());
    }
    
    public void updateList()
    {
        weatherList.insert(this);
    }
}

