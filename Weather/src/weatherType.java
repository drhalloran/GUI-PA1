/*
    This is weather type class. It contains one weather type
*/
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

        private Date dateTime;      //date type
        private float temperature;  //store temprature
        private float humidity;     //stores humidity
        private float barometer;    //stores barometer
        private float windspeed;    //stores wind spped
        private String windDirection;   //stores wind direction
        private float windGust;         //stores wind Gust
        private float windChill;        //stores wind chill
        private float headIndex;        //stores headIndex
        private float uvIndex;          //stores uvIndex
        private float rainFall;         //stores rainFall
        
    //constructor, initialize variables to something
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
    
/************************************************************************
   Function:    getDateTime()  
   Author:      Yanlin Li
   Description: get the DateTime
   Parameters:
 ************************************************************************/
    public Date getDateTime() {
        return dateTime;
    }

/************************************************************************
   Function:    SetDateTime()  
   Author:      Yanlin Li
   Description: set the DateTime
   Parameters:
 ************************************************************************/
    public void setDateTime(Date dateTime) {
        
        //call destructor
        //initialize new object
        this.dateTime = dateTime;
    }

/************************************************************************
   Function:    getTemperature()  
   Author:      Yanlin Li
   Description: get the temperature
   Parameters:
 ************************************************************************/
    public Float getTemperature() {
        return temperature;
    }
/************************************************************************
   Function:    setTemperature()  
   Author:      Yanlin Li
   Description: set the temperature
   Parameters:
 ************************************************************************/
    public void setTemperature(Float temperature) {
        this.temperature = temperature;
    }
/************************************************************************
   Function:    getHumidity()  
   Author:      Yanlin Li
   Description: get the Humidity
   Parameters:
 ************************************************************************/
    public Float getHumidity() {
        return humidity;
    }
/************************************************************************
   Function:    setHumidity()  
   Author:      Yanlin Li
   Description: set the Humidity
   Parameters:
 ************************************************************************/
    public void setHumidity(Float humidity) {
        this.humidity = humidity;
    }
/************************************************************************
   Function:    getBarometer()  
   Author:      Yanlin Li
   Description: get the Barometer
   Parameters:
 ************************************************************************/
    public Float getBarometer() {
        return barometer;
    }
/************************************************************************
   Function:    setBarometer()  
   Author:      Yanlin Li
   Description: set the Barometer
   Parameters:
 ************************************************************************/
    public void setBarometer(Float barometer) {
        this.barometer = barometer;
    }

/************************************************************************
   Function:    getWindspeed()  
   Author:      Yanlin Li
   Description: get the wind speed
   Parameters:
 ************************************************************************/
    public Float getWindspeed() {
        return windspeed;
    }

/************************************************************************
   Function:    setWindspeed()  
   Author:      Yanlin Li
   Description: set the wind speed
   Parameters:
 ************************************************************************/
    public void setWindspeed(Float windspeed) {
        this.windspeed = windspeed;
    }
    
/************************************************************************
   Function:    getWindDirection()  
   Author:      Yanlin Li
   Description: get the wind Direction
   Parameters:
 ************************************************************************/
    public String getWindDirection() {
        return windDirection;
    }
    
/************************************************************************
   Function:    setWindDirection()  
   Author:      Yanlin Li
   Description: set the wind Direction
   Parameters:
 ************************************************************************/

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }

/************************************************************************
   Function:    getWindGust()  
   Author:      Yanlin Li
   Description: get the wind Gust
   Parameters:
 ************************************************************************/
    public Float getWindGust() {
        return windGust;
    }

/************************************************************************
   Function:    setWindGust()  
   Author:      Yanlin Li
   Description: set the wind Gust
   Parameters:
 ************************************************************************/
    public void setWindGust(Float windGust) {
        this.windGust = windGust;
    }

/************************************************************************
   Function:    getWindChill()  
   Author:      Yanlin Li
   Description: get the wind Chill
   Parameters:
 ************************************************************************/
    public Float getWindChill() {
        return windChill;
    }

/************************************************************************
   Function:    setWindChill()  
   Author:      Yanlin Li
   Description: set the setWindChill
   Parameters:
 ************************************************************************/
    public void setWindChill(Float windChill) {
        this.windChill = windChill;
    }

/************************************************************************
   Function:    getHeadIndex()
   Author:      Yanlin Li
   Description: get the HeadIndex
   Parameters:
 ************************************************************************/
    public Float getHeadIndex() {
        return headIndex;
    }

/************************************************************************
   Function:    setHeadIndex()
   Author:      Yanlin Li
   Description: set the HeadIndex
   Parameters:
 ************************************************************************/
    public void setHeadIndex(Float headIndex) {
        this.headIndex = headIndex;
    }

/************************************************************************
   Function:    getUvIndex()()
   Author:      Yanlin Li
   Description: get the UvIndex
   Parameters:
 ************************************************************************/
    public Float getUvIndex() {
        return uvIndex;
    }
    
/************************************************************************
   Function:    setUvIndex()()
   Author:      Yanlin Li
   Description: set the UvIndex
   Parameters:
 ************************************************************************/
    public void setUvIndex(Float uvIndex) {
        this.uvIndex = uvIndex;
    }
    
/************************************************************************
   Function:    getRainFall()
   Author:      Yanlin Li
   Description: get the rainfall
   Parameters:
 ************************************************************************/
    public Float getRainFall() {
        return rainFall;
    }

/************************************************************************
   Function:    setRainFall()
   Author:      Yanlin Li
   Description: set the rainfall
   Parameters:
 ************************************************************************/
    public void setRainFall(Float rainFall) {
        this.rainFall = rainFall;
    }

/************************************************************************
   Function:    compareTo(weatherType a)
   Author:      Yanlin Li
   Description: use to sort the list
   Parameters:
 ************************************************************************/
    public int compareTo(weatherType a)
    {
        return this.getDateTime().compareTo(a.getDateTime());
    }
}

