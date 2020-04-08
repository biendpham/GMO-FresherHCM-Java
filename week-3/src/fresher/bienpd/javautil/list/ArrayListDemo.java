/*
 * Copyright (C) 2020 by GMO Runsystem Company
 *
 * Create class ArrayListDemo
 *
 * @version 1.0
 * 
 * @author BienPD
 *
 */
package fresher.bienpd.javautil.list;

import java.util.ArrayList;
import java.util.List;

public class ArrayListDemo {

	public static void main(String[] args) {

		// Create list with no parameter
		List<String> list1 = new ArrayList<>();
		for (int i = 1; i <= 5; i++) {
			list1.add("0" + i);
		}

		System.out.print("Init list1 = ");
		printData(list1);

		// addAll()
		List<String> list2 = new ArrayList<>();
		list2.addAll(list1);
		list2.add("0" + 3);
		System.out.print("list2 = ");
		printData(list2);

		// IndexOf()
		System.out.println("list2.indexOf(03) = " + list2.indexOf("03"));
		System.out.println("list2.indexOf(06) = " + list2.indexOf("06"));

		// lastIndexOf()
		System.out.println("list2.lastIndexOf(03) = " + list2.lastIndexOf("03"));

		// Remove
		list2.remove("01");
		System.out.print("After list2.remove(01): list2 = ");
		printData(list2);

		// retainAll()
		List<String> list4 = new ArrayList<>(list1);
		System.out.print("Init list4 = ");
		printData(list4);

		ArrayList<String> list3 = new ArrayList<String>();
		list3.add("0" + 3);
		list3.add("0" + 2);

		System.out.print("Init list3 = ");
		printData(list3);

		list4.retainAll(list3);

		System.out.print("After list4.retainAll(list3): list4 = ");
		printData(list4);

		// removeAll()
		List<String> list5 = new ArrayList<>(list1);
		System.out.print("Init list5 = ");
		printData(list5);

		list5.removeAll(list3);
		System.out.print("After list5.removeAll(list3): list5 = ");
		printData(list5);
	}

	public static void printData(List<String> list) {

		for (String item : list) {
			System.out.print(item + " ");
		}
		System.out.println();

	}
}
