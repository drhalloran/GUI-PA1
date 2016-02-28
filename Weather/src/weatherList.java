 /************************************************************************
*  Program:     Weather Station Display
*  Author:      Daniel Halloran， Dicheng Wu and Yanlin Li
*  Class:       CSC-468 -  GUI Programming 
*  Instructor:  Dr.Weiss
*  Date:        March 1st, 2016
*  Description: Weather impacts many aspects of our daily lives: where we choose 
*               to live, the activities we participate in, how we dress, the 
*               food we eat, conversation topics, etc. Sophisticated personal
*               weather stations are available for home use at reasonable 
*               prices, and can be connected to web based worldwide live weather 
*               station networks. Weather station hardware includes sensors for
*               temperature, humidity, barometric pressure, wind speed and 
*               direction, rainfall, and other weather related measurements. 
*               This data may be logged to a computer for analysis and display.
*  Input:       Weather Data, mouse event and keyboard event
*  Output:      Graphs that corresponding to the events that user choose
*  Compilation instructions:    Run in NetBeans
*  Usage:       Check for yearly/monthly/weekly/daily weather statistics and 
*               show graphic representation for corresponding time periods.
*
*  Known bugs/missing features: 
*  
 ************************************************************************/

/*
*   This is a container class for weather type. This class also have some 
*   build in functions.
*/
import java.util.*;
import java.util.Map.Entry;

/**
 *
 * @author yli23797
 */
public class weatherList 
{
    
    
    private Vector<weatherType> weatherData;    //list that stores weatherType
    private int size;                           //variable that keep track size of the list
    private float tolTemp;                      //variable keep track toltal temperature
    private float lowTemp;                      //stores the low temp for the list
    private float highTemp;                     //stores high temp for the list
    private float tolSpeed;                     //stores total speed for the list
    private float maxSpeed;                     //stores max speed for the list
    private float tolRainfall;                  //stores the total rainfall
    private HashMap< String, Integer> windDir;  //map that keep track which is most frenquent appreaed widn direction
    
    
    //constructor
    public weatherList()
    {
        this.size = 0;
        this.tolTemp = 0f;
        this.lowTemp = Float.MAX_VALUE;
        this.highTemp = Float.MIN_VALUE;
        this.tolSpeed = 0f;
        this.maxSpeed = Float.MIN_VALUE;
        this.tolRainfall = 0f;
        this.windDir = new HashMap<String, Integer>();
        this.weatherData = new Vector<weatherType>();
    }
    
    
/************************************************************************
   Function:    getWeatherData()  
   Author:      Yanlin Li
   Description: get weather  list
   Parameters:
 ************************************************************************/
    public Vector<weatherType> getWeatherData() 
    {
        return weatherData;
    }
    
/************************************************************************
   Function:    getSize()  
   Author:      Yanlin Li
   Description: get the list of the list
   Parameters:
 ************************************************************************/
    public int getSize() 
    {
        return size;
    }

/************************************************************************
   Function:    getTolTemp()  
   Author:      Yanlin Li
   Description: get total temp for the list
   Parameters:
 ************************************************************************/
    public float getTolTemp() 
    {
        
        if(this.size == 0)
        {
           System.out.println("WeatherList is empty, please enter some data");
           return -1f;
        }
        return tolTemp;
    }

    
/************************************************************************
   Function:    getLowTemp()  
   Author:      Yanlin Li
   Description: get minium temp for the list
   Parameters:
 ************************************************************************/
    public float getLowTemp() 
    {
        //check if the list is empty
        if(this.size == 0)
        {
           System.out.println("WeatherList is empty, please enter some data");
           return -1f;
        }
        return lowTemp;
    }

/************************************************************************
   Function:    getLowTemp()  
   Author:      Yanlin Li
   Description: get max temp for the list
   Parameters:
 ************************************************************************/
    public float getHighTemp() 
    {
        //check if the list is empty 
        if(this.size == 0)
        {
           System.out.println("WeatherList is empty, please enter some data"); 
           return -1f;
        }
        return highTemp;
    }
    
    public float getTolSpeed() 
    {
        //check if the list is empty
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
        //increment the size when an element is inserted
        this.size = this.size + 1;
        //increment total temp
        this.tolTemp += w.getTemperature();
        //increment total wind speed
        this.tolSpeed += w.getWindspeed();
        //increment total rain fall
        this.tolRainfall +=w.getRainFall();
        
        //update max temp
        if(w.getTemperature() > this.highTemp )
        {
            this.highTemp = w.getTemperature();
        }
        
        //update low temp
        if(w.getTemperature() < this.lowTemp )
        {
            this.lowTemp = w.getTemperature();
        }
        
        //update max speed
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
        
        //insert weatherType to the list
        weatherData.add(w);
    }
    
    //sort the data by dates
    public void sortList()
    {
        //check if the list is empty
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
        //initialize the list 
        weatherList dateRange = new weatherList();
        
        //temp variable
        int i = 0;
        
        //following are a binary search on the list based date
        int mid = this.size/2;
        int left = 0;
        int right = this.size;
        
        //loop for binary search 
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
        //check if the list is empty 
        if(this.size == 0)
        {
           System.out.println("WeatherList is empty, please enter some data");
           return -1f;
        }
        //temp variable
        float avg = 0f;
        //get avg temp
        avg = this.tolTemp/this.size;
        
        
        return avg;
    }
    
    //get most prevailing wind Dir
    public String prevailWind()
    {
        //check if the list is empty 
        if(this.size == 0)
        {
           System.out.println("WeatherList is empty, please enter some data"); 
           return "";
        }
        
        
        //get maximum entry 
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
