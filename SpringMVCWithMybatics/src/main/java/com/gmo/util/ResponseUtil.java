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
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.gmo.constant.StatusCode;

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

}
