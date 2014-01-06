package com.tw.utils;
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
 * Class Description : This manager class is responsible for all the business logic  to be present.
 * 
 * @Source File : ConferenceManager.java
 * Author Name  : Sakthi Ramasamy 
 * Created On 	: 04-Jan-2014
 * Version 		: 1 
 * Modification History : 
 * Modified by :
 *  
 */

import java.util.Comparator;

import com.tw.entity.Talk;

public class TalkDurationSorter implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		
		Talk arg1 = (Talk)o1;
		Talk arg2 = (Talk)o2;
		
		return arg1.getDuration() - arg2.getDuration();
		
	}
}
