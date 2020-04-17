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
package com.gmo.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DatetimeUtil {

	private static SimpleDateFormat DATE_FORMAT;

	/**
     * convert String to Date
     *
     * @param dateString date to convert
     * @param pattern 
     *
     * @return Date
     */
    public static Date toDate(String dateString, String... pattern) {
        try {
            if (pattern.length > 0) {
                DATE_FORMAT.applyPattern(pattern[0]);
            } else {
                DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
            }
            return DATE_FORMAT.parse(dateString);
        } catch (ParseException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    /**
     * get current time
     *
     * @return Date
     */
    public static Date now() {
        return new Date();
    }

    public static String toString(Date date, String... pattern) {
        if (pattern.length > 0) {
            DATE_FORMAT.applyPattern(pattern[0]);
        } else {
            DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
        }

        if (date == null) {
            date = DatetimeUtil.now();
        }
        return DATE_FORMAT.format(date);
    }
}
