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
 * Class Description : This manager class is responsible for all the Scheduling Logic.
 * 
 * @Source File : SchedulingManager.java
 * Author Name  : Sakthi Ramasamy 
 * Created On 	: 04-Jan-2014
 * Version 		: 1 
 * Modification History : 
 * Modified by :
 *  
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

import com.tw.constants.IConstants;
import com.tw.entity.Schedule;
import com.tw.entity.Session;
import com.tw.entity.Talk;
import com.tw.entity.Track;
import com.tw.utils.ConferenceUtils;
import com.tw.utils.TalkDurationSorter;


public class SchedulingManager {
		
		//Logger Implementation
		//public static final Logger logger = Logger.getLogger("SchedulingManager.class");
	
		//Morning sessions begin at 9am and must finish by 12 noon - 3 hours / 180 mins
		//Afternoon sessions begin at 1pm and must finish in time for the networking event. - 3 hours / 180 mins
		//The networking event can start no earlier than 4:00 and no later than 5:00.
		
		ConferenceManager cm = new ConferenceManager();		
				
				
		/**
		 * This method retrieves and returns the talks with specific duration
		 * 
		 * @return List<Talk>
		 */
		public List<Track> getListOfTalksForTracks(List<Talk> originaltalklist){			
			double totaltrackhours = cm.getTotalTalkHours(originaltalklist);
			int totaltracksrequired = cm.calculateTotalTracksRequired(totaltrackhours);
			int trackscounter = totaltracksrequired;
			List<Track> tracklist  =  new ArrayList<Track>();
			do{
				for(int j = 0; j < totaltracksrequired; j++){ 
					List<Talk> tracktalklist = new ArrayList<Talk>();
					//List<Talk> eventracktalklist = new ArrayList<Talk>();
					//switch between morning and afternoon sessions by a variable
					int mornduration = 180;
					int evenduration = 240;
					
					for(int i = 0; i < originaltalklist.size(); i++){										
						if((originaltalklist.get(i).getDuration() == mornduration) && (originaltalklist.get(i).isScheduled() == false)){						
							originaltalklist.get(i).setScheduled(true);
							mornduration = mornduration - originaltalklist.get(i).getDuration();
							tracktalklist.add((Talk) originaltalklist.get(i));	
							tracktalklist.add(SchedulingManager.getLunchEvent()); //Add the Lunch Event
						}else if( (originaltalklist.get(i).getDuration() < mornduration )&& (originaltalklist.get(i).isScheduled() == false)){						
							originaltalklist.get(i).setScheduled(true);
							mornduration = mornduration - originaltalklist.get(i).getDuration();
							tracktalklist.add((Talk) originaltalklist.get(i));					
						}	
					}
					
					for(int k = 0; k < originaltalklist.size(); k++){										
						if((originaltalklist.get(k).getDuration() == evenduration) && (originaltalklist.get(k).isScheduled() == false)){						
							originaltalklist.get(k).setScheduled(true);
							evenduration = evenduration - originaltalklist.get(k).getDuration();
							tracktalklist.add((Talk) originaltalklist.get(k));								
						}else if( (originaltalklist.get(k).getDuration() < evenduration )&& (originaltalklist.get(k).isScheduled() == false)){						
							originaltalklist.get(k).setScheduled(true);
							evenduration = evenduration - originaltalklist.get(k).getDuration();
							tracktalklist.add((Talk) originaltalklist.get(k));					
						}	
					}
					if(tracktalklist.size() > 0){	
						tracktalklist.add(SchedulingManager.getNetworkingEvent()); //Add the Networking Event
						tracklist.add(new Track(tracktalklist));						
						TalkDurationSorter sorter = new TalkDurationSorter();
						Collections.sort(originaltalklist, sorter);
						Collections.reverse(originaltalklist);
					}
					trackscounter--;				
				}
			}while(trackscounter >= 0);	
			
			SchedulingManager.scheduleTracks(tracklist);
			return tracklist;					
		}		
		
		
		
		/**
		 * This method schedules the time slot for the ordered list of talks
		 * 
		 * @return List<Talk>
		 */
		public static List<Track> scheduleTracks(List<Track> trackslist){
			
			
			for(int i = 0; i < trackslist.size(); i++){
				
				double starttime = 9*60;
				double endtime = 0;	
				for(int j = 0; j < trackslist.get(i).getTalks().size(); j++){
					if(!((trackslist.get(i).getTalks().get(j).getTalkname().trim()).equals(IConstants.NETWORKINGEVENT.trim()) || (trackslist.get(i).getTalks().get(j).getTalkname()).equals(IConstants.LUNCHBREAK.trim()))){
						if((endtime == IConstants.MORNING_START_TIME)||(endtime == IConstants.LUNCH_BREAK_START)){
							starttime = starttime + 60;						
						}
						trackslist.get(i).getTalks().get(j).getSchedule().setStarttime(ConferenceUtils.getTime(starttime));
						endtime = starttime + trackslist.get(i).getTalks().get(j).getDuration();
						trackslist.get(i).getTalks().get(j).getSchedule().setEndtime(ConferenceUtils.getTime(endtime));
						starttime = endtime;
					}
				}				
			}			
			SchedulingManager.printTrackList(trackslist);
			return null;
		}
		
		/***************************************************************************************************************************************************************************************
		 * *******************************************************					UTILITY METHODS					*******************************************************
		 * *************************************************************************************************************************************************************************************/
		
		/**
		 * This method retrieves and returns the Lunch event
		 * 
		 * @return List<Talk>
		 */
		 public static Talk getLunchEvent(){
			Talk lunch = new Talk(IConstants.LUNCHBREAK, 60);
			Schedule schedule = new Schedule();
			schedule.setStarttime(ConferenceUtils.getTime(IConstants.LUNCH_BREAK_START));
			schedule.setEndtime(ConferenceUtils.getTime(IConstants.LUNCH_BREAK_END));
			lunch.setSchedule(schedule);
			lunch.setScheduled(true);
			return lunch;
		 }
		 
		 /**
		 * This method retrieves and returns the Lunch event
		 * 
		 * @return List<Talk>
		 */
		 public static Talk getNetworkingEvent(){			
			 Talk networking = new Talk(IConstants.NETWORKINGEVENT, 0);
			 Schedule schedule = new Schedule();
			 schedule.setStarttime(ConferenceUtils.getTime(IConstants.NETWORKING_EVENT_START));	
			 schedule.setEndtime(ConferenceUtils.getTime(IConstants.NETWORKING_EVENT_END));	
			 networking.setSchedule(schedule);
			 networking.setScheduled(true);
			 return networking;
		 }
			
		/**
		 * This method prints the schedule.
		 * @param tracklist
		 */
		public static void printTrackList(List<Track> tracklist){
		for(int m = 0 ; m < tracklist.size(); m++){
			System.out.println("**********************************" + tracklist.get(m).getTrackname() +"**********************************");
			for(int n = 0; n < (tracklist.get(m)).getTalks().size(); n++){	
					System.out.println((tracklist.get(m)).getTalks().get(n).getSchedule().getStarttime() +" - " + (tracklist.get(m)).getTalks().get(n).getSchedule().getEndtime() +" - "+(tracklist.get(m)).getTalks().get(n).getTalkname() +" - "+(tracklist.get(m)).getTalks().get(n).getDuration() );
				}
		  }
		}
		
}
