/*
 * Copyright (C) 2020 by GMO Runsystem Company
 *
 * Create class ConcatTest
 *
 * @version 1.0
 * 
 * @author BienPD
 *
 */
package fresher.bienpd.javalang;

import java.io.DataInput;

public class ConcatTest {

	public static String concatWithStringBuffer() {
		StringBuffer sb = new StringBuffer("Java");
		for (int i = 0; i < 10000000; i++) {
			sb.append("Hello");
		}
		return sb.toString();
	}
	
	public static String concatWithStringBuilder() {
		StringBuilder sb = new StringBuilder("Java");
		for (int i = 0; i < 10000000; i++) {
			sb.append("Hello");
		}
		return sb.toString();
	}

	public static void main(String[] args) {

		long startTime = System.currentTimeMillis();
		concatWithStringBuffer();
		System.out.println("Thời gian nối chuỗi của lớp StringBuffer (nối 1,000,000 lần): " 
							+ (System.currentTimeMillis() - startTime) + "ms");
		
		startTime = System.currentTimeMillis();
		concatWithStringBuilder();
		System.out.println("Thời gian nối chuỗi của lớp StringBuilder (nối 1,000,000 lần):  " 
							+ (System.currentTimeMillis() - startTime) + "ms");
		
	}

}
