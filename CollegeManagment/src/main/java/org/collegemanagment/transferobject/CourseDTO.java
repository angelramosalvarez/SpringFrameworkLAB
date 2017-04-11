package org.collegemanagment.transferobject;

/*Course Data Transfer Object*/ 

/* This class is used the communication with the client*/

public class CourseDTO {

	 private Integer id;
	 private String nameCourse;

	public String getNameCourse() {
		return nameCourse;
	}

	public void setNameCourse(String nameCourse) {
		this.nameCourse = nameCourse;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	 
	 
	 
}
