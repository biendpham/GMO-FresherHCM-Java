/*
 * Copyright (C) 2019 by GMO Runsystem Company
 *
 * Create class Student
 *
 * @version 1.0
 * 
 * @author BienPD
 *
 */
package fresher.bienpd.behavioral.iterator.model;

public class Student {

	private String id;
	private String fullname;

	public Student(String id, String fullname) {
		this.id = id;
		this.fullname = fullname;
	}

	public Student() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	@Override
	public String toString() {
		return "Student [id = " + id + ", fullname = " + fullname + "]";
	}

}
