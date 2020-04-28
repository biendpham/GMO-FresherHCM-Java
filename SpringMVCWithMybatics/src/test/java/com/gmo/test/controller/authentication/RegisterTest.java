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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
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
import com.gmo.dto.UserDTO;
import com.gmo.service.UserService;
import com.gmo.util.MessageSourceUtil;

@RunWith(SpringRunner.class)
@WebMvcTest(AuthenticationController.class)
public class RegisterTest {

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
	public void displayRegisterPage(){
		try {
			mvc.perform(get("/register"))
			.andExpect(status().isOk())
			.andExpect(view().name("register"))
			.andExpect(model().attributeExists("user"));
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
		
	}
	
	@Test
	public void notSendData() {
		try {
			mvc.perform(post("/register"))
			.andExpect(status().isOk())
			.andExpect(view().name("register"))
			.andExpect(model().attributeExists("user"));
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
		
	}
	
	@Test
	public void checkBlankUsername() {
		UserDTO userDTO = new UserDTO("", "123456", "123456");
		try {
			mvc.perform(post("/register").flashAttr("user", userDTO))
			.andExpect(status().isOk())
			.andExpect(view().name("register"))
			.andExpect(model().attribute("user", userDTO));
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
		
	}
	
	@Test
	public void checkBlankPassword() {
		UserDTO userDTO = new UserDTO("admin", "", "123456");
		try {
			mvc.perform(post("/register").flashAttr("user", userDTO))
			.andExpect(status().isOk())
			.andExpect(view().name("register"))
			.andExpect(model().attribute("user", userDTO));
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
		
	}
	
	@Test
	public void checkBlankPasswordConfirm() {
		UserDTO userDTO = new UserDTO("admin", "123456", "");
		try {
			mvc.perform(post("/register").flashAttr("user", userDTO))
			.andExpect(status().isOk())
			.andExpect(view().name("register"))
			.andExpect(model().attribute("user", userDTO));
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
		
	}
	
	@Test
	public void checkUsernameLongerThanMaxlength() {
		UserDTO userDTO = new UserDTO("123456789012345678901", "123456", "123456");
		try {
			mvc.perform(post("/register").flashAttr("user", userDTO))
			.andExpect(status().isOk())
			.andExpect(view().name("register"))
			.andExpect(model().attribute("user", userDTO));
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
		
	}
	
	@Test
	public void checkPasswordLongerThanMaxlength() {
		UserDTO userDTO = new UserDTO("admin", "1234567890123456", "123456");
		try {
			mvc.perform(post("/register").flashAttr("user", userDTO))
			.andExpect(status().isOk())
			.andExpect(view().name("register"))
			.andExpect(model().attribute("user", userDTO));
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
		
	}
	
	@Test
	public void checkPasswordConfirmLongerThanMaxlength() {
		UserDTO userDTO = new UserDTO("admin", "123456", "1234567890123456");
		try {
			mvc.perform(post("/register").flashAttr("user", userDTO))
			.andExpect(status().isOk())
			.andExpect(view().name("register"))
			.andExpect(model().attribute("user", userDTO));
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
		
	}
	
	@Test
	public void checkPasswordShorterThanMinlength() {
		UserDTO userDTO = new UserDTO("admin", "12345", "123456");
		try {
			mvc.perform(post("/register").flashAttr("user", userDTO))
			.andExpect(status().isOk())
			.andExpect(view().name("register"))
			.andExpect(model().attribute("user", userDTO));
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
		
	}
	
	@Test
	public void checkPasswordConfirmShorterThanMinlength() {
		UserDTO userDTO = new UserDTO("admin", "123456", "12345");
		try {
			mvc.perform(post("/register").flashAttr("user", userDTO))
			.andExpect(status().isOk())
			.andExpect(view().name("register"))
			.andExpect(model().attribute("user", userDTO));
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
		
	}
	
	@Test
	public void checkUsernameNotMatchPattern() {
		UserDTO userDTO = new UserDTO("adminâ", "12345", "123456");
		try {
			mvc.perform(post("/register").flashAttr("user", userDTO))
			.andExpect(status().isOk())
			.andExpect(view().name("register"))
			.andExpect(model().attribute("user", userDTO));
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
		
	}
	
	@Test
	public void checkPasswordNotMatchPattern() {
		UserDTO userDTO = new UserDTO("admin", "12345â", "123456");
		try {
			mvc.perform(post("/register").flashAttr("user", userDTO))
			.andExpect(status().isOk())
			.andExpect(view().name("register"))
			.andExpect(model().attribute("user", userDTO));
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
		
	}

	@Test
	public void checkPasswordConfirmNotMatchPattern() {
		UserDTO userDTO = new UserDTO("admin", "123456", "123456â");
		try {
			mvc.perform(post("/register").flashAttr("user", userDTO))
			.andExpect(status().isOk())
			.andExpect(view().name("register"))
			.andExpect(model().attribute("user", userDTO));
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
		
	}

	@Test
	public void checkPasswordConfirmNotMatchPassword() {
		UserDTO userDTO = new UserDTO("admin", "123456", "1234567");
		try {
			mvc.perform(post("/register").flashAttr("user", userDTO))
			.andExpect(status().isOk())
			.andExpect(view().name("register"))
			.andExpect(model().attribute("user", userDTO));
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
		
	}
	
	@Test
	public void checkUsernameAlreadyExist() {
		UserDTO userDTO = new UserDTO("admin", "123456", "123456");
		try {
			Mockito.when(userService.insert(userDTO)).thenReturn(-1);
		
			mvc.perform(post("/register").flashAttr("user", userDTO))
			.andExpect(status().isOk())
			.andExpect(view().name("register"))
			.andExpect(model().attribute("user", userDTO))
			.andExpect(model().attribute("success", false))
			.andExpect(model().attribute("message", "Username already exists"));
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
		
	}
	
	@Test
	public void checkInsertFailed() {
		UserDTO userDTO = new UserDTO("admin1", "123456", "123456");
		try {
			Mockito.when(userService.insert(userDTO)).thenReturn(0);
		
			mvc.perform(post("/register").flashAttr("user", userDTO))
			.andExpect(status().isOk())
			.andExpect(view().name("register"))
			.andExpect(model().attribute("user", userDTO))
			.andExpect(model().attribute("success", false))
			.andExpect(model().attribute("message", "Registration failed, please check again"));
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
		
	}
	
	@Test
	public void checkInsertThrowException() {
		UserDTO userDTO = new UserDTO("admin1", "123456", "123456");
		try {
			Mockito.when(userService.insert(userDTO)).thenThrow(Exception.class);
		
			mvc.perform(post("/register").flashAttr("user", userDTO))
			.andExpect(status().isOk())
			.andExpect(view().name("register"))
			.andExpect(model().attribute("user", userDTO))
			.andExpect(model().attribute("success", false))
			.andExpect(model().attribute("message", "Registration failed, please check again"));
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
		
	}
	
	@Test
	public void registerSuccess() {
		UserDTO userDTO = new UserDTO("admin1", "123456", "123456");
		try {
			Mockito.when(userService.insert(userDTO)).thenReturn(1);
		
			mvc.perform(post("/register").flashAttr("user", userDTO))
			.andExpect(status().isOk())
			.andExpect(view().name("login"))
			.andExpect(model().attribute("user", userDTO))
			.andExpect(model().attribute("success", true))
			.andExpect(model().attribute("message", "Registration successful"));
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
		
	}
	
}
