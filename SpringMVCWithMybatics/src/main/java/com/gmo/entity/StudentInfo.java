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

import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

public class StudentInfo implements Serializable {

	private static final long serialVersionUID = -8307019900377441149L;

	private Integer id;

	@NotBlank
	private Integer studentId;

	@NotBlank
	private String address;

	@NotBlank
	private Double averageScore;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateOfBirth;

	public StudentInfo() {
		this.dateOfBirth = new Date();
	}

	public StudentInfo(Integer id, Integer studentId, String address, Double averageScore, Date dateOfBirth) {
		this.id = id;
		this.studentId = studentId;
		this.address = address;
		this.averageScore = averageScore;
		this.dateOfBirth = dateOfBirth;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
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
	
}
