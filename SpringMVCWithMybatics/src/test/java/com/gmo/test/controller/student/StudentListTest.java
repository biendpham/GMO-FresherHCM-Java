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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

import com.github.pagehelper.Page;
import com.gmo.controller.StudentController;
import com.gmo.dto.SearchRequest;
import com.gmo.entity.Student;
import com.gmo.service.StudentService;
import com.gmo.util.MessageSourceUtil;

@RunWith(SpringRunner.class)
@WebMvcTest(StudentController.class)
public class StudentListTest {

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
	public void checkEmptySearchRequestAndNullSession(){
		SearchRequest searchRequest = new SearchRequest(0, 0, null, null, null);
		List<Student> listStudents = new ArrayList<>();
		listStudents.add(new Student());
		Page<Student> pageStudents = Mockito.mock(Page.class);
		Mockito.when(studentService.findBySearchRequest(searchRequest)).thenReturn(pageStudents);
		Mockito.when(pageStudents.getResult()).thenReturn(listStudents);
		try {
			mvc.perform(
				get("/student/list")
				.flashAttr("searchRequest", searchRequest)
			)
			.andExpect(status().isOk())
			.andExpect(view().name("studentList"))
			.andExpect(model().attribute("students", listStudents));
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void checkEmptySearchRequestAndNotNullSession(){
		SearchRequest searchRequest = new SearchRequest(0, 0, null, null, null);
		List<Student> listStudents = new ArrayList<>();
		listStudents.add(new Student());
		Page<Student> pageStudents = Mockito.mock(Page.class);
		Mockito.when(studentService.findBySearchRequest(searchRequest)).thenReturn(pageStudents);
		Mockito.when(pageStudents.getResult()).thenReturn(listStudents);
		try {
			mvc.perform(
				get("/student/list")
				.flashAttr("searchRequest", searchRequest)
				.sessionAttr("searchRequest", searchRequest)
			)
			.andExpect(status().isOk())
			.andExpect(view().name("studentList"))
			.andExpect(model().attribute("students", listStudents));
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}

	@Test
	public void checkNotEmptySearchRequestAndNullSession(){
		SearchRequest searchRequest = new SearchRequest(1, 10, null, null, null);
		List<Student> listStudents = new ArrayList<>();
		listStudents.add(new Student());
		Page<Student> pageStudents = Mockito.mock(Page.class);
		Mockito.when(studentService.findBySearchRequest(searchRequest)).thenReturn(pageStudents);
		Mockito.when(pageStudents.getResult()).thenReturn(listStudents);
		try {
			mvc.perform(
				get("/student/list")
				.flashAttr("searchRequest", searchRequest)
			)
			.andExpect(status().isOk())
			.andExpect(view().name("studentList"))
			.andExpect(model().attribute("students", listStudents));
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void checkNotEmptySearchRequestAndNotNullSession(){
		SearchRequest searchRequest = new SearchRequest(1, 10, null, null, null);
		List<Student> listStudents = new ArrayList<>();
		listStudents.add(new Student());
		Page<Student> pageStudents = Mockito.mock(Page.class);
		Mockito.when(studentService.findBySearchRequest(searchRequest)).thenReturn(pageStudents);
		Mockito.when(pageStudents.getResult()).thenReturn(listStudents);
		try {
			mvc.perform(
				get("/student/list")
				.flashAttr("searchRequest", searchRequest)
				.sessionAttr("searchRequest", new SearchRequest(1, 10, "a", "a", new Date()))
			)
			.andExpect(status().isOk())
			.andExpect(view().name("studentList"))
			.andExpect(model().attribute("students", listStudents));
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
	
}
