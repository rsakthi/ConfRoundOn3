package com.tw.utils;

public class ConferenceUtils {
	
	
	
	public static String getTime(int parammins){
		int hour = 0;
		int mins = 0;
		if(parammins < 720 && parammins > 540){			
			hour = (int) Math.ceil(parammins / 60);
			mins = parammins % 60;
			return String.valueOf( hour + " : " + mins + " PM");
		}else if(parammins > 780 && parammins < 1019){
			parammins = parammins - 720;
			hour = (int) Math.ceil(parammins / 60);
			mins = parammins % 60;
			return String.valueOf( hour + " : " + mins + " PM");			
		}else{
			throw new IllegalArgumentException("Incorrect Time");
		}
	}

}
