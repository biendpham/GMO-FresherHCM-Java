/*
 * Copyright (C) 2020 by GMO Runsystem Company
 *
 * Create
 *
 * @version 1.0
 * 
 * @author BienPD
 *
 */
package com.gmo.dto;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.gmo.entity.Student;

public class StudentDTO {

	private Integer id;

	private Integer studentInfoId;

	@NotBlank
	@Size(max = 10)
	private String code;

	@NotBlank
	@Size(max = 20)
	private String name;

	@NotBlank
	private String address;

	@NotNull
	@Min(0)
	@Max(10)
	private Double averageScore;

	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateOfBirth;

	public StudentDTO() {

	}
	
	public StudentDTO(String code, String name, String address,	Double averageScore, Date dateOfBirth) {
		this.code = code;
		this.name = name;
		this.address = address;
		this.averageScore = averageScore;
		this.dateOfBirth = dateOfBirth;
	}

	public StudentDTO(Integer id, Integer studentInfoId, String code, String name, 
							String address, Double averageScore, Date dateOfBirth) {
		this.id = id;
		this.studentInfoId = studentInfoId;
		this.code = code;
		this.name = name;
		this.address = address;
		this.averageScore = averageScore;
		this.dateOfBirth = dateOfBirth;
	}

	public StudentDTO(Student student) {
		this.id = student.getId();
		this.code = student.getCode();
		this.name = student.getName();
		this.studentInfoId = student.getStudentInfo().getId();
		this.address = student.getStudentInfo().getAddress();
		this.averageScore = student.getStudentInfo().getAverageScore();
		this.dateOfBirth = student.getStudentInfo().getDateOfBirth();
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
		return "StudentForm [id=" + id + ", code=" + code + ", name=" + name + ", address=" + address
				+ ", averageScore=" + averageScore + ", dateOfBirth=" + dateOfBirth + "]";
	}

	public Integer getStudentInfoId() {
		return studentInfoId;
	}

	public void setStudentInfoId(Integer studentInfoId) {
		this.studentInfoId = studentInfoId;
	}

}
