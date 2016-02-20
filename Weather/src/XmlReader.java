
import java.awt.List;
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
    
    public void ReadFile( String filePath )
    {
        // check usage
        if ( filePath.isEmpty() )
        {
            System.out.println( "Usage: java ReadXML1 file.xml" );
            return;
        }

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
                    throw new Exception("Missing weather tag");
                }
                // iterate through grandchild nodes
                NodeList mlist = nlist.item( i ).getChildNodes();
                for ( int j = 0; j < mlist.getLength(); j++ )
                {
                    String mlistName = mlist.item(j).getNodeName();
                    if(!mlistName.equals("#text"))
                    {
                        System.out.println( mlistName);
                        // print node tag and value
                        NodeList klist = mlist.item( j ).getChildNodes();
                        if ( klist.getLength() > 0 )
                        {
                            System.out.println( mlist.item( j ).getNodeName() + " = " + klist.item( 0 ).getNodeValue() );
                        }
                    }
                }
            }
        }
        catch ( Exception e )
        {
            System.out.println( e.toString() );
        }
    }
    
}
