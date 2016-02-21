
import java.awt.List;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.w3c.dom.*;
import org.xml.sax.*;
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
//    private String time;
//    private Float temperature;
//    private Float humidity;
//    private Float barometer;
//    private Float windspeed;
//    private String windDirection;
//    private Float windGust;
//    private Float windChill;
//    private Float headIndex;
//    private Float uvIndex;
//    private Float rainFall;
      private HashMap WeatherData;

    //Map<String, List<String>> = new HashMap<String, List<String>>();
    public void XmlReader()
    {
        //HashMap WeatherData = new HashMap();
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
            for ( int i = 0; i < nlist.getLength(); i++ )
            {
                String nlistName = nlist.item(i).getNodeName();
                if(!nlistName.equals("weather") && !nlistName.equals("#text"))
                {
                    throw new Exception("Missing weather tag in XML");
                }
                // iterate through grandchild nodes
                NodeList mlist = nlist.item( i ).getChildNodes();
                String dateTemp = "";
                String timeTemp = "";
                for ( int j = 0; j < mlist.getLength(); j++ )
                {
                    String mlistName = mlist.item(j).getNodeName();
                    if(!mlistName.equals("#text"))
                    {
                        NodeList klist = mlist.item( j ).getChildNodes();
                        if ( klist.getLength() > 0 )
                        {
                            //System.out.println( mlist.item( j ).getNodeName() + " = " + klist.item( 0 ).getNodeValue() );
                            
                            switch(mlistName)
                            {
                                case "date":
                                    if(timeTemp.equals(""))
                                    {
                                        dateTemp = klist.item(0).getNodeValue();
                                    }
                                    else
                                    {
                                        SimpleDateFormat dateFormatter = new SimpleDateFormat ("MM/dd/yy-h:mma");
                                        System.out.println(dateFormatter.parse(klist.item(0).getNodeValue().trim() + "-" + timeTemp));
                                    }                                    
                                    break;
                                case "time":
                                    if(dateTemp.equals(""))
                                    {
                                        timeTemp = klist.item(0).getNodeValue().trim() + "M";
                                    }
                                    else
                                    {
                                        SimpleDateFormat dateFormatter = new SimpleDateFormat ("MM/dd/yy-h:mma");
                                        System.out.println(dateFormatter.parse(dateTemp.trim() + "-" + klist.item(0).getNodeValue().trim() + "M"));
                                    }
                                    break;
                                case "temperature":
                                    System.out.println("TEMPERATURE");
                                    break;
                                case "humidity":
                                    System.out.println("HUMIDITY");
                                    break;
                                case "barometer":
                                    System.out.println("BAROM");
                                    break;
                                case "windspeed":
                                    System.out.println("WS");
                                    break;
                                case "winddirection":
                                    System.out.println("WD");
                                    break;
                                case "windgust":
                                    System.out.println("WG");
                                    break;
                                case "windchill":
                                    System.out.println("WC");
                                    break;
                                case "heatindex":
                                    System.out.println("HI");
                                    break;
                                case "uvindex":
                                    System.out.println("UV");
                                    break;
                                case "rainfall":
                                    System.out.println("RAIN");
                                    break;
                                default:
                                    //throw new Exception("Missing weather tag");
                                    break;
                            }
                        }
                    }
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
