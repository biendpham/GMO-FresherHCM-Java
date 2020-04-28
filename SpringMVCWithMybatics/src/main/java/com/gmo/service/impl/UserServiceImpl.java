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

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gmo.dto.UserDTO;
import com.gmo.entity.User;
import com.gmo.mapper.UserMapper;
import com.gmo.service.UserService;
import com.gmo.util.MappingUtil;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private SqlSessionFactory sessionFactory;

	@Override
	public List<User> findAll() {
		SqlSession session = null;
		try {
			session = sessionFactory.openSession();
			userMapper = session.getMapper(UserMapper.class);
			return userMapper.findAll();
		} catch (Exception e) {
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public int findIdByUsername(User user) {
		SqlSession session = null;
		try {
			session = sessionFactory.openSession();
			userMapper = session.getMapper(UserMapper.class);
			return userMapper.findIdByUsername(user.getUserName());
		} catch (Exception e) {
			return 0;
		} finally {
			session.close();
		}
	}

	@Override
	public User findByUsernameAndPassword(User user) {
		SqlSession session = null;
		try {
			session = sessionFactory.openSession();
			userMapper = session.getMapper(UserMapper.class);
			return userMapper.findByUsernameAndPassword(user);
		} catch (Exception e) {
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public int insert(UserDTO userDTO) {
		int inserted = 1;
		User user = MappingUtil.mapUser(userDTO);
		
		if (findIdByUsername(user) != 0) {
			// username already exists
			inserted = -1;
		} else {
			SqlSession session = null;
			try {
				session = sessionFactory.openSession();
				userMapper = session.getMapper(UserMapper.class);
				
				inserted = userMapper.insert(user);
				
				//insert success
				session.commit();
			} catch (Exception e) {
				//insert fail
				inserted = 0;
				session.rollback();
			} finally {
				session.close();
			}
		}

		return inserted;
	}

}
