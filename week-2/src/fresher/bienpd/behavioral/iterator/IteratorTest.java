/*
 * Copyright (C) 2019 by GMO Runsystem Company
 *
 * Create class IteratorTest
 *
 * @version 1.0
 * 
 * @author BienPD
 *
 */
package fresher.bienpd.behavioral.iterator;

import java.util.ArrayList;
import java.util.List;

import fresher.bienpd.behavioral.iterator.model.Student;

public class IteratorTest {
	
	static Student[] arrayStudent = new Student[4];
	static List<Student> listStudent = new ArrayList<>();

	public static void main(String[] args) {
		
		Iterator<Student> iteratorWithArray = new ArrayStudent(arrayStudent).creaIterator();
		Iterator<Student> iteratorWithList = new ListStudent(listStudent).creaIterator();
		
		while (iteratorWithArray.hasNext()) {
			System.out.println(iteratorWithArray.next().toString());
		}
		
		while (iteratorWithList.hasNext()) {
			System.out.println(iteratorWithList.next().toString());
		}
	}
	
	static {
		arrayStudent[0] = new Student("PH1", "Pham Duy Bien");
		arrayStudent[1] = new Student("PH2", "Nguyen Tuong Tam");
		arrayStudent[2] = new Student("PH3", "Nguyen Dai Nghia");
		arrayStudent[3] = new Student("PH4", "Le Thi Quy");
		
		listStudent.add(new Student("PS1", "Nguyễn Ngọc Tú"));
		listStudent.add(new Student("PS2", "Nguyễn Thị Ngọc Bích"));
		listStudent.add(new Student("PS3", "Giang Thị Thu Trang"));
		listStudent.add(new Student("PS4", "Nguyễn Trung Kiên"));
	}
	
}
