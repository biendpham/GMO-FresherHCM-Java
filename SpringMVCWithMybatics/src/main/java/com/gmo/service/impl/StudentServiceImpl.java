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
package com.gmo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gmo.entity.Student;
import com.gmo.mapper.StudentMapper;
import com.gmo.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	StudentMapper studentMapper;

	@Override
	public List<Student> findAll() {
		return studentMapper.findAll();
	}

}
