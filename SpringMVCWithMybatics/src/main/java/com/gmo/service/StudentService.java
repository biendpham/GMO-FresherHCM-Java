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
package com.gmo.service;

import com.github.pagehelper.Page;
import com.gmo.dto.SearchRequest;
import com.gmo.dto.StudentDTO;
import com.gmo.entity.Student;

public interface StudentService {

	Page<Student> findBySearchRequest(SearchRequest searchRequest);
	
	Student findById(Integer id);
	
	Student findByCode(String code);
	
	Student insert(StudentDTO studentDTO);
	
	int update(StudentDTO studentDTO);
	
	int delete(int id);
	
	String generateCode();
	
}
