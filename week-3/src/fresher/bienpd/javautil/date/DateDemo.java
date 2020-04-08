/*
 * Copyright (C) 2020 by GMO Runsystem Company
 *
 * Create
 *
 * @version 1.0
 * 
 * @author BienPD
 *
 */
package fresher.bienpd.javautil.date;

import java.util.Date;

public class DateDemo {
	
	public static void main(String[] args) {

		// print current Date
		System.out.println(getCurrentDate());
        
		// date1 compare to date2
        Date date1 = getCurrentDate();
        Date date2 = new Date(System.currentTimeMillis() - 10000);
        
        System.out.println("date1 compareTo date2 : " + date1.compareTo(date2));
        System.out.println("date1 equals date2 : " + date1.equals(date2));
        
        // Kiểm tra xem date1 có đứng trước date2 không.
        boolean before = date1.before(date2);
        System.out.println("date1 before date2 : " + before);
 
        // Kiểm tra xem date1 có đứng sau date2 không.
        boolean after = date1.after(date2);
        System.out.println("date1 after date2 : " + after);

    }
	
	static Date getCurrentDate() {
		return new Date();
	}
	
}
