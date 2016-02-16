/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherapplication;

// import statements
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author 1748229
 */
public class WeatherApplication extends JFrame {

    // private data
    private Container contents;
    
    public WeatherApplication()
    {
        // call JFrame constructor with title bar text
        super( "Weather Application" );
        
        // get container (JFrame content pane) for GUI components
        contents = getContentPane( );

        // set the layout manager
        contents.setLayout( new FlowLayout( ) );
        
         // set up menu bar
        JMenuBar menuBar = new JMenuBar();
        // register menu bar
        setJMenuBar( menuBar );
        // File menu
        JMenu menu = new JMenu( "File" );
        menuBar.add( menu );
        // selecting Quit will exit app
       JMenuItem mItem = new JMenuItem( "Quit" );
        mItem.addActionListener( new ActionListener()
        {
            public void actionPerformed( ActionEvent ae )
            {
                System.exit( 0 );
            }
        } );
        menu.add( mItem );

        
        
        setSize( 600, 600 );
        setLocationRelativeTo( null );
        // exit application when window is closed
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    }
    public static void main(String[] args) {
        // create GUI and go into event loop
        WeatherApplication gui = new WeatherApplication( );
        
        // make window visible
        gui.setVisible( true );
       
    }
    
}
