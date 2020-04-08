/*
 * Copyright (C) 2020 by GMO Runsystem Company
 *
 * Create class TreeSetDemo
 *
 * @version 1.0
 * 
 * @author BienPD
 *
 */
package fresher.bienpd.javautil.set;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetDemo {

	public static void main(String[] args) {
		// init tree set
		Set<String> set = new TreeSet<String>();
		set.add("Java");
		set.add("C++");
		set.add("Java");
		set.add(".Net");
		// show set
		for (String str : set) {
			System.out.println(str);
		}
	}
	
}
