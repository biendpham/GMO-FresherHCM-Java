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
package com.gmo.mapper;

import java.util.List;

import com.gmo.entity.User;

public interface UserMapper {

	List<User> findAll();
	
	Integer findIdByUsername(String userName);
	
	User findByUsernameAndPassword(User user);
	
	int insert(User user);
	
}
