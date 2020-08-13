package com.cognixia.jump.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cognixia.jump.model.Course;
import com.cognixia.jump.model.Student;
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
	
	@GetMapping("/course/department/{department}")
	public List<Course> getCourseByDepartment(@PathVariable String department) {
		
		List<Course> coursesInDepartment = new ArrayList<>();
		
		for(int i = 0; i < studentDatabase.size(); i++) {
			
			// validation to ignore casing and trim whitespace
			if(studentDatabase.get(i).getMajor().equalsIgnoreCase(major.trim())) {
				
				studentsInMajor.add(studentDatabase.get(i));
				
			}
		}
		
		return studentsInMajor;

	}
	
	
	@GetMapping("/course/{studendId}")
	
	@PostMapping("/add/student")
	public void addStudent(@RequestBody Student newStudent) {
		
		// to know that nobody should have this Id
		// check before you update a student to know
		// we are properly doing an add
		newStudent.setId(-1L);
		
		// makes sure new student is added in
		// returns student
		Student added = service.save(newStudent);
		System.out.println("Added: " + added);
	}
	
	@DeleteMapping("/delete/student/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable long id) {
		
		Optional<Student> found = service.findById(id);
		
		if(found.isPresent()) {
			
			service.deleteById(id);

			return ResponseEntity.status(200).body("Deleted student with id = "
					+ id);
		} else {
			return ResponseEntity.status(400)
					.header("student id", id + "")
					.body("Student with id = " + id + " not found");
		}
		
		
	}
	
}
