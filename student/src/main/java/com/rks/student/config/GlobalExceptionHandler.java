package com.rks.student.config;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.rks.student.dto.ErrorDetails;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<ErrorDetails> handeleNullPonterException(NullPointerException ex) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), "Null value encounted!!", ex.getMessage());
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(IndexOutOfBoundsException.class)
	public ResponseEntity<ErrorDetails> handeleIndexOutOfBoundException(IndexOutOfBoundsException ex) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), "Invalid Index accessed!!", ex.getMessage());
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ArithmeticException.class)
	public ResponseEntity<ErrorDetails> handleArithemeticException(ArithmeticException ex) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), "invalid Arithemetic Operation!!", ex.getMessage());
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handeleGlobalException(Exception ex) {
		ex.printStackTrace();
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), "Unexpected Error Occurres!!");
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
