package com.cognixia.jump.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cognixia.jump.model.Course;
import com.cognixia.jump.repository.CourseRepository;

@RequestMapping("/api")
@RestController
public class CourseController {
	
	@Autowired
	CourseRepository service;

	@GetMapping("/courses")
	public List<Course> getAllCourses() {
		
		return service.findAll();
	}
	
	@GetMapping("/course/{courseId}")
	public Course getCourse(@PathVariable String courseId) {
		
		Optional<Course> courseOpt = service.findById(courseId);
		
		if(courseOpt.isPresent()) {
			return courseOpt.get();
			
		}
		
		return new Course();
	}
	
}
