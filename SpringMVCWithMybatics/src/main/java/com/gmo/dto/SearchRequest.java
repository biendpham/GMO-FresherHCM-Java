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

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class SearchRequest {

	private int pageNum;
	private int pageSize;
	private int totalPages;
	private String code;
	private String name;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthday;

	public SearchRequest() {
		
	}

	public SearchRequest(int pageNum, int pageSize, String code, String name, Date birthday) {
		this.pageNum = pageNum;
		this.pageSize = pageSize;
		this.code = code;
		this.name = name;
		this.birthday = birthday;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "SearchRequest [pageNum=" + pageNum + ", pageSize=" + pageSize + ", code=" + code + ", name=" + name
				+ ", birthday=" + birthday + "]";
	}
	
	public boolean isEmpty() {
		return pageNum == 0 && pageSize == 0 && code == null && name == null && birthday == null;
	}
	
}
