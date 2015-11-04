package diskscheduler;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class LineChart_AWT extends ApplicationFrame
{
    
   public LineChart_AWT( String applicationTitle , String chartTitle , int cyl, int output[] )
   {
      super(applicationTitle);
      JFreeChart lineChart = ChartFactory.createLineChart(
         chartTitle,
         "Request","Cylinder",
         createDataset(cyl,output),
         PlotOrientation.HORIZONTAL,
         true,true,false);
         
      ChartPanel chartPanel = new ChartPanel( lineChart );
      chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
      setContentPane( chartPanel );
   }

   private DefaultCategoryDataset createDataset(int cyl,int output[] )
   {
      DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
       
      int i;
      int x=0;
      for(i=0;i<=cyl;i++)
      {
               
          if(output[x]==i || output[x]==0)
          {
          String a= Integer.toString(i);
          //System.out.println(output[x]);
          dataset.addValue( output[x] , "cylinder" , a);
          x++;
          i=0;
          if(x==output.length)
              break;
          }
      }
      
      return dataset;
   }
  
}