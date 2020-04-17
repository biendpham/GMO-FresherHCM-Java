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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ContainerNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.pagehelper.Page;
import com.gmo.constant.StatusCode;
import com.gmo.entity.Student;

public class ResponseUtil {
	
	private static ObjectMapper mapper = new ObjectMapper();
	
//	public static String success(String body){
//        ObjectNode node = mapper.createObjectNode();
//        node.put(StatusCode.class.getSimpleName(), StatusCode.SUCCESS.getValue());
//        node.put("Message", StatusCode.SUCCESS.name());
//        node.put("Response", body);
//        return node.toString();
//    }
	
	public static String response(StatusCode statusCode, String body){
        ObjectNode node = mapper.createObjectNode();
        node.put(StatusCode.class.getSimpleName(), statusCode.getValue());
        node.put("Message", statusCode.name());
        node.put("Response", body);
        return node.toString();
    }
	
	public static String response(StatusCode statusCode, ContainerNode body){
        ObjectNode node = mapper.createObjectNode();
        node.put(StatusCode.class.getSimpleName(), statusCode.getValue());
        node.put("Message", statusCode.name());
        node.set("Response", body);
        return node.toString();
    }
	
	public static ObjectNode returnStudent(Student student) {
		ObjectNode node = mapper.createObjectNode();
		
		node.put("id", student.getId());
		node.put("code", student.getCode());
		node.put("name", student.getName());
		node.put("birthday", DatetimeUtil.toString(student.getStudentInfo().getDateOfBirth()));
		node.put("address", student.getStudentInfo().getAddress());
		node.put("score", student.getStudentInfo().getAverageScore());
		
		return node;
	}
	
	public static ObjectNode returnPageStudent(Page<Student> pageStudent) {
		ObjectNode node = mapper.createObjectNode();
		
		node.put("currentPage", pageStudent.getPageNum());
		node.put("totalPages", pageStudent.getPages());
		
		ArrayNode arrayNode = mapper.createArrayNode();
		for (Student student : pageStudent.getResult()) {
			arrayNode.add(returnStudent(student));
		}
		
		node.set("list", arrayNode);
		
		return node;
	}

	public static ObjectNode returnStudentIdInserted(Student student, String message) {
		ObjectNode node = mapper.createObjectNode();
		
		node.put("id", student.getId());
		node.put("message", message);
		
		return node;
	}
	
}
