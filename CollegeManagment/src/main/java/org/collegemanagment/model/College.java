package org.collegemanagment.model;

import java.util.concurrent.ConcurrentMap;

/* Domain Object to College*/

/* This class is used to store Colleges in memory cache */

public class College {

	private Integer id;
	private String name;
	private ConcurrentMap<Integer, Address>  addresses;
	private ConcurrentMap<Integer, Course> courses;
	private ConcurrentMap<Integer, Student> students;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public ConcurrentMap<Integer, Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(ConcurrentMap<Integer, Address> addresses) {
		this.addresses = addresses;
	}
	public ConcurrentMap<Integer, Course> getCourses() {
		return courses;
	}
	public ConcurrentMap<Integer, Student> getStudents() {
		return students;
	}
	public void setCourses(ConcurrentMap<Integer, Course> courses) {
		this.courses = courses;
	}
	public void setStudents(ConcurrentMap<Integer, Student> students) {
		this.students = students;
	}
	
	
	
}
