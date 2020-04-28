/*
 * Copyright (C) 2020 by GMO Runsystem Company
 *
 * Create class StudentModel
 *
 * @version 1.0
 * 
 * @author BienPD
 *
 */
package fresher.bienpd.mvcmodel;

public class StudentModel {

	private Integer id;
	private String name;

	public StudentModel() {
	}

	public StudentModel(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
