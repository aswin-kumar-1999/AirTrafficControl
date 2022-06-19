package traffic_GUI;

public class running extends Thread{
 runway t;
 String plane,pro;
 float time;
 running(runway r,String plane,float time,String pro){
	 t=r;
	 this.plane=plane;
	 this.time=time;
	 this.pro=pro;
 }
 public void run() {
	
	 
	 try {
		 t.isFree=false;
		 System.out.println(plane+" is ready to "+pro+" in runway "+t.r+""+time);
		 //System.out.print(time);
		 Thread.sleep((long) (time*1000));   
		 t.isFree=true;
	}
	 catch(Exception e) {
		 System.out.println(e);
	 }
 }
}
