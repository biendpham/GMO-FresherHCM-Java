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

public class Pageable implements Serializable {

	private static final long serialVersionUID = 9023219599937016568L;
	
	private int pageNum;
	private int pageSize;
	private String search;

	public Pageable() {

	}

	public Pageable(int pageNum, int pageSize, String search) {

		this.pageNum = pageNum;
		this.pageSize = pageSize;
		this.search = search;
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

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	@Override
	public String toString() {
		return "Pageable [pageNum=" + pageNum + ", pageSize=" + pageSize + ", search=" + search + "]";
	}

}
