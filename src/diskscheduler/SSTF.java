package diskscheduler;

import org.jfree.ui.RefineryUtilities;

public class SSTF
{
    int[] output;
    int cnt;
    LineChart_AWT chart;
    SSTF(int [] b,int m,int start)
    {
	int i,x=0,pos=0,flag=0,minimum=0;
        int n = b.length;
	output=new int [n+1];
	output[0]=start;
        x=start;
        cnt=0;
        for(i=0;i<n;i++){
            minimum=Math.abs(b[i]-x);
            pos=i;
            for(int j=i;j<n;j++){
                if(minimum>Math.abs(x-b[j]))
                {
                    pos=j;
                    minimum=Math.abs(x-b[j]);
                }
            }
            cnt+=Math.abs(x-b[pos]);
            x=b[pos];
            b[pos]=b[i];
            b[i]=x;
            output[i+1]=x;

        }
        gr(m,output);
    }
       void gr(int cyl, int output[])
    {
       chart = new LineChart_AWT(
      "SSTF" ,
      "Cylinder Vs Execution",cyl,output);
      //chart.no_cylinder(cyl,output);
      chart.pack( );
      RefineryUtilities.centerFrameOnScreen( chart );
      chart.setVisible( false );
    }
}
