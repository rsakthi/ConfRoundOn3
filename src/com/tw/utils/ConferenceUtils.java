package com.tw.utils;

import com.tw.entity.Session;

public class ConferenceUtils {
	
	
	
	public static String getTime(double parammins){		
		
		int hour = 0;
		double mins = 0;
		Session session = null;
		
		if(parammins < 720 && parammins >= 540){				
			session = session.AM;				
		}else if(parammins >= 720 ){
			 session = session.PM;
			 if(parammins > 720){
				 parammins = parammins - 720;
			 }		
		}
		
		hour = (int) Math.floor(parammins / 60);
		mins = parammins % 60;
		
		return ( String.format("%02d", hour) + " : " + String.format("%02d" , Double.valueOf(mins).intValue()) + " " + session);
	}
	
	

}
