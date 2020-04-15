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
package com.gmo.service;

import java.util.List;

import com.gmo.entity.User;

public interface UserService {
	
	List<User> findAll();
	
	Integer findIdByUsername(User user);
	
	User findByUsernameAndPassword(User user);
	
	int insert(User user);
	
}
