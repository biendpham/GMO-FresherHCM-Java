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
package com.gmo.test.controller.student;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.flash;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.MessageSource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.gmo.controller.StudentController;
import com.gmo.service.StudentService;
import com.gmo.util.MessageSourceUtil;

@RunWith(SpringRunner.class)
@WebMvcTest(StudentController.class)
public class StudentDeleteTest {
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	MessageSource messageSource;

	@MockBean
	StudentService studentService;
	
	@Before
	public void setUp() {
		MessageSourceUtil.setMessageSource(messageSource);
	}
	
	@Test
	public void checkDeleteFail() {
		int id = 1;
		Mockito.when(studentService.delete(id)).thenReturn(0);

		try {
			mvc.perform(post("/student/delete").param("id", id + ""))
			.andExpect(status().isFound())
			.andExpect(view().name("redirect:/student/list"))
			.andExpect(flash().attribute("success", false))
			.andExpect(flash().attribute("message", "Delete failed"));
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void checkUpdateThrowException() {
		int id = 1;
		Mockito.when(studentService.delete(id)).thenThrow(RuntimeException.class);

		try {
			mvc.perform(post("/student/delete").param("id", id + ""))
			.andExpect(status().isFound())
			.andExpect(view().name("redirect:/student/list"))
			.andExpect(flash().attribute("success", false))
			.andExpect(flash().attribute("message", "Delete failed"));
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
	}

	@Test
	public void checkUpdatesuccess() {
		int id = 1;
		Mockito.when(studentService.delete(id)).thenReturn(1);

		try {
			mvc.perform(post("/student/delete").param("id", id + ""))
			.andExpect(status().isFound())
			.andExpect(view().name("redirect:/student/list"))
			.andExpect(flash().attribute("success", true))
			.andExpect(flash().attribute("message", "Delete successful"));
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
	}

}
