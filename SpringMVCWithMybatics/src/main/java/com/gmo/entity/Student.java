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

public class Student implements Serializable {

	private static final long serialVersionUID = -6631797530649957464L;
	
	private Long id;
	private String code;
	private String name;
	private StudentInfo studentInfo;

	public Student() {

	}

	public Student(Long id, String code, String name, StudentInfo studentInfo) {
		this.id = id;
		this.code = code;
		this.name = name;
		this.studentInfo = studentInfo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
