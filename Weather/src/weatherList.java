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
    
    private Vector<weatherType> weatherData;
    private Date date = new Date();
    
    //constructor
    public weatherList()
    {
        this.weatherData = new Vector<weatherType>();
    }
    //add object at the end of the list
    void insert(weatherType w)
    {
        weatherData.add(w);
    }
    
    //sort the data by dates
    public void sortList()
    {
        //change
        Collections.sort(this.weatherData);
    }
    
    
    //date Range, from a sorted list
    public weatherList getRange(Date begin, Date end)
    {
        weatherList dateRange = new weatherList();
        //change
        return dateRange;
    }
    
    
    //get avg temperature
    public Float avgTemp()
    {
        //change
        return 0f;
    }
    
    public Float lowTemp()
    {
        //change
        return 0f;
    }
    
    public Float highTemp()
    {
        //change
        return 0f;
    }
    
    //get average wind speed
    public Float avgWindSpeed()
    {
        return 0f;
    }
    
    public Float windDirction()
    {
        return 0f;
    }
    
    public Float rainfall()
    {
        return 0f;
    }
    
    public void clearList()
    {
        //empty list
    }
}
