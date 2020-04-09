/*
 * Copyright (C) 2020 by GMO Runsystem Company
 *
 * Create class CalendarDemo2
 *
 * @version 1.0
 * 
 * @author BienPD
 *
 */
package fresher.bienpd.javautil.calendar;

import java.util.Calendar;

public class CalendarDemo2 {
	
	public static void main(String[] args) {
		
        Calendar calendar = Calendar.getInstance();
        
        System.out.println("So ngay toi da trong tuan: " + calendar.getMaximum(Calendar.DAY_OF_WEEK));
        
        System.out.println("So ngay toi da trong thang " 
        				+ (calendar.get(Calendar.MONTH) + 1)
        				+ ": "
        				+ calendar.getActualMaximum(Calendar.DATE));
        
        System.out.println("So tuan toi da trong nam: " + calendar.getMaximum(Calendar.WEEK_OF_YEAR));
        
    }

}
