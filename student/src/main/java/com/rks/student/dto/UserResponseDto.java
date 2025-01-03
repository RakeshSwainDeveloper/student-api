package com.rks.student.dto;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;

public class UserResponseDto {

	public Map<String, Object> generateMapResponse(String msg, HttpStatus status, Map<String, Object> responseObj) {
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("status", status.value());
		map.put("message", msg);
		map.put("records", responseObj);
//		return new ResponseEntity<Object>(map, status);
		return map;
	}

}
