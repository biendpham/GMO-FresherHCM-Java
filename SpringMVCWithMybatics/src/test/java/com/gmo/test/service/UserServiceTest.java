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
package com.gmo.test.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.gmo.dto.UserDTO;
import com.gmo.entity.User;
import com.gmo.mapper.UserMapper;
import com.gmo.service.UserService;
import com.gmo.service.impl.UserServiceImpl;
import com.gmo.util.MappingUtil;

@RunWith(SpringRunner.class)
public class UserServiceTest {

	private List<User> listUsers = new ArrayList<>();
	
	@TestConfiguration
	public static class UserServiceTestConfiguration {
		@Bean
		UserService userService() {
			return new UserServiceImpl();
		}
	}
	
	@MockBean
	UserMapper userMapper;
	
	@MockBean
	SqlSessionFactory sqlSessionFactory;
	
	@Autowired
	private UserService userService;

	@Before
	public void setUp() {
		listUsers.add(new User(1, "admin", "password"));
		listUsers.add(new User(2, "admin1", "password1"));
		listUsers.add(new User(3, "admin2", "password2"));
		listUsers.add(new User(4, "admin3", "password3"));
		
		SqlSession ss = Mockito.mock(SqlSession.class);
		userMapper = Mockito.mock(UserMapper.class);
		
		Mockito.when(sqlSessionFactory.openSession()).thenReturn(ss);
		Mockito.when(ss.getMapper(UserMapper.class)).thenReturn(userMapper);
		
	}

	@Test
	public void findAll() {
		Mockito.when(userMapper.findAll()).thenReturn(listUsers);
		Assert.assertEquals(listUsers, userService.findAll());
	}
	
	@Test
	public void findAllThrowException() {
		Mockito.when(userMapper.findAll()).thenThrow(RuntimeException.class);
		Assert.assertEquals(null, userService.findAll());
	}

	@Test
	public void checkFoundIdByUsernameFound() {
		User user = new User();
		user.setUserName("admin");
		Mockito.when(userMapper.findIdByUsername("admin")).thenReturn(1);
		Assert.assertEquals(1, userService.findIdByUsername(user));
	}
	
	@Test
	public void checkNotFoundIdByUsername() {
		User user = new User();
		user.setUserName("admin1");
		Mockito.when(userMapper.findIdByUsername("admin1")).thenReturn(0);
		Assert.assertEquals(0, userService.findIdByUsername(user));
	}
	
	@Test
	public void checkFindIdByUsernameThrowException() {
		User user = new User();
		user.setUserName("admin");
		Mockito.when(userMapper.findIdByUsername("admin")).thenThrow(RuntimeException.class);
		Assert.assertEquals(0, userService.findIdByUsername(user));
	}
	
	@Test
	public void checkFoundUserByUsernameAndPassword() {
		User userIn = new User("admin", "123456");
		User userOut = new User(1, "admin", "123456");
		Mockito.when(userMapper.findByUsernameAndPassword(userIn)).thenReturn(userOut);
		Assert.assertEquals(userOut, userService.findByUsernameAndPassword(userIn));
	}
	
	@Test
	public void checkNotFoundUserByUsernameAndPassword() {
		User userIn = new User("admin1", "123456");
		Mockito.when(userMapper.findByUsernameAndPassword(userIn)).thenReturn(null);
		Assert.assertEquals(null, userService.findByUsernameAndPassword(userIn));
	}
	
	@Test
	public void checkFindUserByUsernameAndPasswordThrowException() {
		User userIn = new User("admin1", "123456");
		Mockito.when(userMapper.findByUsernameAndPassword(userIn)).thenThrow(RuntimeException.class);
		Assert.assertEquals(null, userService.findByUsernameAndPassword(userIn));
	}

	
	@Test
	public void checkInsertWithUsernameExist() {
		try {
			UserDTO userDTO = new UserDTO("admin", "123456", "123456");
			
			Mockito.when(userMapper.findIdByUsername("admin")).thenReturn(1);
			
			Assert.assertEquals(-1, userService.insert(userDTO));
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void checkInsertThrowException() {
		try {
			UserDTO userDTO = new UserDTO("admin", "123456", "123456");
			User user = MappingUtil.mapUser(userDTO);
			
			Mockito.when(userMapper.findIdByUsername("admin")).thenThrow(RuntimeException.class);
			Mockito.when(userMapper.insert(user)).thenReturn(0);
			
			Assert.assertEquals(0, userService.insert(userDTO));
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void checkInsertFail() {
		try {
			UserDTO userDTO = new UserDTO("admin", "123456", "123456");
			User user = MappingUtil.mapUser(userDTO);
			
			Mockito.when(userMapper.findIdByUsername("admin")).thenReturn(0);
			Mockito.when(userMapper.insert(user)).thenReturn(0);
			
			Assert.assertEquals(0, userService.insert(userDTO));
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
	}
	
//	@Test
//	public void checkInsertSuccess() {
//		try {
//			UserDTO userDTO = new UserDTO("admin", "123456", "123456");
//			User user = new User(userDTO);
//			
//			Mockito.when(userMapper.findIdByUsername("admin")).thenReturn(0);
//			Mockito.when(userMapper.insert(user)).thenReturn(1);
//			
//			Assert.assertEquals(1, userService.insert(userDTO));
//		} catch (Exception e) {
//			Assert.assertTrue(false);
//		}
//	}
}

