package com.tw.entity;

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
 * Class Description : This Entity class will represent the Track Information.
 * 
 * @Source File : Track.java
 * Author Name  : Sakthi Ramasamy 
 * Created On 	: 04-Jan-2014
 * Version 		: 1 
 * Modification History : 
 * Modified by :
 *  
 */


import java.util.List;

/**
 * This class holds the talks and its schedules.
 *  
 */
public class Track {
	
	/**
	 * The tracknumber attribute is used to store the tracknumber for the Talks.
	 */
	private static int tracknumber = 0;	
	
	/**
	 * The trackname attribute is used to store the trackname for the Talks.
	 */
	String trackname;
	
	/**
	 * The talks attribute is used to store the list of the Talks for any track.
	 */
	List<Talk> talks;
	
		

	public Track(List<Talk> talks) {
		tracknumber++;
		this.trackname = "Track " + tracknumber;
		this.talks = talks;
	}

	/**
	 * @return the trackname
	 */
	public String getTrackname() {
		return trackname;
	}

	/**
	 * @param trackname
	 *            The trackname to set.
	 */
	public void setTrackname(String trackname) {
		this.trackname = trackname;
	}

	/**
	 * @return the talks
	 */
	public List<Talk> getTalks() {
		return talks;
	}

	/**
	 * @param talks
	 *            The talks to set.
	 */
	public void setTalks(List<Talk> talks) {
		this.talks = talks;
	}
	
	/**
	 * @return resets the tracknumber.
	 */
	public void resetTrackNumber(){
		tracknumber = 0;
	}

	/**
	 * @return the tracknumber
	 */
	public static int getTracknumber() {
		return tracknumber;
	}

}
