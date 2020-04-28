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
package com.gmo.mapper;

import com.github.pagehelper.Page;
import com.gmo.entity.Student;

public interface StudentMapper {

	Page<Student> findBySearchRequest(Student student);
	
	Page<Student> findByNameAndCode(Student student);
	
	Student findById(Integer id);
	
	Student findByCode(String code);
	
	int insert(Student student);
	
	int update(Student student);
	
	int delete(int id);
}
