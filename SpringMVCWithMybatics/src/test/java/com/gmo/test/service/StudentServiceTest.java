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
package com.gmo.test.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.pagehelper.Page;
import com.gmo.dto.SearchRequest;
import com.gmo.dto.StudentDTO;
import com.gmo.entity.Student;
import com.gmo.entity.StudentInfo;
import com.gmo.mapper.StudentInfoMapper;
import com.gmo.mapper.StudentMapper;
import com.gmo.service.StudentService;
import com.gmo.service.impl.StudentServiceImpl;
import com.gmo.util.MappingUtil;

@RunWith(SpringRunner.class)
public class StudentServiceTest {

	private List<Student> listStudents = new ArrayList<>();
	private Page<Student> pageStudents = new Page<>();
	private StudentDTO studentDTO = Mockito.mock(StudentDTO.class);
	private Student student = Mockito.mock(Student.class);
	private StudentInfo studentInfo = Mockito.mock(StudentInfo.class);
	
	@TestConfiguration
	public static class StudentServiceTestConfiguration {
		@Bean
		StudentService studentService() {
			return new StudentServiceImpl();
		}
	}
	
	@MockBean
	StudentMapper studentMapper;
	
	@MockBean
	StudentInfoMapper studentInfoMapper;
	
	@MockBean
	SqlSessionFactory sqlSessionFactory;
	
	@Before
	public void setUp() {
		listStudents.add(new Student(1, "STU00001", "Pham Duy Bien", new StudentInfo(1, 1, "Gò Vấp", 9.0, new Date())));
		pageStudents.add(new Student(1, "STU00001", "Pham Duy Bien", new StudentInfo(1, 1, "Gò Vấp", 9.0, new Date())));
		
		SqlSession ss = Mockito.mock(SqlSession.class);
		studentMapper = Mockito.mock(StudentMapper.class);
		studentInfoMapper = Mockito.mock(StudentInfoMapper.class);
		
		Mockito.when(sqlSessionFactory.openSession()).thenReturn(ss);
		Mockito.when(ss.getMapper(StudentMapper.class)).thenReturn(studentMapper);
		Mockito.when(ss.getMapper(StudentInfoMapper.class)).thenReturn(studentInfoMapper);
		
	}

	
	@Autowired
	private StudentService studentService;

	@Test
	public void checkFindBySearchRequestWithPageNumEqualsZeroAndNullBirthday() {
		try {
			SearchRequest searchRequest = new SearchRequest();
			Student student = MappingUtil.mapStudent(searchRequest);

			Mockito.when(studentMapper.findByNameAndCode(student)).thenReturn(pageStudents);

//			Assert.assertEquals(studentService.findBySearchRequest(searchRequest), pageStudents);
			studentService.findBySearchRequest(searchRequest);

			Assert.assertEquals(10, searchRequest.getPageSize());
			Assert.assertEquals(1, searchRequest.getPageNum());
			
		} catch (Exception e) {
			Assert.assertTrue(false);
		}	
	}

	@Test
	public void checkFindBySearchRequestWithPageNumEqualsZeroAndNotNullBirthday() {
		try {
			SearchRequest searchRequest = new SearchRequest();
			searchRequest.setBirthday(new Date());
			Student student = MappingUtil.mapStudent(searchRequest);

			Mockito.when(studentMapper.findBySearchRequest(student)).thenReturn(pageStudents);

//			Assert.assertEquals(studentService.findBySearchRequest(searchRequest), pageStudents);
			studentService.findBySearchRequest(searchRequest);

			Assert.assertEquals(10, searchRequest.getPageSize());
			Assert.assertEquals(1, searchRequest.getPageNum());
			
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
	}

	@Test
	public void checkFindBySearchRequestWithPageNumNotZeroAndNullBirthday() {
		try {
			SearchRequest searchRequest = new SearchRequest();
			searchRequest.setPageNum(2);
			searchRequest.setPageSize(11);

			Student student = MappingUtil.mapStudent(searchRequest);

			Mockito.when(studentMapper.findByNameAndCode(student)).thenReturn(pageStudents);

//			Assert.assertEquals(studentService.findBySearchRequest(searchRequest), pageStudents);
			studentService.findBySearchRequest(searchRequest);

			Assert.assertEquals(11, searchRequest.getPageSize());
			Assert.assertEquals(2, searchRequest.getPageNum());
			
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void checkFindBySearchRequestWithPageNumNotZeroAndNotNullBirthday() {
		try {
			SearchRequest searchRequest = new SearchRequest();
			searchRequest.setPageNum(2);
			searchRequest.setPageSize(11);
			searchRequest.setBirthday(new Date());
			Student student = MappingUtil.mapStudent(searchRequest);

			Mockito.when(studentMapper.findBySearchRequest(student)).thenReturn(pageStudents);

//			Assert.assertEquals(studentService.findBySearchRequest(searchRequest), pageStudents);
			studentService.findBySearchRequest(searchRequest);

			Assert.assertEquals(11, searchRequest.getPageSize());
			Assert.assertEquals(2, searchRequest.getPageNum());
			
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void checkFindByIdReturnNull() {
		try {
			int id = 1;
			
			Mockito.when(studentMapper.findById(id)).thenReturn(null);
			
			Assert.assertEquals(studentService.findById(id), null);
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void checkFindByIdReturnNotNull() {
		try {
			int id = 1;
			Student student = new Student();
			
			Mockito.when(studentMapper.findById(id)).thenReturn(student);
			
			Assert.assertEquals(studentService.findById(id), student);
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void checkFindByIdThrowException() {
		try {
			int id = 1;
			
			Mockito.when(studentMapper.findById(id)).thenThrow(RuntimeException.class);
			
			Assert.assertEquals(studentService.findById(id), null);
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
	}

	@Test
	public void checkFindByCodeReturnNull() {
		try {
			String code = "STU00001";
			
			Mockito.when(studentMapper.findByCode(code)).thenReturn(null);
			
			Assert.assertEquals(studentService.findByCode(code), null);
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void checkFindByCodeReturnNotNull() {
		try {
			String code = "STU00001";
			Student student = new Student();
			
			Mockito.when(studentMapper.findByCode(code)).thenReturn(student);
			
			Assert.assertEquals(studentService.findByCode(code), student);
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void checkFindByCodeThrowException() {
		try {
			String code = "STU00001";
			
			Mockito.when(studentMapper.findByCode(code)).thenThrow(RuntimeException.class);
			
			Assert.assertEquals(studentService.findByCode(code), null);
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void checkInsertStudentFail() {
		try {
			StudentDTO studentDTO = Mockito.mock(StudentDTO.class);
			Student student = Mockito.mock(Student.class);
			
			Mockito.when(studentMapper.insert(student)).thenReturn(0);
			
			Assert.assertEquals(studentService.insert(studentDTO), null);
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
	}
//	
//	@Test
//	public void checkInsertStudentSuccessAndInsertStudentInfoFail() {
//		try {
//			Mockito.when(studentMapper.insert(student)).thenReturn(1);
//			Mockito.when(studentInfoMapper.insert(studentInfo)).thenReturn(0);
//			
//			Assert.assertEquals(studentService.insert(studentDTO), null);
//		} catch (Exception e) {
//			e.printStackTrace();
//			Assert.assertTrue(false);
//		}
//	}
	
	@Test
	public void checkUpdateStudentFail() {
		try {
			StudentDTO studentDTO = Mockito.mock(StudentDTO.class);
			Student student = Mockito.mock(Student.class);
			
			Mockito.when(studentMapper.update(student)).thenReturn(0);
			
			Assert.assertEquals(studentService.update(studentDTO), 0);
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void checkDeletestudentFail() {
		try {
			int id = 1;
			
			Mockito.when(studentMapper.delete(id)).thenReturn(0);
			
			Assert.assertEquals(studentService.delete(id), 0);
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void checkDeletestudentThrowException() {
		try {
			int id = 1;
			
			Mockito.when(studentMapper.delete(id)).thenThrow(RuntimeException.class);
			
			Assert.assertEquals(studentService.delete(id), 0);
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
	}

	@Test
	public void checkDeletestudentSuccess() {
		try {
			int id = 1;
			
			Mockito.when(studentMapper.delete(id)).thenReturn(1);
			
			Assert.assertEquals(studentService.delete(id), 1);
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
	}


	@Test
	public void checkGenerateCode() {
		try {
//			Mockito.when(Math.random()).thenReturn(0.9);
			String code = "STU900000";
//			Mockito.when(studentMapper.findByCode(code)).thenReturn(null);
			
			Assert.assertNotEquals(studentService.generateCode(), code);
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
	}








}
