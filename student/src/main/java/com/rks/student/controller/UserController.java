package com.rks.student.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rks.student.constant.ServiceCode;
import com.rks.student.dto.AuthRequest;
import com.rks.student.dto.UserInfoRequestDto;
import com.rks.student.dto.UserResponseDto;
import com.rks.student.security.service.UserInfoService;
import com.rks.student.util.StringUtils;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/auth")
@Slf4j
public class UserController {

	@Autowired
	private UserInfoService userInfoService;

	@PostMapping("/register/v1.0")
	public ResponseEntity<Map<String, Object>> register_v1_0(@RequestBody UserInfoRequestDto requestDto) {
		log.info("Enterring into onboard_v1_0 with request: {}", requestDto);
		Map<String, Object> responseObj = new HashMap<>();
//		Map<String, Object> response = new HashMap<>();
		UserResponseDto responseDto = new UserResponseDto();

		try {
			if (StringUtils.isValidObj(responseObj)) {
				responseObj = userInfoService.register_v1_0(requestDto);
			} else {
				ServiceCode serviceCode = ServiceCode.SVC002;
				responseObj.put(serviceCode.getCode(), serviceCode.getMessage());
			}

		} finally {
			responseObj = responseDto.generateMapResponse("Success", HttpStatus.OK, responseObj);
		}
		return ResponseEntity.ok(responseObj);

	}

	@PostMapping("/signIn/v1.0")
	public ResponseEntity<String> signIn_v1_0(@RequestBody AuthRequest authRequest) {
		String token = userInfoService.signIn_v1_0(authRequest);
		return ResponseEntity.ok(token);
	}

}
