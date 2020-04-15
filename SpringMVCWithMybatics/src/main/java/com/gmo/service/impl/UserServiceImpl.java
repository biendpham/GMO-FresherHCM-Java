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
package com.gmo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.Transactional;

import com.gmo.entity.User;
import com.gmo.mapper.UserMapper;
import com.gmo.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserMapper userMapper;
	
	@Autowired
	TransactionManager transactionManager;
	
	@Override
	public List<User> findAll() {
		return userMapper.findAll();
	}

	@Override
	public Integer findIdByUsername(User user) {
		return userMapper.findIdByUsername(user.getUserName());
	}

	@Override
	public User findByUsernameAndPassword(User user) {
		return userMapper.findByUsernameAndPassword(user);
	}

	@Override
	@Transactional
	public int insert(User user) {
		if (findIdByUsername(user) != null) {
			return -1;
		}
		try {
			return userMapper.insert(user);
		} catch (Exception e) {
			return 0;
		}
	}

}
