/*
 * Copyright (C) 2020 by GMO Runsystem Company
 *
 * Create class HashSetDemo
 *
 * @version 1.0
 * 
 * @author BienPD
 *
 */
package fresher.bienpd.javautil.set;

import java.util.HashSet;
import java.util.Set;

public class HashSetDemo {

	public static void main(String[] args) {
        // init hash set
        Set<String> set = new HashSet<String>();
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
