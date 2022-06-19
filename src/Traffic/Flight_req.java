package Traffic;
import java.util.*;
/*
  Flight Details(speed-200km/ph for both)

Type              max weight(ton)        time to halt/take off         
 ATR                     12                   30 sec
AirBus	                 20                   40 sec
Boeing                   40                   50 sec
 cargo                   100                  60 sec



runway-time to both
	r1-40 sec   //speed   distane=speed*time (km/sec)*sec
	r2-60 sec
	r3-80 sec
	r4-90 sec
	
	it is always advice to allot a runway to x flight which has atleast +15 sec extra
	*/


public class Flight_req extends Thread {
	static Scanner in=new Scanner(System.in);
	static ArrayList<runway> run=new ArrayList<runway>();
	static int ch;
	static float time,ton;
	String pro,plane;
	Flight_req(){
		runway r=new runway(1,40);
		run.add(r);
		runway r1=new runway(2,60);
		run.add(r1);
		runway r2=new runway(3,80);
		run.add(r2);
		runway r3=new runway(4,90);
		run.add(r3);
  }
	
	void getDetails() {
		 System.out.println("*****************************************************");
		 System.out.println("*******************  AIR CRAFT TYPE  ****************");
		 System.out.println("1.ATR \n2.AirBus \n3.Boeing \n4.Cargo \n5.Shut down");
		  ch=in.nextInt();
		 switch(ch) {
		 case 1:
			 plane="ATR";
			 break;
		 case 2:
			 plane="airBus";
			 break;
		 case 3:
			 plane="Boeign";
			 break;
		 case 4:
			 plane="Cargo";
			 break;
		 case 5:
			
			 System.out.println("************** System is shuting down ****************");
			 return;
		 }
		 System.out.println("enter the Weight(tons):");
		 ton=in.nextInt();
		 System.out.println("1.LANDING\n2.TAKE-OFF");
		 int c=in.nextInt();
		 switch(c) {
		 case 1:
			 pro="LANDING";
			 break;
		 case 2:
			 pro="TAKE-OFF";
			 break;
		 
		 }
		 allot();
		 for(runway r:run) {
				if(r.isFree==true) {
					System.out.println(r.r+" is Available");
				}
				else {
					System.out.println(r.r+" is Not Available");
				}
			}
		 getDetails();
		 
 }
	
	void allot() {
		
		
		if(ch==1) {
			
			time=ton/12*30;
			
		}
		
		 if(ch==2) {
			time=ton/20*40;
			//System.out.println(plane+" "+time+" "+ton);
		}
		 if(ch==3) {
			time=ton/40*50;
			//System.out.println(plane+" "+time+" "+ton);
		}
		 if(ch==4) {
			time=ton/100*60;
			//System.out.println(plane+" "+time+" "+ton);
		}
		 time+=15;
		 System.out.println(plane+" has load of "+ton+" (tons) takes "+time+" seconds to "+pro);
		
		
		int rec=0;
		
		for(runway r:run) {
			if(r.isFree==true && r.rn_time.get(0)>=time) {
						
						r.assign(plane,ton,r.r);
						running a=new running(r,plane,time,pro);
						a.start();
						try {
							Thread.sleep(1000);
						}
						catch(Exception e) {
							System.out.println(e);
						}
						
						return;
			
			}
			else {
				rec++;
			}
			
		}
		if(rec>=4 ) {
			System.out.println("++++++++++++++  The Runway Are Full  ++++++++++++++");
		}
		
	}
	
	
    
 public static void main(String arg[]) {
	Flight_req f=new Flight_req();
	f.getDetails();		
	}
	
}
