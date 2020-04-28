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
package com.gmo.util;

import com.gmo.dto.SearchRequest;
import com.gmo.dto.StudentDTO;
import com.gmo.dto.UserDTO;
import com.gmo.entity.Student;
import com.gmo.entity.StudentInfo;
import com.gmo.entity.User;

public class MappingUtil {
	
	public static User mapUser(UserDTO userDTO) {
		User user = new User();
		
		user.setUserName(userDTO.getUserName());
		user.setPassword(userDTO.getPassword());
		
		return user;
	}
	
	public static Student mapStudent(StudentDTO studentDTO) {
		Student student = new Student();
		StudentInfo studentInfo = new StudentInfo(studentDTO.getStudentInfoId(), studentDTO.getId(), studentDTO.getAddress(), 
				studentDTO.getAverageScore(), studentDTO.getDateOfBirth());
		student.setId(studentDTO.getId());
		student.setCode(studentDTO.getCode());
		student.setName(studentDTO.getName());
		student.setStudentInfo(studentInfo);
		return student;
	}

	public static Student mapStudent(SearchRequest searchRequest) {
		Student student = new Student();
		
		if (searchRequest.getCode() == null) {
			student.setCode("");
		} else {
			student.setCode(searchRequest.getCode());
		}
		
		if (searchRequest.getName() == null) {
			student.setName("");
		} else {
			student.setName(searchRequest.getName());
		}
		
		student.getStudentInfo().setDateOfBirth(searchRequest.getBirthday());
		
		return student;
	}
}
