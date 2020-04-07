/*
 * Copyright (C) 2019 by GMO Runsystem Company
 *
 * Create class ArrayStudentIterator
 *
 * @version 1.0
 * 
 * @author BienPD
 *
 */
package fresher.bienpd.behavioral.iterator.impl;

import fresher.bienpd.behavioral.iterator.Iterator;
import fresher.bienpd.behavioral.iterator.model.Student;

public class ArrayStudentIterator implements Iterator<Student>{
	
	Student[] students;
	int index = 0;
	
	public ArrayStudentIterator(Student[] students) {
		this.students = students;
	}

	@Override
	public boolean hasNext() {
		if(index >= students.length || students[index] == null) {
			return false;
		}
		return true;
	}

	@Override
	public Student next() {
		return students[index++];
	}

	
	
}
