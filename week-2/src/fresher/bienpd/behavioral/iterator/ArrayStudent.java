/*
 * Copyright (C) 2019 by GMO Runsystem Company
 *
 * Create class ArrayStudent
 *
 * @version 1.0
 * 
 * @author BienPD
 *
 */
package fresher.bienpd.behavioral.iterator;

import fresher.bienpd.behavioral.iterator.impl.ArrayStudentIterator;
import fresher.bienpd.behavioral.iterator.model.Student;

public class ArrayStudent {

	private Student[] students;

	public ArrayStudent(Student[] students) {
		this.students = students;
	}
	
	public Iterator<Student> creaIterator(){
		return new ArrayStudentIterator(students);
	}
	
}
