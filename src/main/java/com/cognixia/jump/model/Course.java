package com.cognixia.jump.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Course implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long courseId;
	
	@Column(name = "department")
	private String department;
	
	@Column(name = "name")
	String name;
	
	@Column(name = "credits")
	int credits;
	
	public Course(Long courseId, String department, String name, int credits) {
		super();
		this.courseId = courseId;
		this.department = department;
		this.name = name;
		this.credits = credits;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
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

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", department=" + department + ", name=" + name + ", credits=" + credits
				+ "]";
	}
	
	
}
