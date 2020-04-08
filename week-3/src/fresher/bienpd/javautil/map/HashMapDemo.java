/*
 * Copyright (C) 2020 by GMO Runsystem Company
 *
 * Create class HashMapDemo
 *
 * @version 1.0
 * 
 * @author BienPD
 *
 */
package fresher.bienpd.javautil.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class HashMapDemo {
	
	public static void main(String args[]) {
		
        // init map
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "Basic java");
        map.put(2, "OOP");
        map.put(3, "Collection");
 
        // show map using method keySet()
        for (Integer key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " : " + value);
        }
 
        System.out.println("-----------------");
        
        //update value
        map.put(3, "Spring");
 
        // show map using method entrySet()
        for (Entry<Integer, String> entry : map.entrySet()) {
            Integer key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + " : " + value);
        }
        
        System.out.println("-----------------");
        
        //remove
        map.remove(2);
        
        // show map using iterator
        Iterator<Entry<Integer, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
        	Entry<Integer, String> entry = iterator.next();
        	System.out.println(entry.getKey() + " : " + entry.getValue());
		}
        
    }
	
}
