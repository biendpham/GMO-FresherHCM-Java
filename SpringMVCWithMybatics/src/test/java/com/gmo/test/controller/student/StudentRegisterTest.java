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
public class StudentRegisterTest {

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
	public void displayStudentRegister(){
		try {
			mvc.perform(get("/student"))
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
			mvc.perform(post("/student"))
			.andExpect(status().isOk())
			.andExpect(view().name("studentRegister-Update"))
			.andExpect(model().attributeExists("student"));
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void checkBlankCode() {
		StudentDTO studentDTO = new StudentDTO("", "Pham Duy Bien", "Gò Vấp", 9.0, new Date());
		try {
			mvc.perform(post("/student").flashAttr("student", studentDTO))
			.andExpect(status().isOk())
			.andExpect(view().name("studentRegister-Update"))
			.andExpect(model().attribute("student", studentDTO));
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void checkBlankName() {
		StudentDTO studentDTO = new StudentDTO("STU00001", "", "Gò Vấp", 9.0, new Date());
		try {
			mvc.perform(post("/student").flashAttr("student", studentDTO))
			.andExpect(status().isOk())
			.andExpect(view().name("studentRegister-Update"))
			.andExpect(model().attribute("student", studentDTO));
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
	}

	@Test
	public void checkBlankAddress() {
		StudentDTO studentDTO = new StudentDTO("STU00001", "Pham Duy Bien", "", 9.0, new Date());
		try {
			mvc.perform(post("/student").flashAttr("student", studentDTO))
			.andExpect(status().isOk())
			.andExpect(view().name("studentRegister-Update"))
			.andExpect(model().attribute("student", studentDTO));
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void checkNullScore() {
		StudentDTO studentDTO = new StudentDTO("STU00001", "Pham Duy Bien", "Gò Vấp", null, new Date());
		try {
			mvc.perform(post("/student").flashAttr("student", studentDTO))
			.andExpect(status().isOk())
			.andExpect(view().name("studentRegister-Update"))
			.andExpect(model().attribute("student", studentDTO));
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
	}	

	@Test
	public void checkNullBirthday() {
		StudentDTO studentDTO = new StudentDTO("STU00001", "Pham Duy Bien", "Gò Vấp", 9.0, null);
		try {
			mvc.perform(post("/student").flashAttr("student", studentDTO))
			.andExpect(status().isOk())
			.andExpect(view().name("studentRegister-Update"))
			.andExpect(model().attribute("student", studentDTO));
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void checkInsertFail() {
		StudentDTO studentDTO = new StudentDTO("STU00001", "Pham Duy Bien", "Gò Vấp", 9.0, new Date());
		Mockito.when(studentService.insert(studentDTO)).thenReturn(null);

		try {
			mvc.perform(post("/student").flashAttr("student", studentDTO))
			.andExpect(status().isOk())
			.andExpect(view().name("studentRegister-Update"))
			.andExpect(model().attribute("success", false))
			.andExpect(model().attribute("message", "Insert failed"))
			.andExpect(model().attribute("student", studentDTO));
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void checkInsertThrowException() {
		StudentDTO studentDTO = new StudentDTO("STU00001", "Pham Duy Bien", "Gò Vấp", 9.0, new Date());
		Mockito.when(studentService.insert(studentDTO)).thenThrow(RuntimeException.class);

		try {
			mvc.perform(post("/student").flashAttr("student", studentDTO))
			.andExpect(status().isOk())
			.andExpect(view().name("studentRegister-Update"))
			.andExpect(model().attribute("success", false))
			.andExpect(model().attribute("message", "Insert failed"))
			.andExpect(model().attribute("student", studentDTO));
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}

	@Test
	public void checkInsertSuccess() {
		StudentDTO studentDTO = new StudentDTO("STU00001", "Pham Duy Bien", "Gò Vấp", 9.0, new Date());
		Student student = Mockito.mock(Student.class);
		Mockito.when(studentService.insert(studentDTO)).thenReturn(student);

		try {
			mvc.perform(post("/student").flashAttr("student", studentDTO))
			.andExpect(status().isFound());
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
	}
}
