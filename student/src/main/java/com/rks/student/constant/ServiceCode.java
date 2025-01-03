package com.rks.student.constant;

public enum ServiceCode {

	SVC001("SVC001", "Your request has been processed successfully."),
	SVC002("SVC002", "Invalid details, Please provide valid details."),
	SVC003("SVC003", "Invalid identifier, Please provide a valid identifier."),
	SVC004("SVC004",
			"User name sould not be null or empty and must be grater than length of 5 and special charecter not allowed"),
	SVC005("SVC005",
			"password must be one Upper latter, at leat one disit, at least one special charecter, length greater than 5"),
	SVC006("SVC006", "Enter a valid mobile number"),
	SVC007("SVC007", "Enter a valid EmailID"),

	SVC098("SVC098", "No Record(s) found."), SVC099("SVC099", "Service is unavaulable, please try later."),
	SVC100("SVC100", "Unexpected error.");

	String code;
	String message;

	private ServiceCode(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
