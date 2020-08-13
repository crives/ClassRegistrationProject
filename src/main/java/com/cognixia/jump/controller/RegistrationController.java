package com.cognixia.jump.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognixia.jump.exception.CourseAlreadyAddedException;
import com.cognixia.jump.exception.ResourceNotFoundException;
import com.cognixia.jump.model.Registration;
import com.cognixia.jump.repository.RegistrationRepository;

@RequestMapping("/api")
@RestController
public class RegistrationController {
	
	@Autowired
	RegistrationRepository service;
	
	@GetMapping("/Registration")
	public List<Registration> getAllRegistrations() {
		  
		return service.findAll();
	} 
	
	@GetMapping("/Registration/{studentId}")
	public List<Registration> getRegistrationByStudentId(@PathVariable long studentId) throws Exception{
		
		Optional<List<Registration>> optional = service.findByStudentId(studentId);
		 
		if(optional.get().isEmpty()) {
			throw new ResourceNotFoundException("Registration with studentId = " + studentId + " not found");
		}
		else return optional.get();
		 
		//return new Student();
	}
	
	@PostMapping("/Registration/add")
	public void addStudent(@RequestBody Registration newRegistration) throws CourseAlreadyAddedException{
		Optional<Registration> studentclasses = service.findByStudentIdAndCourseId(newRegistration.getStudentId(), newRegistration.getCourseId());
		if(!studentclasses.isEmpty())
			throw new CourseAlreadyAddedException("Course " + newRegistration.getName() + " is already added to your schedule");		
				
			else {
			Registration added = service.save(newRegistration); // save() does an insert or update (depends on id passed)
			System.out.println("Added: " + added);
			}
		
	}
	


//	@DeleteMapping("/delete/Registration")
//	public ResponseEntity<String> deleteStudent(@RequestBody Map<String, String> registrationInfo) throws Exception {
//	 	
//		long studentId = Long.parseLong( registrationInfo.get("studentId") );
//		String courseId = registrationInfo.get("courseId");
//		
//		Registration registration = service.findByStudentIDandCourseID(studentId, courseId);
//		
//		if(registration!=null) {
//			service.deleteByStudentIDandCourseID(studentId, courseId);
//			
//			return ResponseEntity.status(200).body("Deleted registration with studentiId = " + studentId + " and courseId" + courseId);	
//		}
//		else {
//			return ResponseEntity.status(400)
//					.body("Registration with studentId = " + studentId + " and courseId" + courseId + " was not found");
//		}
//			
//	}

}








