/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.io.File;
import javax.swing.ButtonGroup;
import javax.swing.JFileChooser;
import org.jfree.chart.ChartFactory;


import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.ThermometerPlot;
import org.jfree.data.general.DefaultValueDataset;
import org.jfree.data.general.ValueDataset;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleInsets;



/**
 *
 * @author 7304859
 */
public class WeatherFrame extends javax.swing.JFrame {
    JFileChooser fc;
    /**
     * Creates new form WeatherFrame
     */
    TimeSeriesCollection TempSet;
    public WeatherFrame() {
        initComponents();
        
        fc = new JFileChooser();
        fc.setMultiSelectionEnabled(true);
        
        //only can select a single button a time
        ButtonGroup group = new ButtonGroup();
        group.add(AllRadioButton);
        group.add(YearlyRadioButton);
        group.add(MonthlyRadioButton);
        group.add(WeeklyRadioButton);
        group.add(DailyRadioButton);
        
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Temperature", "Humidity", "Barometric Pressure", "Windspeed", "UVindex", "Raindfall"}));

        
        TempSet = new TimeSeriesCollection();
        JFreeChart chart = ChartFactory.createXYLineChart("Temperature", "", "Degree Fahrenheit", TempSet, PlotOrientation.VERTICAL, true, true, false);  
        chart.setBackgroundPaint(Color.white);
        ChartPanel.setLayout(new java.awt.BorderLayout());
        ChartPanel CP = new ChartPanel(chart);
        CP.setPreferredSize(new Dimension(ChartPanel.getWidth(), ChartPanel.getHeight()));
        ChartPanel.add(CP,BorderLayout.CENTER);
        
        
        
        DefaultValueDataset dataset = new DefaultValueDataset(20f);   
        ThermometerPlot thermometerplot = new ThermometerPlot(dataset);   
        JFreeChart jfreechart = new JFreeChart("", JFreeChart.DEFAULT_TITLE_FONT, thermometerplot, true); 
        jfreechart.setBackgroundPaint(new Color(240,240,240));
        thermometerplot.setThermometerPaint(Color.lightGray);
        thermometerplot.setThermometerStroke(new BasicStroke(2.0F));
        ChartPanel DP = new ChartPanel(jfreechart);
        DP.setPreferredSize(new Dimension(TempThermoPanel.getWidth(), TempThermoPanel.getHeight()));
        TempThermoPanel.setLayout(new java.awt.BorderLayout());
        TempThermoPanel.add(DP);
        TempThermoPanel.validate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        ChartPanel = new javax.swing.JPanel();
        OptionPanel = new javax.swing.JPanel();
        ChooserLabel = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        ChooseIntervelLabel = new javax.swing.JLabel();
        DailyRadioButton = new javax.swing.JRadioButton();
        WeeklyRadioButton = new javax.swing.JRadioButton();
        MonthlyRadioButton = new javax.swing.JRadioButton();
        YearlyRadioButton = new javax.swing.JRadioButton();
        AllRadioButton = new javax.swing.JRadioButton();
        PreviousButton = new javax.swing.JButton();
        NextButton = new javax.swing.JButton();
        SnapCheckBox = new javax.swing.JCheckBox();
        InstrumentPanel = new javax.swing.JPanel();
        TempThermoPanel = new javax.swing.JPanel();
        WeatherMenuBar = new javax.swing.JMenuBar();
        FileMenu = new javax.swing.JMenu();
        OpenMenuItem = new javax.swing.JMenuItem();
        QuitMenuItem = new javax.swing.JMenuItem();
        StatMenu = new javax.swing.JMenu();
        MeanTempMenuItem = new javax.swing.JMenuItem();
        HighTempMenuItem = new javax.swing.JMenuItem();
        LowTempMenuItem = new javax.swing.JMenuItem();
        MeanWindMenuItem = new javax.swing.JMenuItem();
        MaxWindMenuItem = new javax.swing.JMenuItem();
        PrevWindMenuItem = new javax.swing.JMenuItem();
        RainfallMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Weather Data Grapher");

        ChartPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout ChartPanelLayout = new javax.swing.GroupLayout(ChartPanel);
        ChartPanel.setLayout(ChartPanelLayout);
        ChartPanelLayout.setHorizontalGroup(
            ChartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );
        ChartPanelLayout.setVerticalGroup(
            ChartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 323, Short.MAX_VALUE)
        );

        OptionPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        ChooserLabel.setText("Pick The Data to Graph");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        ChooseIntervelLabel.setText("Pick a Data interval");

        DailyRadioButton.setText("Daily");
        DailyRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DailyRadioButtonActionPerformed(evt);
            }
        });

        WeeklyRadioButton.setText("Weekly");

        MonthlyRadioButton.setText("Monthly");

        YearlyRadioButton.setText("Yearly");

        AllRadioButton.setText("All");

        PreviousButton.setText("Previous Data Set");

        NextButton.setText("Next Data Set");
        NextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextButtonActionPerformed(evt);
            }
        });

        SnapCheckBox.setText("Snap to begining of data interval");

        javax.swing.GroupLayout OptionPanelLayout = new javax.swing.GroupLayout(OptionPanel);
        OptionPanel.setLayout(OptionPanelLayout);
        OptionPanelLayout.setHorizontalGroup(
            OptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OptionPanelLayout.createSequentialGroup()
                .addGroup(OptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(OptionPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(OptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(OptionPanelLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(ChooserLabel)
                            .addComponent(ChooseIntervelLabel)
                            .addGroup(OptionPanelLayout.createSequentialGroup()
                                .addComponent(DailyRadioButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(WeeklyRadioButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(MonthlyRadioButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(YearlyRadioButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(AllRadioButton))
                            .addComponent(SnapCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(OptionPanelLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(PreviousButton, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(NextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        OptionPanelLayout.setVerticalGroup(
            OptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OptionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ChooserLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ChooseIntervelLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(OptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DailyRadioButton)
                    .addComponent(WeeklyRadioButton)
                    .addComponent(MonthlyRadioButton)
                    .addComponent(YearlyRadioButton)
                    .addComponent(AllRadioButton))
                .addGap(18, 18, 18)
                .addComponent(SnapCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(OptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PreviousButton)
                    .addComponent(NextButton))
                .addGap(33, 33, 33))
        );

        InstrumentPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout TempThermoPanelLayout = new javax.swing.GroupLayout(TempThermoPanel);
        TempThermoPanel.setLayout(TempThermoPanelLayout);
        TempThermoPanelLayout.setHorizontalGroup(
            TempThermoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 235, Short.MAX_VALUE)
        );
        TempThermoPanelLayout.setVerticalGroup(
            TempThermoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 355, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout InstrumentPanelLayout = new javax.swing.GroupLayout(InstrumentPanel);
        InstrumentPanel.setLayout(InstrumentPanelLayout);
        InstrumentPanelLayout.setHorizontalGroup(
            InstrumentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InstrumentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TempThermoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        InstrumentPanelLayout.setVerticalGroup(
            InstrumentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InstrumentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TempThermoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        FileMenu.setText("File");
        FileMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FileMenuActionPerformed(evt);
            }
        });

        OpenMenuItem.setText("Open");
        OpenMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenMenuItemActionPerformed(evt);
            }
        });
        FileMenu.add(OpenMenuItem);

        QuitMenuItem.setText("Quit");
        FileMenu.add(QuitMenuItem);

        WeatherMenuBar.add(FileMenu);

        StatMenu.setText("Statistics");

        MeanTempMenuItem.setText("Mean Temperature");
        StatMenu.add(MeanTempMenuItem);

        HighTempMenuItem.setText("High Temperature");
        StatMenu.add(HighTempMenuItem);

        LowTempMenuItem.setText("Low Temperature");
        StatMenu.add(LowTempMenuItem);

        MeanWindMenuItem.setText("Mean Wind Speed");
        StatMenu.add(MeanWindMenuItem);

        MaxWindMenuItem.setText("Max Wind Speed");
        StatMenu.add(MaxWindMenuItem);

        PrevWindMenuItem.setText("Prevailing Wind Direction");
        StatMenu.add(PrevWindMenuItem);

        RainfallMenuItem.setText("Rainfall");
        StatMenu.add(RainfallMenuItem);

        WeatherMenuBar.add(StatMenu);

        setJMenuBar(WeatherMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(InstrumentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ChartPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(OptionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(OptionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ChartPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(InstrumentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                        
    
    
    private void OpenMenuItemActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:     
        TimeSeries timeSeries = new TimeSeries("Data");
        weatherList ww = new weatherList();
        
        int returnVal = fc.showOpenDialog(this);
        if ( returnVal == JFileChooser.APPROVE_OPTION )
        {
            
            File[] file = fc.getSelectedFiles();
            //This is where a real application would open the file.
         
            XmlReader filereader = new XmlReader();
            
            for (int i = 0; i < file.length; i++)
                filereader.ReadFile(file[i].getAbsoluteFile().toString(), ww);
            ww.sortList();
            for (int i = 0; i < ww.weatherData.size(); i++)
            {
                //  System.out.println(ww.weatherData.get(i).getDateTime());
                timeSeries.addOrUpdate(new Day(ww.weatherData.get(i).getDateTime()), ww.weatherData.get(i).getTemperature());
            }
            TempSet.addSeries(timeSeries);
        }
        else
        {
            System.out.println( "Open command cancelled by user.\n" );
        }
    }                                            

    private void FileMenuActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    private void DailyRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        // TODO add your handling code here:
    }                                                

    private void NextButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(WeatherFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WeatherFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WeatherFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WeatherFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WeatherFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JRadioButton AllRadioButton;
    private javax.swing.JPanel ChartPanel;
    private javax.swing.JLabel ChooseIntervelLabel;
    private javax.swing.JLabel ChooserLabel;
    private javax.swing.JRadioButton DailyRadioButton;
    private javax.swing.JMenu FileMenu;
    private javax.swing.JMenuItem HighTempMenuItem;
    private javax.swing.JPanel InstrumentPanel;
    private javax.swing.JMenuItem LowTempMenuItem;
    private javax.swing.JMenuItem MaxWindMenuItem;
    private javax.swing.JMenuItem MeanTempMenuItem;
    private javax.swing.JMenuItem MeanWindMenuItem;
    private javax.swing.JRadioButton MonthlyRadioButton;
    private javax.swing.JButton NextButton;
    private javax.swing.JMenuItem OpenMenuItem;
    private javax.swing.JPanel OptionPanel;
    private javax.swing.JMenuItem PrevWindMenuItem;
    private javax.swing.JButton PreviousButton;
    private javax.swing.JMenuItem QuitMenuItem;
    private javax.swing.JMenuItem RainfallMenuItem;
    private javax.swing.JCheckBox SnapCheckBox;
    private javax.swing.JMenu StatMenu;
    private javax.swing.JPanel TempThermoPanel;
    private javax.swing.JMenuBar WeatherMenuBar;
    private javax.swing.JRadioButton WeeklyRadioButton;
    private javax.swing.JRadioButton YearlyRadioButton;
    private javax.swing.JComboBox<String> jComboBox1;
    // End of variables declaration                   
}