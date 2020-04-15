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

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gmo.entity.User;

@Controller
@RequestMapping("/student")
public class StudentController {

	@GetMapping("/list")
	public String displayStudentList(HttpSession session){
		session.setAttribute("USER", new User(1L, "admin", "123456"));
		return "studentList";
	}
	
}
