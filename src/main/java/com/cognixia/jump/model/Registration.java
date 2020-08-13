package com.cognixia.jump.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.persistence.GenerationType;


@Entity
public class Registration implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@NotBlank
	private Long studentId;
	
	@NotBlank
	private String firstName;
	
	@NotBlank
	private String lastName;
	
	
	@NotBlank
	@Column(unique = true, nullable = false)
	private String courseId;
	
	@NotBlank
	@Column(unique = true, nullable = false)
	private String department;
	
	@NotBlank
	@Column(unique = true, nullable = false)
	private String name;
	
	@NotBlank
	@Column(unique = true, nullable = false)
	private int credits;

	
	public Registration() {
		this(-1L, "n/a", "n/a", "-1", "math", "algebra", 3);
	}
	public Registration(Long studentId, @NotBlank String firstName, @NotBlank String lastName, @NotBlank String courseId,
			@NotBlank String department, @NotBlank String name, @NotBlank int credits) {
		super();
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.courseId = courseId;
		this.department = department;
		this.name = name;
		this.credits = credits;
	}

	

	public Long getStudentId() {
		return studentId;
	}



	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getCourseId() {
		return courseId;
	}



	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}



	public String getDepartment() {
		return department;
	}



	public void setDepartment(String department) {
		this.department = department;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getCredits() {
		return credits;
	}



	public void setCredits(int credits) {
		this.credits = credits;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	@Override
	public String toString() {
		return "Registration [studentId=" + studentId + ", firstName=" + firstName + ", lastName=" + lastName + ", courseId="
				+ courseId + ", department=" + department + ", name=" + name + ", credits=" + credits + "]";
	}	

}
