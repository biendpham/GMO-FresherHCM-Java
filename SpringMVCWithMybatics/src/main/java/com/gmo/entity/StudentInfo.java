/*
 * Copyright (C) 2020 by GMO Runsystem Company
 *
 * Create class StudentInfo
 *
 * @version 1.0
 * 
 * @author BienPD
 *
 */
package com.gmo.entity;

import java.io.Serializable;
import java.util.Date;

public class StudentInfo implements Serializable {

	private static final long serialVersionUID = -8307019900377441149L;

	private Long id;
	private Student student;
	private String address;
	private Double averageScore;
	private Date dateOfBirth;

	public StudentInfo() {

	}

	public StudentInfo(Long id, Student student, String address, Double averageScore, Date dateOfBirth) {
		this.id = id;
		this.student = student;
		this.address = address;
		this.averageScore = averageScore;
		this.dateOfBirth = dateOfBirth;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Double getAverageScore() {
		return averageScore;
	}

	public void setAverageScore(Double averageScore) {
		this.averageScore = averageScore;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public String toString() {
		return "StudentInfo [id=" + id + ", student=" + student + ", address=" + address + ", averageScore="
				+ averageScore + ", dateOfBirth=" + dateOfBirth + "]";
	}

}
