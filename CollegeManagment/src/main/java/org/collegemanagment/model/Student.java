package org.collegemanagment.model;

import javax.validation.constraints.NotNull;


/* Domain Object to Student*/

/* This class is used to store Students in memory cache */

public class Student {

	 @NotNull private Integer id;
	 private String name;
	 private String surname;
 
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
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	 
	 
}
