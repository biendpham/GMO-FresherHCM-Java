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

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.gmo.dto.SearchRequest;
import com.gmo.dto.StudentDTO;
import com.gmo.entity.Student;
import com.gmo.mapper.StudentInfoMapper;
import com.gmo.mapper.StudentMapper;
import com.gmo.service.StudentService;
import com.gmo.util.MappingUtil;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentMapper studentMapper;

	@Autowired
	StudentInfoMapper studentInfoMapper;

	@Autowired
	private SqlSessionFactory sessionFactory;

	@Override
	public Page<Student> findBySearchRequest(SearchRequest searchRequest) {
		if (searchRequest.getPageNum() == 0) {
			searchRequest.setPageNum(1);
			searchRequest.setPageSize(10);
		}
		
		if (searchRequest.getBirthday() == null) {
			return findByNameAndCode(searchRequest);
		} else {
			return findByNameAndCodeAndBirthday(searchRequest);
		}

	}

	@Override
	public Student findById(Integer id) {
		SqlSession session = null;
		try {
			session = sessionFactory.openSession();
			studentMapper = session.getMapper(StudentMapper.class);
			return studentMapper.findById(id);
		} catch (Exception e) {
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public Student findByCode(String code) {
		SqlSession session = null;
		try {
			session = sessionFactory.openSession();
			studentMapper = session.getMapper(StudentMapper.class);
			return studentMapper.findByCode(code);
		} catch (Exception e) {
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public Student insert(StudentDTO studentDTO) {
		Student student = MappingUtil.mapStudent(studentDTO);
		SqlSession session = null;

		try {
			session = sessionFactory.openSession();
			studentMapper = session.getMapper(StudentMapper.class);
			studentInfoMapper = session.getMapper(StudentInfoMapper.class);

			if (studentMapper.insert(student) == 0) {
				throw new Exception();
			}

			student.getStudentInfo().setStudentId(student.getId());
			if (studentInfoMapper.insert(student.getStudentInfo()) == 0) {
				throw new Exception();
			}

			// insert success
			session.commit();
		} catch (Exception e) {
			// insert fail
			student = null;
			session.rollback();
		} finally {
			session.close();
		}

		return student;
	}

	@Override
	public int update(StudentDTO studentDTO) {
		Student student = MappingUtil.mapStudent(studentDTO);
		int updated = 1;
		SqlSession session = null;

		try {
			session = sessionFactory.openSession();
			studentMapper = session.getMapper(StudentMapper.class);
			studentInfoMapper = session.getMapper(StudentInfoMapper.class);

			if (studentMapper.update(student) == 0) {
				throw new Exception();
			}

			student.getStudentInfo().setStudentId(student.getId());
			if (studentInfoMapper.update(student.getStudentInfo()) == 0) {
				throw new Exception();
			}

			// update success
			session.commit();
		} catch (Exception e) {
			// update fail
			updated = 0;
			session.rollback();
		} finally {
			session.close();
		}

		return updated;
	}

	@Override
	public int delete(int id) {
		SqlSession session = null;
		int deleted = 1;

		try {
			session = sessionFactory.openSession();
			studentMapper = session.getMapper(StudentMapper.class);

			if (studentMapper.delete(id) == 0) {
				throw new Exception();
			}

			// delete success
			session.commit();
		} catch (Exception e) {
			// delete fail
			deleted = 0;
			session.rollback();
		} finally {
			session.close();
		}

		return deleted;
	}

	@Override
	public String generateCode() {
		try {
			String prefixCode = "STU";
			int suffixCode = 0;
			String code = "";
			
			do {
				suffixCode = (int) (Math.random()*100000);
				code = prefixCode + suffixCode;
			} while (suffixCode < 10000 || findByCode(prefixCode + suffixCode) != null);
			
			return code;
		} catch (Exception e) {
			return "";
		}
		
	}

	
	private Page<Student> findByNameAndCodeAndBirthday(SearchRequest searchRequest) {
		SqlSession session = null;
		try {
			Student student = MappingUtil.mapStudent(searchRequest);
			
			session = sessionFactory.openSession();
			studentMapper = session.getMapper(StudentMapper.class);
			PageHelper.startPage(searchRequest.getPageNum(), searchRequest.getPageSize());
			return studentMapper.findBySearchRequest(student);
		} catch (Exception e) {
			return null;
		} finally {
			session.close();
		}
	}
	
	private Page<Student> findByNameAndCode(SearchRequest searchRequest) {
		SqlSession session = null;
		try {
			Student student = MappingUtil.mapStudent(searchRequest);
			
			session = sessionFactory.openSession();
			studentMapper = session.getMapper(StudentMapper.class);
			PageHelper.startPage(searchRequest.getPageNum(), searchRequest.getPageSize());
			return studentMapper.findByNameAndCode(student);
		} catch (Exception e) {
			return null;
		} finally {
			session.close();
		}
	}
}
