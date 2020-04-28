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
package com.gmo.test.util;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.gmo.dto.SearchRequest;
import com.gmo.dto.StudentDTO;
import com.gmo.dto.UserDTO;
import com.gmo.entity.Student;
import com.gmo.entity.User;
import com.gmo.util.MappingUtil;

@RunWith(SpringRunner.class)
public class MappingUtilTest {

	@Test
	public void testMapUser() {
		UserDTO userDTO = new UserDTO("admin", "123456");
		User user = MappingUtil.mapUser(userDTO);
		
		Assert.assertEquals(user.getUserName(), userDTO.getUserName());
		Assert.assertEquals(user.getPassword(), userDTO.getPassword());
	}
	
	@Test
	public void testMapStudentWithStudentDTO() {
		StudentDTO studentDTO = new StudentDTO(1, 1, "", "Pham Duy Bien", "Gò Vấp", 9.0, new Date());
		Student student = MappingUtil.mapStudent(studentDTO);
		
		Assert.assertEquals(student.getId(), studentDTO.getId());
		Assert.assertEquals(student.getCode(), studentDTO.getCode());
		Assert.assertEquals(student.getName(), studentDTO.getName());
		
		Assert.assertEquals(student.getStudentInfo().getId(), studentDTO.getStudentInfoId());
		Assert.assertEquals(student.getStudentInfo().getStudentId(), studentDTO.getId());
		Assert.assertEquals(student.getStudentInfo().getAddress(), studentDTO.getAddress());
		Assert.assertEquals(student.getStudentInfo().getAverageScore(), studentDTO.getAverageScore());
		Assert.assertEquals(student.getStudentInfo().getDateOfBirth(), studentDTO.getDateOfBirth());
		
	}
	
	@Test
	public void testMapStudentWithSearchRequestWithoutCodeAndName() {
		SearchRequest searchRequest = new SearchRequest();
		Student student = MappingUtil.mapStudent(searchRequest);
		
		Assert.assertEquals(student.getCode(), "");
		Assert.assertEquals(student.getName(), "");
	}
	
	@Test
	public void testMapStudentWithSearchRequestWithCodeAndName() {
		SearchRequest searchRequest = new SearchRequest();
		searchRequest.setCode("STU00001");
		searchRequest.setName("Pham Duy Bien");
		
		Student student = MappingUtil.mapStudent(searchRequest);
		
		Assert.assertEquals(student.getCode(), "STU00001");
		Assert.assertEquals(student.getName(), "Pham Duy Bien");
		
	}
	
}
