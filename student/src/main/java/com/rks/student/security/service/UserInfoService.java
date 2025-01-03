package com.rks.student.security.service;

import java.util.Map;

import com.rks.student.dto.AuthRequest;
import com.rks.student.dto.UserInfoRequestDto;

public interface UserInfoService {

	Map<String, Object> register_v1_0(UserInfoRequestDto requestDto);

	String signIn_v1_0(AuthRequest authRequest);

}
