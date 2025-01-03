package com.rks.student.validation;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.rks.student.constant.ServiceCode;
import com.rks.student.dto.UserInfoRequestDto;
import com.rks.student.util.StringUtils;

@Component
public class ValidationUtils {

	public Map<String, Object> validateRegister_v1_0(UserInfoRequestDto userInfoDetails) {
		Map<String, Object> validate = new HashMap<>();
		if (!StringUtils.isValidObj(userInfoDetails.getUserName()) || StringUtils.isEmpty(userInfoDetails.getUserName())
				|| !StringUtils.matchPattern("[A-Za-z_0-9]{6,}", userInfoDetails.getUserName())) {
			validate.put(ServiceCode.SVC004.getCode(), ServiceCode.SVC004.getMessage());
		}
		if (!StringUtils.isValidObj(userInfoDetails.getUserPassword())
				|| StringUtils.isEmpty(userInfoDetails.getUserPassword())
				|| !StringUtils.matchPattern("(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{6,}",
						userInfoDetails.getUserPassword())) {
			validate.put(ServiceCode.SVC005.getCode(), ServiceCode.SVC005.getMessage());
		}
//		if (StringUtils.isEmpty(userInfoDetails.getMobileNumer())) {
//			validate.put(ServiceCode.SVC006.getCode(), ServiceCode.SVC006.getMessage());
//		}
		if (!StringUtils.isValidObj(userInfoDetails.getUserEmail())
				|| StringUtils.isEmpty(userInfoDetails.getUserEmail())
				|| !StringUtils.matchPattern("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}",
						userInfoDetails.getUserEmail())) {
			validate.put(ServiceCode.SVC006.getCode(), ServiceCode.SVC006.getMessage());
		}
		return validate;
	}

}
