package com.tw.constants;

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
 * Interface Description : This interface provides a list of application specific values.
 * 
 * @Source File : IConstants.java
 * Author Name  : Sakthi Ramasamy 
 * Created On 	: 04-Jan-2014
 * Version 		: 1 
 * Modification History : 
 * Modified by :
 *  
 */


public interface IConstants {
	
	int MAX_SESSION_DURATION = 180;
	int MAX_TRACK_TALK_DURATION = MAX_SESSION_DURATION; //MAX_SESSION_DURATION * (AM + PM)
	//int LUNCH_BREAK = 60;
	int LUNCH_BREAK_START = 720;
	int MORNING_START_TIME = 60;
	int LUNCH_BREAK_END = 780;
	int NETWORKING_EVENT_START = 1020;
	int NETWORKING_EVENT_END = 1080;
	int LIGHTNING = 5;
	
	String NETWORKINGEVENT = "Networking Event";
	String LUNCHBREAK= "Lunch";
}
