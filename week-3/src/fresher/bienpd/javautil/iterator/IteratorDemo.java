/*
 * Copyright (C) 2020 by GMO Runsystem Company
 *
 * Create class IteratorDemo
 *
 * @version 1.0
 * 
 * @author BienPD
 *
 */
package fresher.bienpd.javautil.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class IteratorDemo {

	public static void main(String args[]) {
		
        ArrayList<String> listLanguages = new ArrayList<>();
 
        // them phan tu vao array list
        listLanguages.add("Java");
        listLanguages.add("Python");
        listLanguages.add("PHP");
        listLanguages.add(".NET");
        listLanguages.add("C");
        listLanguages.add("C++");
 
        // su dung iterator de hien thi noi dung cua listLanguages
        System.out.println("Danh sach ngon ngu lap trinh: ");
        print(listLanguages.iterator());
        System.out.println();
 
        // sua cac phan tu duoc lap
        ListIterator<String> litr = listLanguages.listIterator();
        while (litr.hasNext()) {
            String element = litr.next();
            litr.set(element + " (PASS)");
        }
        System.out.println("Noi dung da duoc sua cua listLanguages: ");
        print(listLanguages.iterator());
        System.out.println();
 
        // hien thi cac phan tu theo thu tu nguoc lai
        System.out.println("Noi dung da duoc sua cua listLanguages "
                + "theo thu tu nguoc lai: ");
        while (litr.hasPrevious()) {
            Object element = litr.previous();
            System.out.println(element);
        }
        System.out.println();
         
        // xoa phan tu C (PASS)
        litr = listLanguages.listIterator();
        while (litr.hasNext()) {
            Object element = litr.next();
            if ("C (PASS)".equals(element.toString())) {
             litr.remove();
            }
        }
        System.out.println("listLanguages xoa phan tu C: ");
        print(listLanguages.iterator());
        System.out.println();
         
    }
	
	static void print(Iterator<String> iterator) {
		while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.println(element);
        }
	}
	
}
