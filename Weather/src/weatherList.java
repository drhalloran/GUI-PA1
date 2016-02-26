/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * todo list: 
 *   constructor
 *   range of dates
 *   avg function
 */

import java.util.*;

/**
 *
 * @author yli23797
 */
public class weatherList 
{
    
    public Vector<weatherType> weatherData;
    private int size;
    private float tolTemp;
    private float lowTemp;
    private float highTemp;
    private float tolSpeed;
    private float maxSpeed;
    private float tolRainfall;
    
    //constructor
    public weatherList()
    {
        this.size = 0;
        this.weatherData = new Vector<weatherType>();
    }
    

    public int getSize() 
    {
       
        return size;
    }

    public float getTolTemp() 
    {
        
        if(this.size == 0)
        {
           System.out.println("WeatherList is empty, please enter some data");
           return -1f;
        }
        return tolTemp;
    }

    public float getLowTemp() 
    {
        if(this.size == 0)
        {
           System.out.println("WeatherList is empty, please enter some data");
           return -1f;
        }
        return lowTemp;
    }

    public float getHighTemp() 
    {
        if(this.size == 0)
        {
           System.out.println("WeatherList is empty, please enter some data"); 
           return -1f;
        }
        return highTemp;
    }
    
    public float getTolSpeed() 
    {
        if(this.size == 0)
        {
           System.out.println("WeatherList is empty, please enter some data");
           return -1f;
        }
        return tolSpeed;
    }

    public float getMaxSpeed() 
    {
        if(this.size == 0)
        {
           System.out.println("WeatherList is empty, please enter some data");
           return -1f;
        }
        return maxSpeed;
    }

    public float getTolRainfall() 
    {
        if(this.size == 0)
        {
           System.out.println("WeatherList is empty, please enter some data");
           return -1f;
        }
        return tolRainfall;
    }
    
    
    //add object at the end of the list
    void insert(weatherType w)
    {
        this.size = this.size + 1;
        this.tolTemp += w.getTemperature();
        this.tolSpeed += w.getWindspeed();
        this.tolRainfall +=w.getRainFall();
        
        if(w.getTemperature() > this.highTemp )
        {
            this.highTemp = w.getTemperature();
        }
        
        
        if(w.getTemperature() < this.lowTemp )
        {
            this.lowTemp = w.getTemperature();
        }
        if (w.getWindGust() > this.maxSpeed)
        {
            this.maxSpeed = w.getWindGust();
        }
        weatherData.add(w);
    }
    
    //sort the data by dates
    public void sortList()
    {
        
        Collections.sort(this.weatherData);
    }
    
    
    //date Range, from a sorted list
    public weatherList getRange(Date begin, Date end)
    {
        weatherList dateRange = new weatherList();
        
        for(int i = 0; i < this.size; i++)
        {
            if(this.weatherData.get(i).getDateTime().compareTo(begin) >= 0
                && this.weatherData.get(i).getDateTime().compareTo(begin) <= 0)
            {
                dateRange.insert(this.weatherData.get(i));
            }
            
        }
        
        return dateRange;
    }
    
    public float avgTemp()
    {
        if(this.size == 0)
        {
           System.out.println("WeatherList is empty, please enter some data");
           return -1f;
        }
        float avg = 0f;
        avg = this.tolTemp/this.size;
        return avg;
    }
    public float avgSpeed()
    {
        if(this.size == 0)
        {
           System.out.println("WeatherList is empty, please enter some data");
           return -1f;
        }
        float avg;
        avg = this.tolSpeed/this.size;
        return avg;
    }
   
}
