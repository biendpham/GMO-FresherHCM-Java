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

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/authentication")
public class AuthenticationController {
	
	@GetMapping("/login")
	public String displayLoginPage(){
		return "login";
	}
	
	@GetMapping("/register")
	public String displayRegisterPage(){
		return "register";
	}
	
}
