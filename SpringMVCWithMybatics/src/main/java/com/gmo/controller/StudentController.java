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
package com.gmo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gmo.entity.Student;
import com.gmo.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@GetMapping("/list")
	public String displayStudentList(){
		return "studentList";
	}
	
	@GetMapping("/{id}")
	public String displayStudentUpdate(@PathVariable Integer id, HttpServletRequest request){
		request.setAttribute("student", studentService.findById(id));
		return "studentRegister-Update";
	}
	
	@GetMapping()
	public String displayStudentRegister(HttpServletRequest request){
		request.setAttribute("student", new Student());
		return "studentRegister-Update";
	}
	
}
