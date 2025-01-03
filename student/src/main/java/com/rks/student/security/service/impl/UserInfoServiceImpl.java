package com.rks.student.security.service.impl;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.rks.student.constant.ServiceCode;
import com.rks.student.dto.AuthRequest;
import com.rks.student.dto.UserInfoRequestDto;
import com.rks.student.security.service.JwtService;
import com.rks.student.security.service.UserInfoService;
import com.rks.student.studentcentraldb.entity.core.UserEntity;
import com.rks.student.studentcentraldb.repository.core.UserEntityRepository;
import com.rks.student.validation.ValidationUtils;

@Service
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	private UserEntityRepository userEntityRepository;

	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	private ValidationUtils validationUtils;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtService jwtService;

//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		Optional<UserEntity> userInfo = userEntityRepository.findByUserName(username);
//		return userInfo.map(UserInfoDetails::new)
//				.orElseThrow(() -> new UsernameNotFoundException("UserName not found" + username));
//	}

	@Override
	public Map<String, Object> register_v1_0(UserInfoRequestDto userInfoDetails) {
		Map<String, Object> response = validationUtils.validateRegister_v1_0(userInfoDetails);
		if (response.size() == 0) {
			Integer nextUserId = userEntityRepository.getNextUserId();
			UserEntity userEntity = new UserEntity();
			userEntity.setUserName(userInfoDetails.getUserName());
			userEntity.setUserPassword(encoder.encode(userInfoDetails.getUserPassword()));
			userEntity.setMobileNumer(userInfoDetails.getMobileNumer());
			userEntity.setIsActive(true);
			userEntity.setAgencyId("" + nextUserId);
			userEntity.setRole("USER");
			userEntity.setUserEmail(userInfoDetails.getUserEmail());
			userEntity.setCreateTime(new Timestamp(Calendar.getInstance().getTimeInMillis()));
			userEntityRepository.save(userEntity);
			response.put(ServiceCode.SVC001.getCode(), ServiceCode.SVC001.getMessage());
		}
		return response;
	}

	@Override
	public String signIn_v1_0(AuthRequest authRequest) {
		Authentication authenticate = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getUserPassword()));
		if (authenticate.isAuthenticated()) {
			return jwtService.genrateToken(authRequest.getUserName());
		} else {
			throw new UsernameNotFoundException("Invalid user request");
		}
	}

}
