/*
 * Copyright (C) 2020 by GMO Runsystem Company
 *
 * Create class Student2
 *
 * @version 1.0
 * 
 * @author BienPD
 *
 */
package fresher.bienpd.interfaces.serialization;

import java.io.Serializable;

public class Student2 implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String fullname;

	public Student2(Long id, String fullname) {
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
