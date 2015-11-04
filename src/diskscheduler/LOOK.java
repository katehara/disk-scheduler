package diskscheduler;

import org.jfree.ui.RefineryUtilities;

public class LOOK {
    int cnt , output[];
    LineChart_AWT chart;
    LOOK(int[] b , int m, int start){
	int i , x =0 , pos =0  ;
        int n = b.length;
	output=new int[n+1];
	output[0]=start;
        x=start;
        cnt=0;
        pos=0;
        for(i=0;i<n;i++){
           for(int j=0;j<n-i-1;j++){
               if(b[j]>b[j+1]){
                   x=b[j];
                   b[j]=b[j+1];
                   b[j+1]=x;
               }
           }
        }
        for(i=0;i<n;i++){
           if(b[i]<start)
               pos++;
        }
	 
        if((Math.abs(start-b[0])) < (Math.abs(start-b[n-1])) ){
            for(i=0;i<pos;i++){
                for(int j=0;j<pos-i-1;j++){
                    if(b[j]<b[j+1]){
                        x=b[j];
                        b[j]=b[j+1];
                        b[j+1]=x;
                    }
                }
            }
            x=start;
            for(i=0;i<pos;i++){
                cnt+=Math.abs(b[i]-x);
                x=b[i];
                output[i+1]=x;
            }

            for(i=pos;i<n;i++){
                cnt+=Math.abs(b[i]-x);
                x=b[i];
                output[i+1]=x;
            }

        }

        else
        { 
            x=start;
            for(i=pos; i<n; i++){
                cnt+=Math.abs(b[i]-x);
                x=b[i];
                output[i+1]=x;
            } 
             
            int j=1;
            for(i=pos-1; i>=0; i--){
               cnt+=Math.abs(b[i]-x);
               x=b[i];
               output[j]=x;
               j++;
            } 
	 
	}
        gr(m,output);
    }
       void gr(int cyl, int output[])
    {
        chart = new LineChart_AWT(
      "LOOK" ,
      "Cylinder Vs Execution",cyl,output);
      //chart.no_cylinder(cyl,output);
      chart.pack( );
      RefineryUtilities.centerFrameOnScreen( chart );
      chart.setVisible( false );
    }
}
