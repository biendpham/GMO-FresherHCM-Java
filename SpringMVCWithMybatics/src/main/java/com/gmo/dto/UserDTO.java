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
package com.gmo.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.gmo.dto.validator.FieldMatch;

@FieldMatch(first = "passwordConfirm", second = "password", message = "{FieldMatch.userDTO.passwordConfirm}")
public class UserDTO implements Serializable{

	private static final long serialVersionUID = 3480935673640543783L;
	
	@NotBlank(message = "{NotBlank.user.userName}")
	@Size(max = 20, message = "{Size.user.userName}")
	@Pattern(regexp = "^[a-z0-9]+$", message = "{Pattern.user.userName}")
	private String userName;
	
	@NotBlank(message = "{NotBlank.user.password}")
	@Size(min = 6, max=15, message = "{Size.user.password}")
	@Pattern(regexp = "^[a-z0-9]+$", message = "{Pattern.user.password}")
	private String password;
	
	@NotBlank(message = "{NotBlank.user.passwordConfirm}")
	@Size(min = 6, max=15, message = "{Size.user.passwordConfirm}")
	@Pattern(regexp = "^[a-z0-9]+$", message = "{Pattern.user.passwordConfirm}")
	private String passwordConfirm;
	
	public UserDTO() {
	}

	public UserDTO(String userName, String password, String passwordConfirm) {
		this.userName = userName;
		this.password = password;
		this.passwordConfirm = passwordConfirm;
	}
	
	public UserDTO(String userName, String password) {
		this.userName = userName;
		this.password = password;
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

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	@Override
	public String toString() {
		return "UserDTO [userName=" + userName + ", password=" + password + ", passwordConfirm="
				+ passwordConfirm + "]";
	}
	
	
}
