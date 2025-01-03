package com.rks.student.security.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {

	public String genrateToken(String userName);

	public String extractUserName(String token);

	public Boolean validateToken(String token, UserDetails userDetails);

}
