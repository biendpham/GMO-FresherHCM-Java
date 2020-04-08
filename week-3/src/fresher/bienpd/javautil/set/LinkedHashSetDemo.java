/*
 * Copyright (C) 2020 by GMO Runsystem Company
 *
 * Create class LinkedHashSetDemo
 *
 * @version 1.0
 * 
 * @author BienPD
 *
 */
package fresher.bienpd.javautil.set;

import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetDemo {

	public static void main(String[] args) {
        // init linked hash set
        Set<String> set = new LinkedHashSet<String>();
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
