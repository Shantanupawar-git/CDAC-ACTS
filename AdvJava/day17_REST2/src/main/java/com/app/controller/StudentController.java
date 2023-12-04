package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.StudentDTO;
import com.app.service.StudentService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	private StudentService studentService;

	public StudentController() {
		System.out.println("Hello,"+getClass());
	}
	
	@PostMapping
	public ResponseEntity<?> addNewStudent(
			@RequestBody StudentDTO dto){
		System.out.println("in add student"+dto);
		try {
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(studentService.addStudentDetails(dto));
		}
		catch(RuntimeException e){
			System.out.println("err"+e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(studentService.addStudentDetails(dto));
		}
		
	}
	
}
