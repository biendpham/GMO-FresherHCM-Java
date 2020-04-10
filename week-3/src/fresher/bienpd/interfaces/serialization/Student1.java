/*
 * Copyright (C) 2020 by GMO Runsystem Company
 *
 * Create class Student1
 *
 * @version 1.0
 * 
 * @author BienPD
 *
 */
package fresher.bienpd.interfaces.serialization;

public class Student1 {

	private Long id;
	private String fullname;

	public Student1(Long id, String fullname) {
		this.id = id;
		this.fullname = fullname;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
		return "Student [id=" + id + ", fullname=" + fullname + "]";
	}

}
