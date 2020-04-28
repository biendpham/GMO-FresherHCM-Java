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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.gmo.controller.AuthenticationController;
import com.gmo.service.UserService;

@RunWith(SpringRunner.class)
@WebMvcTest(AuthenticationController.class)
public class LogoutTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	UserService userService;
	
	@Test
	public void displayLoginPage() throws Exception {
		mvc.perform(get("/logout"))
			.andExpect(status().isFound())
			.andExpect(view().name("redirect:/login"));
//		
//		ResultActions resultActions = mvc.perform(get("/login"));
//		resultActions.andDo(MockMvcResultHandlers.print());
	}

}
