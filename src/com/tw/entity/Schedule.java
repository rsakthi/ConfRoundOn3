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
 * Class Description : This Schedule class will represent the Scheduling Information.
 * 
 * @Source File : Schedule.java
 * Author Name  : Sakthi Ramasamy 
 * Created On 	: 04-Jan-2014
 * Version 		: 1 
 * Modification History : 
 * Modified by :
 *  
 */

/**
 * This class is the business layer where the exact business logic for each and
 * every method.
 *  
 */
public class Schedule {
	
	/**
	 * The talkduration attribute is used to store the duration of the talk.
	 */
	private int talkduration; //It should be in minutes
	
	/**
	 * The starttime attribute is used to store the starting time for the Talk.
	 */
	private String starttime;
	
	/**
	 * The endtime attribute is used to store the ending time of the Talk.
	 */
	private String endtime;

	/**
	 * The Session attribute is used to store whether the talk is AM / PM.
	 */
	Session session;
	
	public Schedule(int talkduration) {
		super();
		this.talkduration = talkduration;
	}
	
	/**
	 * @return Returns the talkduration.
	 */	
	public int getTalkduration() {
		return talkduration;
	}
	
	/**
	 * @param talkduration
	 *            The talkduration to set.
	 */
	public void setTalkduration(int talkduration) {
		this.talkduration = talkduration;
	}
	
	/**
	 * @return Returns the starttime.
	 */
	public String getStarttime() {
		return starttime;
	}
	
	/**
	 * @param starttime
	 *            The starttime to set.
	 */
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	
	/**
	 * @return Returns the endtime.
	 */
	public String getEndtime() {
		return endtime;
	}
	
	/**
	 * @param endtime
	 *            The endtime to set.
	 */
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	
	/**
	 * @return Returns the session.
	 */
	public Session getSession() {
		return session;
	}
	
	/**
	 * @param session
	 *            The session to set.
	 */
	public void setSession(Session session) {
		this.session = session;
	}	
	
}
