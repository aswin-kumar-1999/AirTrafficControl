package traffic_GUI;

import java.util.ArrayList;


public class runway {
	ArrayList<Integer> r=new ArrayList<Integer>();
	ArrayList<Integer> rn_time=new ArrayList<Integer>();
	ArrayList<String> plane=new ArrayList<String>();
	ArrayList<Float> weight=new ArrayList<Float>();
	ArrayList<String> planeRun=new ArrayList<String>();
	boolean isFree=true;
	
	runway(int rw,int rn){
		r.add(rw);
		rn_time.add(rn);
	}
	
	

	void assign(String plane,float ton,ArrayList<Integer> r2) {
		this.plane.add(plane);
		weight.add(ton);
		planeRun.add(String.valueOf(r2));
	}
}
