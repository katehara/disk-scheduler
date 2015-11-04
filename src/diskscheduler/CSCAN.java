package diskscheduler;

import org.jfree.ui.RefineryUtilities;

public class CSCAN {
    int cnt , output[];
    LineChart_AWT chart;
        CSCAN(int[] b,int m,int start){
            int i,h=0,pos,x=0,flag;
            int loc=0;
            int n = b.length;
            output=new int[n+3];
            output[0]=start;
            
            x=start;
            cnt=0;
            pos=0;
            flag=0;
            //Sorting in increasing order
            for(i=0;i<n;i++){
                for(int j=0;j<n-i-1;j++){
                    if(b[j]>b[j+1]){
                        x=b[j];
                        b[j]=b[j+1];
                        b[j+1]=x;
                    }
                }
            }
//            for(i=0;i<n;i++)
//                System.out.println(b[i]);
            for(i=0; i<n; i++){
                if(b[i]<start){
                pos++;
                
                
                }
            }
            
            System.out.println(pos);
            if(Math.abs(start-b[pos-1])< Math.abs(start-b[pos]))
                flag=0;
            else
                flag=1;
            x=start;
            h=0;
        if(flag==0){
            loc=1;
            //System.out.println("flag0");
            for(i=pos-1;i>=0;i--){
                cnt+=Math.abs(x-b[i]);
                x=b[i];
                output[loc++]=x;
               
                
            }
             
            cnt+=Math.abs(x-0);
            output[loc]=0;
            output[loc++]=m-1;
            x=m;
            for(i=n-1;i>=pos; i--){
                cnt+=Math.abs(x-b[i]);
                x=b[i];
                output[loc++]=x;

            } 


        }
        if(flag==1){
            loc=1;
            //System.out.println("flag1");
            for(i=pos;i<n;i++){
                cnt+=Math.abs(x-b[i]);
                x=b[i];
                output[loc++]=x;
                System.out.println(x);
                //loc=i;
            }
            //System.out.println("x"+x);
            cnt+=Math.abs(x-m);
            output[loc++]=m-1;
            output[loc++]=0;
            x=0;
            for(i=0;i<pos; i++){ 
                cnt+=Math.abs(x-b[i]);
                x=b[i];
                output[loc++]=x;
                
            } 
            
        }
        gr(m,output);
        

	
    }
         void gr(int cyl, int output[])
    {
         chart = new LineChart_AWT(
      "CSCAN" ,
      "Cylinder Vs Execution",cyl,output);
      //chart.no_cylinder(cyl,output);
      chart.pack( );
      RefineryUtilities.centerFrameOnScreen( chart );
      chart.setVisible( false );
    }
}
	
