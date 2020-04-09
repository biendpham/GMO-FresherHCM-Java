/*
 * Copyright (C) 2020 by GMO Runsystem Company
 *
 * Create class CalendarDemo1
 *
 * @version 1.0
 * 
 * @author BienPD
 *
 */
package fresher.bienpd.javautil.calendar;

import java.util.Calendar;

public class CalendarDemo1 {
	
	public static void main(String[] args) {
		
        Calendar calendar = Calendar.getInstance();
        
        System.out.println("Ngay gio hien tai: " + calendar.getTime());
        System.out.println("YEAR: " + calendar.get(Calendar.YEAR));
        System.out.println("MONTH: " + calendar.get(Calendar.MONTH));
        System.out.println("DAY: " + calendar.get(Calendar.DATE));
        System.out.println("DAY_OF_WEEK: " + calendar.get(Calendar.DAY_OF_WEEK));
        System.out.println("DAY_OF_MONTH: " + calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println("DAY_OF_YEAR: " + calendar.get(Calendar.DAY_OF_YEAR));
        
        calendar.add(Calendar.DATE, -15);
        System.out.println("15 ngay sau: " + calendar.getTime());
        
        calendar.add(Calendar.MONTH, 4);
        System.out.println("4 thang sau: " + calendar.getTime());
        
        calendar.add(Calendar.YEAR, 2);
        System.out.println("2 nam sau: " + calendar.getTime());
        
    }

}
