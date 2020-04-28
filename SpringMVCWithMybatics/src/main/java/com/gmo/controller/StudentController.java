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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.pagehelper.Page;
import com.gmo.dto.SearchRequest;
import com.gmo.dto.StudentDTO;
import com.gmo.entity.Student;
import com.gmo.service.StudentService;
import com.gmo.util.MessageSourceUtil;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentService studentService;

	@GetMapping("/list")
	public String displayStudentList(Model model, SearchRequest searchRequest, HttpSession session) {
		
		if (searchRequest.isEmpty() && (SearchRequest) session.getAttribute("searchRequest") != null) {
			searchRequest = (SearchRequest) session.getAttribute("searchRequest");
		} else {
			session.setAttribute("searchRequest", searchRequest);
		}

		Page<Student> pageStudents = studentService.findBySearchRequest(searchRequest);
		searchRequest.setTotalPages(pageStudents.getPages());

		model.addAttribute("searchRequest", searchRequest);
		model.addAttribute("students", pageStudents.getResult());
		return "studentList";
	}

	@GetMapping
	public String displayStudentRegister(Model model) {
		model.addAttribute("student", new StudentDTO());
		return "studentRegister-Update";
	}

	@GetMapping("/{id}")
	public String displayStudentUpdate(@PathVariable Integer id, Model model) {
		Student student = studentService.findById(id);
		model.addAttribute("student", new StudentDTO(student));
		return "studentRegister-Update";
	}

	@PostMapping
	public String register(@ModelAttribute("student") @Valid StudentDTO studentDTO, BindingResult result,
			RedirectAttributes redirectAttributes, Model model) {
		if (result.hasErrors()) {
			return "studentRegister-Update";
		}

		Student student = null;
		try {
			student = studentService.insert(studentDTO);
		} catch (Exception e) {
			student = null;
		}

		if (student != null) {
			redirectAttributes.addFlashAttribute("success", true);
			redirectAttributes.addFlashAttribute("message", MessageSourceUtil.getMessage("insert.success"));
			return "redirect:student/" + student.getId();
		} else {
			model.addAttribute("success", false);
			model.addAttribute("message", MessageSourceUtil.getMessage("insert.fail"));
			return "studentRegister-Update";
		}

	}

	@PostMapping("/{id}")
	public String update(@ModelAttribute("student") @Valid StudentDTO studentDTO, BindingResult result,
			@PathVariable Integer id, Model model) {
		if (result.hasErrors()) {
			return "studentRegister-Update";
		}

		int updated = 0;
		try {
			updated = studentService.update(studentDTO);
		} catch (Exception e) {
			updated = 0;
		}

		if (updated != 0) {
			model.addAttribute("success", true);
			model.addAttribute("message", MessageSourceUtil.getMessage("update.success"));
		} else {
			model.addAttribute("success", false);
			model.addAttribute("message", MessageSourceUtil.getMessage("update.fail"));
		}

		return "studentRegister-Update";

	}

	@PostMapping("/delete")
	public String delete(@RequestParam int id, RedirectAttributes redirectAttributes) {

		int deleted = 0;
		try {
			deleted = studentService.delete(id);
		} catch (Exception e) {
			deleted = 0;
		}

		if (deleted != 0) {
			redirectAttributes.addFlashAttribute("success", true);
			redirectAttributes.addFlashAttribute("message", MessageSourceUtil.getMessage("delete.success"));
		} else {
			redirectAttributes.addFlashAttribute("success", false);
			redirectAttributes.addFlashAttribute("message", MessageSourceUtil.getMessage("delete.fail"));
		}

		return "redirect:/student/list";
	}

}
