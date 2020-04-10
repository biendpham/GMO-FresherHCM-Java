/*
 * Copyright (C) 2020 by GMO Runsystem Company
 *
 * Create class StringBuilderDemo
 *
 * @version 1.0
 * 
 * @author BienPD
 *
 */
package fresher.bienpd.javalang.stringbuilder;

public class StringBuilderDemo {

	public static void main(String args[]) {
		
		//init
		StringBuilder sb = new StringBuilder("Hello ");
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
