/*
 * Copyright (C) 2020 by GMO Runsystem Company
 *
 * Create class EnumDemo2
 *
 * @version 1.0
 * 
 * @author BienPD
 *
 */
package fresher.bienpd.javautil.enumdemo;

public class EnumDemo2 {
	
	public static void main(String[] args) {
        WeekDay today = WeekDay.THURSDAY;
 
        switch (today) {
        case MONDAY:
        case TUESDAY:
        case WEDNESDAY:
        case THURSDAY:
        case FRIDAY:
            System.out.println("Today is working day");
            break;
        case SATURDAY:
        case SUNDAY:
            System.out.println("Today is holiday");
            break;
        default:
            System.out.println(today);
        }
    }
	
}
