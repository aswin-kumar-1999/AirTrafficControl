package traffic_GUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;
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
	JFrame f=new JFrame("AIR TRAFFIC CONTROL");
	runway rn;
	JLabel l1,l2;
	JRadioButton r1,r2,r3,r4,r5,r6;
	JTextField t1,t2,t3,t4,t5,t6;
	static ArrayList<runway> run=new ArrayList<runway>();
	static int ton;
	static float time;
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
		 
		
	    f.setSize(700,700);
		l1=new JLabel();
		l2=new JLabel();
		r1=new JRadioButton();
		r2=new JRadioButton();
		r3=new JRadioButton();
		r4=new JRadioButton();
		r5=new JRadioButton();
		r6=new JRadioButton();
		t1=new JTextField(); 
		t2=new JTextField(); 
		t3=new JTextField(); 
		t4=new JTextField(); 
		t5=new JTextField(); 
		t6=new JTextField(); 
		l1.setBounds(10, 10, 100, 30);
		r1.setBounds(10, 40, 100, 30);
		r2.setBounds(10, 70, 100, 30);
		r3.setBounds(10, 100, 100, 30);
		r4.setBounds(10, 130, 100, 30);
		l2.setBounds(10, 170, 50, 30);
		r5.setBounds(10, 200, 200, 30);
		r6.setBounds(10, 230, 200, 30);
		JButton b1=new JButton("allot");
		b1.setBounds(10, 280, 150, 30);
		JButton b2=new JButton("Runway status");
		b2.setBounds(170, 280, 200, 30);
		t1.setBounds(60, 170, 70, 30);
		t2.setBounds(10, 400, 400, 30);
		t3.setBounds(250, 10, 200, 30);
		t4.setBounds(250, 40, 200, 30);
		t5.setBounds(250, 70, 200, 30);
		t6.setBounds(250, 100, 200, 30);
		t2.setEditable(false);
		t3.setEditable(false);
		t4.setEditable(false);
		t5.setEditable(false);
		t6.setEditable(false);
		l1.setText("AIR CRAFT TYPE");
		r1.setText("ATR");   
		r2.setText("AirBus");    
		r3.setText("Boeing");    
	    r4.setText("Cargo");
	    ButtonGroup g1=new ButtonGroup();    
		g1.add(r1);g1.add(r2); g1.add(r3);g1.add(r4);
		l2.setText("Weight");
		r5.setText("Landing");    
		r6.setText("TakeOff");
		ButtonGroup g2=new ButtonGroup();    
		g2.add(r5);g2.add(r6); 
		JTextArea ar=new JTextArea("Type      max weight(ton)        time to halt/take off \n"
				+ "ATR          12                         30 sec\r\n"
				+ "AirBus       20                         40 sec\r\n"
				+ "Boeing      40                          50 sec\r\n"
				+ "Cargo       100                         60 sec");
		ar.setBounds(400, 550, 300 ,100 );
		b1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	 String s=t1.getText();
        	 System.out.println("ton: "+s);
        	 ton=Integer.parseInt(s);
        	 if(r1.isSelected()) {
					plane="ATR";
					time=(float)(ton/12)*30;
				}
				else if(r2.isSelected()) {
					plane="AirBus";
					time=(float)(ton/20)*40;
				}
				else if(r3.isSelected()) {
					plane="Boeing";
					time=(float)(ton/40)*50;
				}
				else if(r4.isSelected()) {
					plane="Cargo";
					time=(float)(ton/100)*60;
				}
				
				if(r5.isSelected()) {
					pro="Landing";
				}
				else {
					pro="TakeOff";
				}
				System.out.println("plane:"+plane+"time:"+time+"weight:"+ton);
        	 allot();
        	
        	 t2.setText(plane+" is about to "+pro+" in runway number "+rn.r+" time:"+time );
        	}
		});
		
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(run.get(0).isFree) {
		   			 t3.setText("RunWay 1 is Available");
		   			 
		   		 }
		   		 else {
		   			 t3.setText("RunWay 1 is Not Available");
		   			
		   		 }
		   		 if(run.get(1).isFree) {
		   			 t4.setText("RunWay 2 is Available");
		   			
		   		 }
		   		 else {
		   			 t4.setText("RunWay 2 is Not Available");
		   			
		   		 }
		   		 if(run.get(2).isFree) {
		   			 t5.setText("RunWay 3 is Available");
		   			 
		   		 }
		   		 else {
		   			 t5.setText("RunWay 3 is Not Available");
		   			 }
		   		 if(run.get(3).isFree) {
		   			 t6.setText("RunWay 4 is available");
		   			
		   		 }
		   		 else {
		   			 t6.setText("RunWay 4 is Not Available");
		   			
		   		 }
			}
		});
		
		
		f.add(t1);f.add(t3);f.add(t4);f.add(t5);f.add(t6);
		f.add(b2);f.add(b1);
		f.add(l1);f.add(l2);f.add(ar);
		f.add(r1);f.add(r2);
		f.add(r3);f.add(r4);f.add(r5);f.add(r6);
		f.add(t2);
		
		f.setVisible(true);
		f.setLayout(null);		 
 }
	
	void allot() {
		
		 time+=15;
		 System.out.println(plane+" has load of "+ton+" (tons) takes "+time+" seconds to "+pro);
		
		
		int rec=0;
		
		for(runway r:run) {
			if(r.isFree==true && r.rn_time.get(0)>=time) {
						
						r.assign(plane,ton,r.r);
						rn=r;
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
