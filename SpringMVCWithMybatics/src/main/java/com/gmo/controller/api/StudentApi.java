/*
 * Copyright (C) 2020 by GMO Runsystem Company
 *
 * Create class StudentApi
 *
 * @version 1.0
 * 
 * @author BienPD
 *
 */
package com.gmo.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;
import com.gmo.constant.StatusCode;
import com.gmo.entity.Pageable;
import com.gmo.entity.Student;
import com.gmo.service.StudentService;
import com.gmo.util.ResponseUtil;

@RestController
@RequestMapping("/api/student")
public class StudentApi {

	@Autowired
	StudentService studentService;

	@GetMapping(value = "/{id}", produces = "application/json; charset=UTF-8")
	public String findById(@PathVariable Integer id) {
		Student student = studentService.findById(id);
		return ResponseUtil.response(StatusCode.SUCCESS, ResponseUtil.returnStudent(student));
	}

	@PostMapping(value = "/findByName", produces = "application/json; charset=UTF-8")
	public String findByName(@RequestBody Pageable pageable) {
		Page<Student> pageStudent = studentService.findByName(pageable);
		return ResponseUtil.response(StatusCode.SUCCESS, ResponseUtil.returnPageStudent(pageStudent));
	}

	@PostMapping(produces = "application/json; charset=UTF-8")
	public String insert(@RequestBody Student student) {
		if (studentService.insert(student) == 0) {
			return ResponseUtil.response(StatusCode.CANNOT_INSERTED, "Thêm sinh viên thất bại");
		} else {
			return ResponseUtil.response(StatusCode.SUCCESS, 
					ResponseUtil.returnStudentIdInserted(student, "Thêm sinh viên thành công"));
		}
	}

	@PutMapping(produces = "application/json; charset=UTF-8")
	public String update(@RequestBody Student student) {
		if (studentService.update(student) == 0) {
			return ResponseUtil.response(StatusCode.CANNOT_INSERTED, "Cập nhật sinh viên thất bại");
		} else {
			return ResponseUtil.response(StatusCode.SUCCESS, "Cập nhật sinh viên thành công");
		}
	}
	
	@DeleteMapping(produces = "application/json; charset=UTF-8")
	public String delete(@RequestBody Student student) {
		if (studentService.delete(student) == 0) {
			return ResponseUtil.response(StatusCode.CANNOT_INSERTED, "Xóa sinh viên thất bại");
		} else {
			return ResponseUtil.response(StatusCode.SUCCESS, "Xóa sinh viên thành công");
		}
	}

}
