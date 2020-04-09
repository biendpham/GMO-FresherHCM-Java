/*
 * Copyright (C) 2020 by GMO Runsystem Company
 *
 * Create class EnumDemo1
 *
 * @version 1.0
 * 
 * @author BienPD
 *
 */
package fresher.bienpd.javautil.enumdemo;

public class EnumDemo1 {
	
	public static void main(String[] args) {
		
		// print enum
        for (WeekDay d : WeekDay.values()) {
            System.out.println(d);
        }
 
        // compare enum
        WeekDay today = WeekDay.SUNDAY;
        
        // use equal() method
        if (today.equals(WeekDay.SUNDAY)) {
            System.out.println("Today is holiday");
        } else {
            System.out.println("Today is working day");
        }
 
        // use == operator
        if (today == WeekDay.SUNDAY) {
            System.out.println("Today is holiday");
        } else {
            System.out.println("Today is working day");
        }
    }

}
