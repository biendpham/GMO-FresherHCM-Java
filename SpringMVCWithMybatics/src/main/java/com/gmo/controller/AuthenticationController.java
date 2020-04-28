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
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gmo.dto.UserDTO;
import com.gmo.entity.User;
import com.gmo.service.UserService;
import com.gmo.util.MessageSourceUtil;

@Controller
public class AuthenticationController {

	@Autowired
	UserService userService;

	@GetMapping("/login")
	public String displayLoginPage(Model model) {
		model.addAttribute("user", new User());
		return "login";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("USER");
		return "redirect:/login";
	}

	@PostMapping("/login")
	public String login(@ModelAttribute("user") @Valid User userInput, BindingResult result, Model model, HttpSession session, 
							RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			return "login";
		}

		User user = userService.findByUsernameAndPassword(userInput);
		if (user == null) {
			model.addAttribute("success", false);
			model.addAttribute("message", MessageSourceUtil.getMessage("user.notfound"));
			model.addAttribute("user", userInput);
			return "login";
		} else {
			session.setAttribute("USER", user);
			redirectAttributes.addFlashAttribute("success", true);
			redirectAttributes.addFlashAttribute("message", MessageSourceUtil.getMessage("user.found"));
			return "redirect:/student/list";
		}

	}

	@GetMapping("/register")
	public String displayRegisterPage(Model model) {
		model.addAttribute("user", new UserDTO());
		return "register";
	}

	@PostMapping("/register")
	public String register(@ModelAttribute("user") @Valid UserDTO userDTO, BindingResult result, Model model) throws Exception {
		if (result.hasErrors()) {
			return "register";
		}

		int inserted = 0;
		try {
			inserted = userService.insert(userDTO);
		} catch (Exception e) {
			inserted = 0;
		}

		if (inserted == -1) {
			// username already exists
			model.addAttribute("user", userDTO);
			model.addAttribute("success", false);
			model.addAttribute("message", MessageSourceUtil.getMessage("user.userNameExist"));
			return "register";
		} else if (inserted == 0) {
			// registration failed
			model.addAttribute("user", userDTO);
			model.addAttribute("success", false);
			model.addAttribute("message", MessageSourceUtil.getMessage("user.registration.fail"));
			return "register";
		} else {
			// success
			model.addAttribute("user", userDTO);
			model.addAttribute("success", true);
			model.addAttribute("message", MessageSourceUtil.getMessage("user.registration.success"));
			return "login";
		}

	}

}
