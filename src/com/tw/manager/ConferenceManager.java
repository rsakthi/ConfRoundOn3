package com.tw.manager;

/****************************************************************************************************
 *																		  							*
 * Copyright Information         																	*
 *          								 														*
 * This Application is prepared for Thoughtworks Inc. as part of its Interview Process				*
 * No aspect of this Application may be reproduced or disclosed without Thoughtworks' Authorization	*
 *																									*
 * All Rights Reserved.													   							*
 * 																									*
 ****************************************************************************************************/

/**
 * Class Description : This manager class is responsible for all the Conference Management Logic.
 * 
 * @Source File : ConferenceManager.java
 * Author Name  : Sakthi Ramasamy 
 * Created On 	: 04-Jan-2014
 * Version 		: 1 
 * Modification History : 
 * Modified by :
 *  
 */

import java.util.List;
import java.util.logging.Logger;

import com.tw.constants.IConstants;
import com.tw.entity.Session;
import com.tw.entity.Talk;
import com.tw.entity.Track;

/**
 * This class is the business layer where the exact business logic for each and
 * every method.
 *  
 */

public class ConferenceManager{	
	
	private static final Logger conflogger = Logger.getLogger((ConferenceManager.class).getName());
	

	/**
	 * This method calculates the total number of talk hours from the registered list of talks
	 * 
	 * @return double
	 */
	public double getTotalTalkHours(List<Talk> paramtalkslist){
		
		double totaltalkhours = 0;
				
		for(Talk talks : paramtalkslist){
			totaltalkhours += talks.getDuration();
		}
		
		return totaltalkhours;
		
	}
	
	/**
	 * This method calculates the total number of tracks required for the conference.
	 * 
	 * @return double
	 */

	public int calculateTotalTracksRequired(double paramtotaltalkhours){
		
		int totaltrackrequired = 0;
		
		totaltrackrequired = (int) Math.ceil(paramtotaltalkhours/IConstants.MAX_TRACK_TALK_DURATION);
		
		return totaltrackrequired;
		
	}
	
	/**
	 * This method will reset the Tracks
	 * 
	 * @return List<Talk>
	 */
	public List<Talk> resetSchedule(List<Talk> paramtalklist){
		
		List<Talk> instalklist = paramtalklist;
		
		for(Talk talk: instalklist){
			talk.getSchedule().setStarttime("");
			talk.getSchedule().setEndtime("");
			talk.getSchedule().setSession(Session.EMPTY);		
		}
		
		return instalklist; 
	}
	
	/**
	 * This method will schedule the Tracks based on the natural order (i.e. First Come First Serve basis)
	 * 
	 * @return List<Talk>
	 */
	
	public List<Track> scheduleTracks(List<Talk> paramtalklist, String criteria){
		
		ConferenceManager confmgr = new ConferenceManager();
		int hours = (int) confmgr.getTotalTalkHours(paramtalklist);
		int tracks = confmgr.calculateTotalTracksRequired(hours);
		int finaltrackhours = hours - ((tracks-1)*360);
		System.out.println("Final Track Hours - "+finaltrackhours);
		return null;
	}
}
