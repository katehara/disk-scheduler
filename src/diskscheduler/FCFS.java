
package diskscheduler;

import org.jfree.ui.RefineryUtilities;

public class FCFS {
    int[] output; 
    int cnt;
    LineChart_AWT chart;

    FCFS(int[] b , int m, int start){
        int i , x=start;
        int n = b.length;
        output=new int [n+1];
        output[0]=start;
        cnt = 0;
        for(i=0;i<b.length;i++){

           x-=b[i];
           if(x<0)
               x=-x;
           cnt+=x;
           x=b[i];
           output[i+1]=x;
        
        }
    gr(m,output);
        
    }
    void gr(int cyl, int output[])
    {
        chart = new LineChart_AWT(
      "FCFS" ,
      "Cylinder Vs Execution",cyl,output);
      chart.pack( );
      RefineryUtilities.centerFrameOnScreen( chart );
      chart.setVisible( false );
    }

   
}
