/*
 * Copyright (C) 2019 by GMO Runsystem Company
 *
 * Create class ListStudent
 *
 * @version 1.0
 * 
 * @author BienPD
 *
 */
package fresher.bienpd.behavioral.iterator;

import java.util.List;

import fresher.bienpd.behavioral.iterator.impl.ListStudentIterator;
import fresher.bienpd.behavioral.iterator.model.Student;

public class ListStudent {
	
	private List<Student> listStudent;

	public ListStudent(List<Student> listStudent) {
		this.listStudent = listStudent;
	}

	public Iterator<Student> creaIterator() {
		return new ListStudentIterator(listStudent);
	}
}
