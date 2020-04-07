/*
 * Copyright (C) 2019 by GMO Runsystem Company
 *
 * Create class ListStudentIterator
 *
 * @version 1.0
 * 
 * @author BienPD
 *
 */
package fresher.bienpd.behavioral.iterator.impl;

import java.util.List;

import fresher.bienpd.behavioral.iterator.Iterator;
import fresher.bienpd.behavioral.iterator.model.Student;

public class ListStudentIterator implements Iterator<Student>{

	List<Student> listStudent;
	int index = 0;

	public ListStudentIterator(List<Student> listStudent) {
		this.listStudent = listStudent;
	}

	@Override
	public boolean hasNext() {
		if(index >= listStudent.size() || listStudent.get(index) == null) {
			return false;
		}
		return true;
	}

	@Override
	public Student next() {
		return listStudent.get(index++);
	}

}
