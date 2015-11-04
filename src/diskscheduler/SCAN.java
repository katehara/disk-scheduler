package diskscheduler;

import org.jfree.ui.RefineryUtilities;

public class SCAN {
    int cnt, output[];
    LineChart_AWT chart;
    SCAN(int [] b,int m,int start){
	int i,loc=0,x=0,pos=0;
        int n = b.length;
	output= new int[n+3];
	output[0]=start;
        x= start;
        cnt=0;
        pos=0;
        for(i=0;i< n;i++){
            for(int j=0;j< n-i-1;j++){
                if(b[j]>b[j+1]){
                x=b[j];
                b[j]=b[j+1];
                b[j+1]= x;
                }
            }
        }
        for(i=0;i< n;i++){
            if(b[i]< start)
                    pos++;
        }
	
        if( start <m/2){
            for(i=0;i< pos;i++){
                for(int j=0;j< pos-i-1;j++){
                    if(b[j]<b[j+1]){
                    x=b[j];
                    b[j]=b[j+1];
                    b[j+1]= x;
                    }
                }
            }
        x= start;
        for(i=0;i< pos;i++){
            cnt+= Math.abs(b[i]- x);
            x=b[i];
            output[i+1]=x;
            loc=i+1;
        }
        cnt+= Math.abs( x-0);
        x=0;
        output[loc]=x;
        for(i= pos;i< n;i++){
            cnt+= Math.abs(b[i]- x);
            x=b[i];
            output[i+1]=x;
        }

    } 
        else {
        x= start;
       int k=1;
	 
        for(i= pos; i< n; i++){
                cnt+= Math.abs(b[i]-x);
                x=b[i];
                output[k++]=x;
                
            } 
        cnt+= Math.abs( x-m-1);
        x =m-1;
        output[k++]=m-1;
        for(i= pos-1; i>=0; i--)
        {
            cnt+= Math.abs(b[i]-x);
            x=b[i];
            output[k++]=x;
        } 
    } 
        gr(m,output);
}
       void gr(int cyl, int output[])
    {
        int i;
        
         chart = new LineChart_AWT(
      "SCAN" ,
      "Cylinder Vs Execution",cyl,output);
      //chart.no_cylinder(cyl,output);
      chart.pack( );
      RefineryUtilities.centerFrameOnScreen( chart );
      chart.setVisible( false );
    }
}
