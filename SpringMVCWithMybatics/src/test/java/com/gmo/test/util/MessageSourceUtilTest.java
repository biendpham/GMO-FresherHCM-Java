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
package com.gmo.test.util;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.test.context.junit4.SpringRunner;

import com.gmo.util.MessageSourceUtil;

@RunWith(SpringRunner.class)
public class MessageSourceUtilTest {

	
	@Before
	public void setUp() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
	    messageSource.setBasename("classpath:messages/messages");
	    messageSource.setDefaultEncoding("UTF-8");
	    
	    MessageSourceUtil.setMessageSource(messageSource);
	}
	
	@Test
	public void testSomdeCode() {
		String fieldMatchCode = "FieldMatch.userDTO.passwordConfirm";
		String maxAverageScoreCode = "Max.student.averageScore";
		
		Assert.assertEquals(MessageSourceUtil.getMessage(fieldMatchCode), "Password Confirm must match Password");
		Assert.assertEquals(MessageSourceUtil.getMessage(maxAverageScoreCode), "Average Score between 0 and 10");
	}
}
