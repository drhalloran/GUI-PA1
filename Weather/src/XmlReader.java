import java.text.SimpleDateFormat;
import java.util.Date;
import org.w3c.dom.*;
import javax.xml.parsers.*;

    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 1748229
 */
public class XmlReader {
    public void XmlReader()
    {
    }
    
    public boolean ReadFile( String filePath )
    {
        // read and parse XML document
        try
        {
            // get root node of XML document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse( filePath );
            
            // iterate through child nodes
            NodeList nlist = document.getDocumentElement().getChildNodes();
            weatherType weatherdata = new weatherType();
            for ( int i = 0; i < nlist.getLength(); i++ )
            {
                String nlistName = nlist.item(i).getNodeName();
                //Check to make sure top xml node is weather or #text
                if(!nlistName.equals("weather") && !nlistName.equals("#text"))
                {
                    throw new Exception("Missing weather tag in XML");
                }
                // iterate through grandchild nodes
                NodeList mlist = nlist.item( i ).getChildNodes();
                //temporary variables used for combining date and time
                String dateTemp = "";
                String timeTemp = "";
                
                for ( int j = 0; j < mlist.getLength(); j++ )
                {
                    //get current node name (date, humidty, temp, etc)
                    String mlistName = mlist.item(j).getNodeName();
                    //skip any text nodes
                    if(!mlistName.equals("#text"))
                    {
                         
                        NodeList klist = mlist.item( j ).getChildNodes();
                        if ( klist.getLength() > 0 )
                        {
                            //Set correct data based on current xml node
                            //klist.item(0).getNodeValue() will give the value of the current xml node
                            switch(mlistName)
                            {
                                case "date":
                                    //if timeTemp hasn't been set just store the date to the temp variable
                                    if(timeTemp.equals(""))
                                    {
                                        dateTemp = klist.item(0).getNodeValue();
                                    }
                                    //If both time and date are available, combine strings and store to date object
                                    else
                                    {
                                        SimpleDateFormat dateFormatter = new SimpleDateFormat ("MM/dd/yy-h:mma");
                                        Date date = dateFormatter.parse(klist.item(0).getNodeValue().trim() + "-" + timeTemp);
                                        weatherdata.setDateTime(date);
                                    }                                    
                                    break;
                                case "time":
                                    //if dateTemp hasn't been set just store the date to the temp variable
                                    if(dateTemp.equals(""))
                                    {
                                        timeTemp = klist.item(0).getNodeValue().trim() + "M";
                                    }
                                    //If both time and date are available, combine strings and store to date object
                                    else
                                    {
                                        SimpleDateFormat dateFormatter = new SimpleDateFormat ("MM/dd/yy-h:mma");
                                        Date date = dateFormatter.parse(dateTemp.trim() + "-" + klist.item(0).getNodeValue().trim() + "M");
                                        weatherdata.setDateTime(date);
                                    }
                                    break;
                                case "temperature":
                                    weatherdata.setTemperature(Float.parseFloat(klist.item(0).getNodeValue().trim()));
                                    break;
                                case "humidity":
                                    weatherdata.setHumidity(Float.parseFloat(klist.item(0).getNodeValue().trim()));
                                    break;
                                case "barometer":
                                    weatherdata.setBarometer(Float.parseFloat(klist.item(0).getNodeValue().trim()));
                                    break;
                                case "windspeed":
                                    weatherdata.setWindspeed(Float.parseFloat(klist.item(0).getNodeValue().trim()));
                                    break;
                                case "winddirection":
                                    weatherdata.setWindDirection(klist.item(0).getNodeValue().trim());
                                    break;
                                case "windgust":
                                    weatherdata.setWindGust(Float.parseFloat(klist.item(0).getNodeValue().trim()));
                                    break;
                                case "windchill":
                                    weatherdata.setWindChill(Float.parseFloat(klist.item(0).getNodeValue().trim()));
                                    break;
                                case "heatindex":
                                    weatherdata.setHeadIndex(Float.parseFloat(klist.item(0).getNodeValue().trim()));
                                    break;
                                case "uvindex":
                                    weatherdata.setUvIndex(Float.parseFloat(klist.item(0).getNodeValue().trim()));
                                    break;
                                case "rainfall":
                                    weatherdata.setRainFall(Float.parseFloat(klist.item(0).getNodeValue().trim()));
                                    break;
                                default:
                                    //throw new Exception("Missing weather tag");
                                    break;
                            }
                        }
                    }
                }
                if(nlistName.equals("weather"))
                {
                    System.out.println("------------iteration----------");
                }
            }
        }
        catch ( Exception e )
        {
            System.out.println( e.toString() );
            return false;
        }
        return true;
    }
    
}
