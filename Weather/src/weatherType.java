
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
        private Float temperature;
        private Float humidity;
        private Float barometer;
        private Float windspeed; 
        private String windDirection;
        private Float windGust;
        private Float windChill;
        private Float headIndex;
        private Float uvIndex;
        private Float rainFall;
        
        
    public weatherType(){
        this.temperature = 0.0f;
        this.humidity = 0.0f;
        this.barometer = 0.0f;
        this.windspeed = 0.0f;
        this.windDirection = " ";
        this.windGust = 0.0f;
        this.windChill = 0.0f;
        this.headIndex = 0.0f;
        this.uvIndex = 0.0f;
        this.rainFall = 0.0f;
    }
    
    public Date getDateTime() {
        return dateTime;
    }
    
     
    public int compareTo(weatherType a)
    {
        return this.getDateTime().compareTo(a.getDateTime());
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
    
    public void clear()
    {
        
    }

}

