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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.gmo.entity.Pageable;
import com.gmo.entity.Student;
import com.gmo.mapper.StudentInfoMapper;
import com.gmo.mapper.StudentMapper;
import com.gmo.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	StudentMapper studentMapper;
	
	@Autowired
	StudentInfoMapper studentInfoMapper;

	@Override
	public Page<Student> findByName(Pageable pageable) {
		PageHelper.startPage(pageable.getPageNum(), 10);
		return studentMapper.findByName(pageable.getSearch());
	}

	@Override
	public Student findById(Integer id) {
		return studentMapper.findById(id);
	}

	@Override
	public int insert(Student student) {
		if (studentMapper.insert(student) == 0 ) {
			return 0;
		}

		student.getStudentInfo().setStudent_id(student.getId());
		if (studentInfoMapper.insert(student.getStudentInfo()) == 0 ) {
			return 0;
		}
		
		return 1;
	}
	
	@Override
	public int update(Student student) {
		if (studentMapper.update(student) == 0 ) {
			return 0;
		}

		if (studentInfoMapper.update(student.getStudentInfo()) == 0 ) {
			return 0;
		}
		
		return 1;
	}

	@Override
	public int delete(Student student) {
		return studentMapper.delete(student);
	}

}
