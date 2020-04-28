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
package com.gmo.test.controller.authentication;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.flash;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.MessageSource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.gmo.controller.AuthenticationController;
import com.gmo.entity.User;
import com.gmo.service.UserService;
import com.gmo.util.MessageSourceUtil;

@RunWith(SpringRunner.class)
@WebMvcTest(AuthenticationController.class)
public class LoginTest {

	@Autowired
	private MockMvc mvc;
	
	@Autowired
	MessageSource messageSource;

	@MockBean
	UserService userService;
	
	@Before
	public void setUp() {
		MessageSourceUtil.setMessageSource(messageSource);
	}

	@Test
	public void displayLoginPage(){
		try {
			mvc.perform(get("/login"))
			.andExpect(status().isOk())
			.andExpect(view().name("login"))
			.andExpect(model().attributeExists("user"));
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
		
	}
	
	@Test
	public void notSendData() {
		try {
			mvc.perform(post("/login"))
			.andExpect(status().isOk())
			.andExpect(view().name("login"))
			.andExpect(model().attributeExists("user"));
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
		
	}
	
	@Test
	public void checkBlankUsername() {
		User user = new User("", "123456");
		try {
			mvc.perform(post("/login").flashAttr("user", user))
			.andExpect(status().isOk())
			.andExpect(view().name("login"))
			.andExpect(model().attribute("user", user));
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
		
	}
	
	@Test
	public void checkBlankPassword() {
		User user = new User("admin", "");
		try {
			mvc.perform(post("/login").flashAttr("user", user))
			.andExpect(status().isOk())
			.andExpect(view().name("login"))
			.andExpect(model().attribute("user", user));
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
		
	}
	
	@Test
	public void checkUsernameLongerThanMaxlength() {
		User user = new User("123456789012345678901", "123456");
		try {
			mvc.perform(post("/login").flashAttr("user", user))
			.andExpect(status().isOk())
			.andExpect(view().name("login"))
			.andExpect(model().attribute("user", user));
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
		
	}
	
	@Test
	public void checkPasswordLongerThanMaxlength() {
		User user = new User("admin", "1234567890123456");
		try {
			mvc.perform(post("/login").flashAttr("user", user))
			.andExpect(status().isOk())
			.andExpect(view().name("login"))
			.andExpect(model().attribute("user", user));
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
		
	}
	
	@Test
	public void checkPasswordShorterThanMinlength() {
		User user = new User("admin", "12345");
		try {
			mvc.perform(post("/login").flashAttr("user", user))
			.andExpect(status().isOk())
			.andExpect(view().name("login"))
			.andExpect(model().attribute("user", user));
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
		
	}
	
	@Test
	public void checkUsernameNotMatchPattern() {
		User user = new User("adminâ", "12345");
		try {
			mvc.perform(post("/login").flashAttr("user", user))
			.andExpect(status().isOk())
			.andExpect(view().name("login"))
			.andExpect(model().attribute("user", user));
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
		
	}
	
	@Test
	public void checkPasswordNotMatchPattern() {
		User user = new User("admin", "12345â");
		try {
			mvc.perform(post("/login").flashAttr("user", user))
			.andExpect(status().isOk())
			.andExpect(view().name("login"))
			.andExpect(model().attribute("user", user));
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
		
	}
	
	@Test
	public void checkWrongUsername() {
		User user = new User("admin", "123456");
		try {
			Mockito.when(userService.findByUsernameAndPassword(user)).thenReturn(null);
		
			mvc.perform(post("/login").flashAttr("user", user))
			.andExpect(status().isOk())
			.andExpect(view().name("login"))
			.andExpect(model().attribute("user", user))
			.andExpect(model().attribute("success", false))
			.andExpect(model().attribute("message", "User Name or Password is invalid"));
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
		
	}
	
	@Test
	public void checkWrongPassword() {
		User user = new User("adminadmin", "1234567");
		try {
			Mockito.when(userService.findByUsernameAndPassword(user)).thenReturn(null);
		
			mvc.perform(post("/login").flashAttr("user", user))
			.andExpect(status().isOk())
			.andExpect(view().name("login"))
			.andExpect(model().attribute("user", user))
			.andExpect(model().attribute("success", false))
			.andExpect(model().attribute("message", "User Name or Password is invalid"));
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
		
	}
	
	@Test
	public void loginSuccess() {
		User user = new User("admin", "123456");
		try {
			Mockito.when(userService.findByUsernameAndPassword(user)).thenReturn(user);
		
			mvc.perform(post("/login").flashAttr("user", user))
			.andExpect(status().isFound())
			.andExpect(redirectedUrl("/student/list"))
			.andExpect(flash().attribute("success", true))
			.andExpect(flash().attribute("message", "Login successful"));
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
		
	}
//
//	public static String requestBody(Object request) {
//		try {
//			return MAPPER.writeValueAsString(request) + ";";
//		} catch (JsonProcessingException e) {
//			throw new RuntimeException(e);
//		}
//	}
	
}
