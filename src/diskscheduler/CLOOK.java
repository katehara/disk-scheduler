package diskscheduler;

import org.jfree.ui.RefineryUtilities;

public class CLOOK{
    int cnt , output[];
    LineChart_AWT chart;
    float cnt2;
    CLOOK(int[] b , int m , int start){
        int i , j , x =0, pos =0, flag =0;
        int n = b.length;
        output=new int [n+1];
        output[0]=start;
        x = start;
        for(i=0;i<n;i++){
           for(j=0;j<n-i-1;j++){
               if(b[j]>b[j+1]){
                   x=b[j];
                   b[j]=b[j+1];
                   b[j+1]=x;
               }
           }
        }
        for(i=0; i<n; i++){
            if(b[i]<start)
                pos++;
        }

        if(Math.abs(start-b[pos-1]) < Math.abs(start-b[pos]) )
           flag=0;//go left
        else
           flag=1;// go right

        x=start;

        if(flag==0){

            int s=1;
            for(i=pos-1;i>=0;i--){
                cnt+=Math.abs(x-b[i]);
                x=b[i];
                output[s]=x;
                s++;
                //ystem.out.println("output is:"+ output[s]);
            }

            for(i=n-1;i>=pos; i--)
            { 
                if(i!=(n-1)) 
                    cnt+=Math.abs(x-b[i]);
                x=b[i];
                output[s]=x;
                  System.out.println("output is:"+ output[s]);
                s++;
            } 
            if(pos!=0 && pos!=(n) ) 
            {

                cnt2=cnt;
            }
            
            else
            {
                cnt2 = (float)cnt;
            } 
        }

            if(flag==1){
            
                int y=1;
                for(i=pos;i<n;i++)
                {
                    cnt+=Math.abs(x-b[i]);
                    x=b[i];
                    output[y]=x;
                    y++;

                }
                // System.out.println("%d\t%d\t",m-1,0); 
                // x=0;
                for(i=0;i<pos; i++)
                { 
                    if(i!=0)
                        cnt+=Math.abs(x-b[i]);
                    x=b[i];
                    output[y]=x;
                    y++;
                } 
                if(pos!=0 && pos!=(n) ) 
                {

                    cnt2 = cnt;
                    
                }

                //System.out.println("\nTotal Head Movement: "+count11+(alpha1/beta )+" Cylinders\n\n");}
                else
                {
                    cnt2 = (float)cnt;
                    // System.out.println("\nTotal Head Movement: "+(float)cnt+" Cylinders\n\n");
                }
            } 
     
        gr(m,output);
    }
        
       void gr(int cyl, int output[])
    {
          chart = new LineChart_AWT(
      "CLOOK" ,
      "Cylinder Vs Execution",cyl,output);
      //chart.no_cylinder(cyl,output);
      chart.pack( );
      RefineryUtilities.centerFrameOnScreen( chart );
      chart.setVisible( false );
    }
    
}

