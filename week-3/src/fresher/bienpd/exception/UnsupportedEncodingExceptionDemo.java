/*
 * Copyright (C) 2020 by GMO Runsystem Company
 *
 * Create class UnsupportedEncodingExceptionDemo
 *
 * @version 1.0
 * 
 * @author BienPD
 *
 */
package fresher.bienpd.exception;

import java.io.UnsupportedEncodingException;

public class UnsupportedEncodingExceptionDemo {
	
	public static void main(String[] args) {
        try {
			"test".getBytes("");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
    }
}

