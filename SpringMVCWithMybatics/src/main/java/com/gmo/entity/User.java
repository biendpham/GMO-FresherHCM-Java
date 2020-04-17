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
package com.gmo.entity;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class User implements Serializable{

	private static final long serialVersionUID = 3281891635852813542L;

	private Long id;
	
	@NotBlank
	@Size(max = 20)
	@Pattern(regexp = "^[a-z0-9]+$")
	private String userName;
	
	@NotBlank
	@Size(min = 6, max=20)
	@Pattern(regexp = "^[a-z0-9]+$")
	private String password;
	
	public User() {
	}

	public User(Long id, String userName, String password) {
		this.id = id;
		this.userName = userName;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + password + "]";
	}
	
}
