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
package com.gmo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
public class MessageSourceUtil {

	private static MessageSource messageSource;

	@Autowired
	public MessageSourceUtil(MessageSource messageSource) {
		MessageSourceUtil.messageSource = messageSource;
	}

	public static void setMessageSource(MessageSource messageSource) {
		MessageSourceUtil.messageSource = messageSource;
	}
	
	public static String getMessage(String code) {
		return messageSource.getMessage(code, null, LocaleContextHolder.getLocale());
	}

}
