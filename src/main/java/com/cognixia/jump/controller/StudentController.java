package com.cognixia.jump.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognixia.jump.model.Student;
import com.cognixia.jump.repository.StudentRepository;

@RequestMapping("/api")
@RestController
public class StudentController {
	
	@Autowired
	StudentRepository service;
	
	@GetMapping("/students")
	public List<Student> getAllStudents(){
		return service.findAll();
	}
	
	@GetMapping("/students/usernames")
	public List<String> getAllUsernames(){
		List<String> usernames = service.getUsernames();
		
		return usernames;


}
}