package com.tw.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.tw.constants.IConstants;
import com.tw.entity.Schedule;
import com.tw.entity.Talk;
import com.tw.manager.ConferenceManager;
import com.tw.manager.SchedulingManager;
import com.tw.utils.TalkDurationSorter;

public class ConferenceManagerTest {
	
	public static List<Talk> getListOfTalks(){
		List<Talk> talks = new ArrayList<Talk>();
			talks.add(new Talk("Writing Fast Tests Against Enterprise Rails", 60));
			talks.add(new Talk("Overdoing it in Python", 45));
			talks.add(new Talk("Lua for the Masses", 30));
			talks.add(new Talk("Ruby Errors from Mismatched Gem Versions", 45));
			talks.add(new Talk("Common Ruby Errors", 45));
			talks.add(new Talk("Rails for Python Developers", IConstants.LIGHTNING));
			talks.add(new Talk("Communicating Over Distance", 60));
			talks.add(new Talk("Accounting-Driven Development", 45));
			talks.add(new Talk("Woah", 30));
			talks.add(new Talk("Sit Down and Write", 30));
			talks.add(new Talk("Pair Programming vs Noise", 45));
			talks.add(new Talk("Rails Magic", 60));
			talks.add(new Talk("Ruby on Rails: Why We Should Move On", 60));
			talks.add(new Talk("Clojure Ate Scala (on my project)", 45));
			talks.add(new Talk("Programming in the Boondocks of Seattle", 30));
			talks.add(new Talk("Ruby vs. Clojure for Back-End Development", 30));
			talks.add(new Talk("Ruby on Rails Legacy App Maintenance", 60));
			talks.add(new Talk("A World Without HackerNews", 30));
			talks.add(new Talk("User Interface CSS in Rails Apps", 30));
		return talks;
	}
	
	public static void main(String[] args){		
		ConferenceManager insconfmgr = new ConferenceManager();	
		insconfmgr.getConferenceSchedule();				
	}

}
