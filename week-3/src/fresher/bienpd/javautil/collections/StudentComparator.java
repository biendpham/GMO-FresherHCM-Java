/*
 * Copyright (C) 2020 by GMO Runsystem Company
 *
 * Create class StudentComparator
 *
 * @version 1.0
 * 
 * @author BienPD
 *
 */
package fresher.bienpd.javautil.collections;

import java.util.Comparator;

import fresher.bienpd.javautil.collections.model.Student;

public class StudentComparator implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		return o1.getName().compareTo(o2.getName());
	}

}
