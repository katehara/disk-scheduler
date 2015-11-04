package diskscheduler;





public class DiskScheduling {

        int n , start , m ,beta =25;
        FCFS res1;// = new FCFS(a, cyl, head);
	SSTF res2;// = new SSTF(a, cyl, head);
	SCAN res3;// = new SCAN(a, cyl, head);
	CSCAN res4;// = new CSCAN(a, cyl, head); 
	LOOK res5;// = new LOOK(a, cyl, head);
	CLOOK res6; ///take cnt2 
	float min;
        int mina;
        
        DiskScheduling(int[] a, int cyl , int head){  
	 
            n = cyl;
            start = head;
            res1 = new FCFS(a, cyl, head);
            res2 = new SSTF(a, cyl, head);
            res3 = new SCAN(a, cyl, head);
            res4 = new CSCAN(a, cyl, head); 
            res5 = new LOOK(a, cyl, head);
            res6 = new CLOOK(a, cyl, head);
	 } 
	
    }