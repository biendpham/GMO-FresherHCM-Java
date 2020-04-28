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
package com.gmo.test.controller.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.MessageSource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.gmo.controller.api.StudentAPI;
import com.gmo.service.StudentService;

@RunWith(SpringRunner.class)
@WebMvcTest(StudentAPI.class)
public class StudentAPITest {
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	MessageSource messageSource;

	@MockBean
	StudentService studentService;
	
	@Test
	public void checkGenerateCode() {
		Mockito.when(studentService.generateCode()).thenReturn("STU12345");
		try {
			MvcResult result = mvc.perform(get("/api/student/generateCode"))
			.andExpect(status().isOk())
			.andReturn();
			Assert.assertEquals(result.getResponse().getContentAsString(), "STU12345");
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
	}

}
