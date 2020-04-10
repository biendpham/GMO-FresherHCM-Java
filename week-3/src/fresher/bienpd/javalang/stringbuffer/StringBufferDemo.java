/*
 * Copyright (C) 2020 by GMO Runsystem Company
 *
 * Create class StringBufferDemo
 *
 * @version 1.0
 * 
 * @author BienPD
 *
 */
package fresher.bienpd.javalang.stringbuffer;

public class StringBufferDemo {

public static void main(String args[]) {
		
		//init
		StringBuffer sb = new StringBuffer("Hello ");
		System.out.println(sb);
		System.out.println("capacity: " + sb.capacity());
		
		// append
		sb.append("Java");
		System.out.println(sb);
		
		// insert
		sb.insert(1, "Hi");
		System.out.println(sb);
		
		// replace
		sb.replace(1, 3, "");
		System.out.println(sb);
		
		//reverse 
		sb.reverse();
		System.out.println("reverse: " + sb);
		
		sb.reverse().append(". It is my favorite languge");
		System.out.println(sb);
		System.out.println("capacity: " + sb.capacity());
	}

}
