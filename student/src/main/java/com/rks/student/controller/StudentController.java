package com.rks.student.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

	@GetMapping
	public String getStudents() {
		return "Hello User Welcome to My world";
	}

	@PostMapping("/student_register/{id}/{name}")
	public ResponseEntity<String> student_register(@PathVariable("id") int id, @PathVariable("name") String name) {

		System.out.println("Entering ----------------");
		Integer num = id / 0;

		return new ResponseEntity<>("Success", HttpStatus.OK);

	}
	
	
//	public ResponseEntity<T> 

}
