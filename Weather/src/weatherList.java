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
    
    private ArrayList<weatherType> weatherData = new ArrayList();
    private Date date = new Date();
    
    
    //constructor
    public weatherList()
    {
        
    }
    //add object at the end of the list
    void insert(weatherType w)
    {
        weatherData.add(w);
    }
    
    //sort the data by dates
    public void sortList(ArrayList<weatherType> weatherData)
    {
        
    }
    
    //data Range
    public ArrayList<weatherType> getRange(Date begin, Date end, ArrayList<weatherType> dateRange)
    {
        //change
        return dateRange;
    }
    
    
    //get avg temperature
    public Float avgTemp(Date begin, Date end, ArrayList<weatherType> dataRange)
    {
        //change
        return 0f;
    }
    
    public Float lowTemp(Date begin, Date end, ArrayList<weatherType> dataRange)
    {
        //change
        return 0f;
    }
    
    public Float highTemp(Date begin, Date end, ArrayList<weatherType> dataRange)
    {
        //change
        return 0f;
    }
    
    //get average wind speed
    public Float avgWindSpeed(Date begin, Date end, ArrayList<weatherType> dataRange)
    {
        return 0f;
    }
    
    public Float windDirction(Date begin, Date end, ArrayList<weatherType> dataRange)
    {
        return 0f;
    }
    
    public Float rainfall(Date begin, Date end, ArrayList<weatherType> dataRange)
    {
        return 0f;
    }
    
    public void cleanList()
    {
        
    }
}
