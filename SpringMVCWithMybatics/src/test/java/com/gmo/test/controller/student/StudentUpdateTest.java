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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.Date;

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
import com.gmo.dto.StudentDTO;
import com.gmo.entity.Student;
import com.gmo.service.StudentService;
import com.gmo.util.MessageSourceUtil;

@RunWith(SpringRunner.class)
@WebMvcTest(StudentController.class)
public class StudentUpdateTest {

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
	public void displayStudentUpdate(){
		Mockito.when(studentService.findById(1)).thenReturn(new Student());
		try {
			mvc.perform(get("/student/1"))
			.andExpect(status().isOk())
			.andExpect(view().name("studentRegister-Update"))
			.andExpect(model().attributeExists("student"));
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void notSendData() {
		try {
			mvc.perform(post("/student/1"))
			.andExpect(status().isOk())
			.andExpect(view().name("studentRegister-Update"))
			.andExpect(model().attributeExists("student"));
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void checkBlankCode() {
		StudentDTO studentDTO = new StudentDTO(1, 1, "", "Pham Duy Bien", "Gò Vấp", 9.0, new Date());
		try {
			mvc.perform(post("/student/1").flashAttr("student", studentDTO))
			.andExpect(status().isOk())
			.andExpect(view().name("studentRegister-Update"))
			.andExpect(model().attribute("student", studentDTO));
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void checkBlankName() {
		StudentDTO studentDTO = new StudentDTO(1, 1, "STU00001", "", "Gò Vấp", 9.0, new Date());
		try {
			mvc.perform(post("/student/1").flashAttr("student", studentDTO))
			.andExpect(status().isOk())
			.andExpect(view().name("studentRegister-Update"))
			.andExpect(model().attribute("student", studentDTO));
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
	}

	@Test
	public void checkBlankAddress() {
		StudentDTO studentDTO = new StudentDTO(1, 1, "STU00001", "Pham Duy Bien", "", 9.0, new Date());
		try {
			mvc.perform(post("/student/1").flashAttr("student", studentDTO))
			.andExpect(status().isOk())
			.andExpect(view().name("studentRegister-Update"))
			.andExpect(model().attribute("student", studentDTO));
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void checkNullScore() {
		StudentDTO studentDTO = new StudentDTO(1, 1, "STU00001", "Pham Duy Bien", "Gò Vấp", null, new Date());
		try {
			mvc.perform(post("/student/1").flashAttr("student", studentDTO))
			.andExpect(status().isOk())
			.andExpect(view().name("studentRegister-Update"))
			.andExpect(model().attribute("student", studentDTO));
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
	}	

	@Test
	public void checkNullBirthday() {
		StudentDTO studentDTO = new StudentDTO(1, 1, "STU00001", "Pham Duy Bien", "Gò Vấp", 9.0, null);
		try {
			mvc.perform(post("/student/1").flashAttr("student", studentDTO))
			.andExpect(status().isOk())
			.andExpect(view().name("studentRegister-Update"))
			.andExpect(model().attribute("student", studentDTO));
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void checkUpdateFail() {
		StudentDTO studentDTO = new StudentDTO(1, 1, "STU00001", "Pham Duy Bien", "Gò Vấp", 9.0, new Date());
		Mockito.when(studentService.update(studentDTO)).thenReturn(0);

		try {
			mvc.perform(post("/student/1").flashAttr("student", studentDTO))
			.andExpect(status().isOk())
			.andExpect(view().name("studentRegister-Update"))
			.andExpect(model().attribute("success", false))
			.andExpect(model().attribute("message", "Update failed"))
			.andExpect(model().attribute("student", studentDTO));
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void checkUpdateThrowException() {
		StudentDTO studentDTO = new StudentDTO(1, 1, "STU00001", "Pham Duy Bien", "Gò Vấp", 9.0, new Date());
		Mockito.when(studentService.update(studentDTO)).thenThrow(RuntimeException.class);

		try {
			mvc.perform(post("/student/1").flashAttr("student", studentDTO))
			.andExpect(status().isOk())
			.andExpect(view().name("studentRegister-Update"))
			.andExpect(model().attribute("success", false))
			.andExpect(model().attribute("message", "Update failed"))
			.andExpect(model().attribute("student", studentDTO));
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}

	@Test
	public void checkUpdatesuccess() {
		StudentDTO studentDTO = new StudentDTO(1, 1, "STU00001", "Pham Duy Bien", "Gò Vấp", 9.0, new Date());
		Mockito.when(studentService.update(studentDTO)).thenReturn(1);

		try {
			mvc.perform(post("/student/1").flashAttr("student", studentDTO))
			.andExpect(status().isOk())
			.andExpect(view().name("studentRegister-Update"))
			.andExpect(model().attribute("success", true))
			.andExpect(model().attribute("message", "Update successful"))
			.andExpect(model().attribute("student", studentDTO));
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
	}
}
