/*
 * Copyright (C) 2020 by GMO Runsystem Company
 *
 * Create class Student
 *
 * @version 1.0
 * 
 * @author BienPD
 *
 */
package com.gmo.entity;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Student implements Serializable {

	private static final long serialVersionUID = -6631797530649957464L;
	
	private Integer id;
	
	@NotBlank
	@Size(max = 10)
	private String code;
	
	@NotBlank
	@Size(max = 20)
	private String name;
	
	private StudentInfo studentInfo;

	public Student() {
		this.studentInfo = new StudentInfo();
	}

	public Student(Integer id, String code, String name, StudentInfo studentInfo) {
		this.id = id;
		this.code = code;
		this.name = name;
		this.studentInfo = studentInfo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public StudentInfo getStudentInfo() {
		return studentInfo;
	}

	public void setStudentInfo(StudentInfo studentInfo) {
		this.studentInfo = studentInfo;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", code=" + code + ", name=" + name + ", studentInfo=" + studentInfo.toString() + "]";
	}
	
}
