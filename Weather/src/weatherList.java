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
import java.util.Map.Entry;

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
    private HashMap< String, Integer> windDir;    
    //constructor
    public weatherList()
    {
        this.size = 0;
        this.tolTemp = 0f;
        this.lowTemp = 999999f;
        this.highTemp = -1f;
        this.tolSpeed = 0f;
        this.maxSpeed = -1f;
        this.tolRainfall = 0f;
        this.windDir = new HashMap<String, Integer>();
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
    
    
    //add an object at the end of the list, and update everything
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
        
        //add windDir to the map and increment counter
        if (this.windDir.containsKey(w.getWindDirection()))
        {
            windDir.put(w.getWindDirection(), windDir.get(w.getWindDirection()) + 1 );
        }
        else
        {
            windDir.put(w.getWindDirection(), 0);
        }
        
        weatherData.add(w);
    }
    
    //sort the data by dates
    public void sortList()
    {
        if(this.size == 0)
        {
           System.out.println("WeatherList is empty, please enter some data"); 
           return;
        }
        Collections.sort(this.weatherData);
    }
    
    
    //date Range, from a sorted list
    public weatherList getRange(Date begin, Date end)
    {
        weatherList dateRange = new weatherList();
        
        int i = 0;
        
        //following are a binary search on the list based date
        int mid = this.size/2;
        int left = 0;
        int right = this.size;
        while (this.weatherData.get(mid).getDateTime().compareTo(begin) != 0)
        {
            //update mid, left and right based its condition
            if(this.weatherData.get(mid).getDateTime().compareTo(begin) > 0)
            {
                mid = (left + mid)/2;
                right = mid;
                
            }
            else
            {
                mid = (mid + right)/2;
                left = mid;
            }
        }
        
        //find the index
        i = mid;
        
        //insert needed date to the list to the list
        while(this.weatherData.get(i).getDateTime().compareTo(end) != 0)
        {
            dateRange.insert(this.weatherData.get(i));
            i++;
        }
        return dateRange;
    }
    
    //calculate average temp
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
    
    //get most prevailing wind Dir
    public String prevailWind()
    {
        if(this.size == 0)
        {
           System.out.println("WeatherList is empty, please enter some data"); 
           return "";
        }
        int max = Collections.max(windDir.values());
        String maxEntry = "";
        for(Entry<String, Integer> entry: windDir.entrySet())
        {
            if(entry.getValue() == max)
            {
                maxEntry = entry.getKey();
            }
        }
        return maxEntry;
    }
    
    //calculate avg speed
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
