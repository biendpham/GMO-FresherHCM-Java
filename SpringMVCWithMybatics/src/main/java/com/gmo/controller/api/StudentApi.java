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
package com.gmo.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gmo.service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentAPI {
	
	@Autowired
	StudentService studentService;
	
	@GetMapping("/generateCode")
	public String generataCode() {
		return studentService.generateCode();
	}
	
}
