package com.rks.student.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoRequestDto {

	private String userName;
	private String userPassword;
	private String mobileNumer;
	private String userEmail;

}
