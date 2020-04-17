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
import com.gmo.entity.Pageable;
import com.gmo.entity.Student;

public interface StudentService {

	Page<Student> findByName(Pageable pageable);
	
	Student findById(Integer id);
	
	int insert(Student student);
	
	int update(Student student);
	
	int delete(Student student);
	
}
