/*
 * Copyright (C) 2020 by GMO Runsystem Company
 *
 * Create class CollectionsDemo4
 *
 * @version 1.0
 * 
 * @author BienPD
 *
 */
package fresher.bienpd.javautil.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import fresher.bienpd.javautil.collections.model.Student;

public class CollectionsDemo4 {

	public static void main(String a[]) {
		List<Student> students = new ArrayList<>();
		Student student1 = new Student(1, "Pham Duy Bien", 15);
		Student student2 = new Student(2, "Tran Van An", 20);
		Student student3 = new Student(3, "Nguyen Dai Nghia", 17);
		Student student4 = new Student(4, "Nguyen Thi Ngoc Bich", 10);
		Student student5 = new Student(5, "Le Thi Quy", 19);
		Student student6 = new Student(6, "Ho Thi Phi", 19);
		students.add(student3);
		students.add(student1);
		students.add(student2);
		students.add(student5);
		students.add(student4);

		// Init comparator
		StudentComparator comparator = new StudentComparator();

		// Using comparator
		System.out.println("Maximum value: " + Collections.max(students, comparator));
		System.out.println("Minimum value: " + Collections.min(students, comparator));
		System.out.println("Index of student1 : " + Collections.binarySearch(students, student1, comparator));
		System.out.println("Index of student6 : " + Collections.binarySearch(students, student6, comparator));
		System.out.println("---");

		Collections.sort(students, comparator);
		System.out.println("Sorted ASC: ");

		print(students);

		Collections.reverse(students);
		System.out.println("Sorted DESC: ");
		print(students);

		Comparator<Student> compareDesc = Collections.reverseOrder(comparator);
		Collections.sort(students, compareDesc);
		System.out.println("Sorted DESC: ");
		print(students);

		Comparator<Student> compareAsc = Collections.reverseOrder(compareDesc);
		Collections.sort(students, compareAsc);
		System.out.println("Sorted ASC: ");
		print(students);
	}

	private static void print(List<Student> students) {
		for (Student student : students) {
			System.out.println(student);
		}
		System.out.println("---");
	}
}
