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

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gmo.constant.StatusCode;
import com.gmo.entity.User;
import com.gmo.service.UserService;
import com.gmo.util.ResponseUtil;

@RestController
@RequestMapping("/api/user")
public class UserApi {

	@Autowired
	UserService userService;
	
	@GetMapping("/findAll")
	public List<User> findAll(){
		return userService.findAll();
	}
	
	@PostMapping(value = "/login", produces = "application/json; charset=UTF-8")
	public String login(@Valid @RequestBody User user, HttpSession session) {
		user = userService.findByUsernameAndPassword(user);
		if (user != null) {
			session.setAttribute("USER", user);
			return ResponseUtil.response(StatusCode.SUCCESS, "Đăng nhập thành công");
		} else {
			return ResponseUtil.response(StatusCode.NOT_FOUND, "Sai tài khoản hoặc mật khẩu");
		}
	}
	
	@PostMapping(produces = "application/json; charset=UTF-8")
	public String register(@Valid @RequestBody User user) {
		int result = userService.insert(user);
		if (result == -1) {
			return ResponseUtil.response(StatusCode.BAD_REQUEST, "Tên đăng nhập đã tồn tại");
		} else if (result != 0){
			return ResponseUtil.response(StatusCode.SUCCESS, "Đăng ký thành công");
		} else {
			return ResponseUtil.response(StatusCode.CANNOT_INSERTED, "Vui lòng kiểm tra lại");
		}
	}
}
