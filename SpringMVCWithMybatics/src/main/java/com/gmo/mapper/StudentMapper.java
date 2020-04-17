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

	Page<Student> findByName(String name);
	
	Student findById(Integer id);
	
	int insert(Student student);
	
	int update(Student student);
	
	int delete(Student student);
}
