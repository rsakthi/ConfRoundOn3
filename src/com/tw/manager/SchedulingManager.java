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
		
		
		public void scheduleTracks(List<Talk> paramtalkslist){
			int totaltracks = 0;	
			totaltracks = cm.calculateTotalTracksRequired(cm.getTotalTalkHours(paramtalkslist));			
			for(int i = 0; i < totaltracks; i++){				
			}			
		}		
		
		/**
		 * This method calculates and arranges the tracks with valid talks
		 * 
		 * @return List<Talk>
		 */
		public List<Talk> getTracksInUnits(List<Talk> originaltalklist){
			SchedulingManager sm = new SchedulingManager();
			List<Track> tracklist = sm.getCriteriaBasedTalks(originaltalklist);			
			return null;
		}
		
		/**
		 * This method retrieves and returns the talks with specific duration
		 * 
		 * @return List<Talk>
		 */
		public List<Track> getCriteriaBasedTalks(List<Talk> originaltalklist){			
			double totaltrackhours = cm.getTotalTalkHours(originaltalklist);
			int totaltracksrequired = cm.calculateTotalTracksRequired(totaltrackhours);
			int trackscounter = totaltracksrequired;
			List<Track> tracklist  =  new ArrayList<Track>();
			do{
				for(int j = 0; j < totaltracksrequired; j++){ 
					List<Talk> tracktalklist = new ArrayList<Talk>();
					//switch between morning and afternoon sessions by a variable
					int talkhours = 180;
					for(int i = 0; i < originaltalklist.size(); i++){										
						if((originaltalklist.get(i).getDuration() == talkhours) && (originaltalklist.get(i).isScheduled() == false)){						
							originaltalklist.get(i).setScheduled(true);
							talkhours = talkhours - originaltalklist.get(i).getDuration();
							tracktalklist.add((Talk) originaltalklist.get(i));					
						}else if( (originaltalklist.get(i).getDuration() < talkhours )&& (originaltalklist.get(i).isScheduled() == false)){						
							originaltalklist.get(i).setScheduled(true);
							talkhours = talkhours - originaltalklist.get(i).getDuration();
							tracktalklist.add((Talk) originaltalklist.get(i));					
						}	
					}
					if(tracktalklist.size() > 0){
						tracklist.add(new Track(tracktalklist));
						TalkDurationSorter sorter = new TalkDurationSorter();
						Collections.sort(originaltalklist, sorter);
						Collections.reverse(originaltalklist);
					}
					trackscounter--;				
				}
			}while(trackscounter >= 0);	
			
			for(int m = 0 ; m < tracklist.size(); m++){
				System.out.println("**********************************" + tracklist.get(m).getTrackname() +"**********************************");
				for(int n = 0; n < (tracklist.get(m)).getTalks().size(); n++){
					System.out.println((tracklist.get(m)).getTalks().get(n).getDuration() +" - "+(tracklist.get(m)).getTalks().get(n).getTalkname());
				}
			}
			return tracklist;					
		}		
		
		/**
		 * This method retrieves and returns the lightning talks
		 * 
		 * @return List<Talk>
		 */
		public Talk getLightningTalks(List<Talk> originaltalklist){			
			for(int i = 0; i < originaltalklist.size(); i++){				
				if(!(originaltalklist.get(i).isScheduled()) && originaltalklist.get(i).getDuration() == IConstants.LIGHTNING){
					return (Talk) originaltalklist.get(i);
				}				
			}			
			return null;
		}
		
}
