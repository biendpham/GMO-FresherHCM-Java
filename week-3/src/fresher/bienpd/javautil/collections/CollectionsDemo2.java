/*
 * Copyright (C) 2020 by GMO Runsystem Company
 *
 * Create class CollectionsDemo2
 *
 * @version 1.0
 * 
 * @author BienPD
 *
 */
package fresher.bienpd.javautil.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsDemo2 {

	public static void main(String a[]) {
		
        List<String> list = new ArrayList<String>();
        list.add("Java");
        list.add("Core Java");
        list.add("Advance Java");
        System.out.println("Initial collection value:" + list);
 
        Collections.addAll(list, "Servlet", "JSP");
        System.out.println("After adding elements collection value:" + list);
 
        String[] strArr = { "C#", ".Net" };
        Collections.addAll(list, strArr);
        System.out.println("After adding array collection value:" + list);
        
    }
	
}
