package com.rks.student.security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rks.student.security.service.impl.UserInfoDetails;
import com.rks.student.studentcentraldb.entity.core.UserEntity;
import com.rks.student.studentcentraldb.repository.core.UserEntityRepository;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserEntityRepository userEntityRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserEntity> userInfo = userEntityRepository.findByUserName(username);
		return userInfo.map(UserInfoDetails::new)
				.orElseThrow(() -> new UsernameNotFoundException("UserName not found" + username));
	}

}
