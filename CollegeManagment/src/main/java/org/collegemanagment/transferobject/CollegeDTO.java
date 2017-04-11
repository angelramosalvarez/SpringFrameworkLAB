package org.collegemanagment.transferobject;

import java.util.Collection;

/*College Data Transfer Object*/ 

/* This class is used the communication with the client*/

public class CollegeDTO {

	private int id;
	private String name;
	private Collection<AddressDTO> addressesDTO;
	private Collection<CourseDTO> coursesDTO;
	private Collection<StudentDTO> studentsDTO;

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Collection<AddressDTO> getAddressesDTO() {
		return addressesDTO;
	}
	public void setAddressesDTO(Collection<AddressDTO> addressesDTO) {
		this.addressesDTO = addressesDTO;
	}
	public Collection<CourseDTO> getCoursesDTO() {
		return coursesDTO;
	}
	public void setCoursesDTO(Collection<CourseDTO> coursesDTO) {
		this.coursesDTO = coursesDTO;
	}
	public Collection<StudentDTO> getStudentsDTO() {
		return studentsDTO;
	}
	public void setStudentsDTO(Collection<StudentDTO> studentsDTO) {
		this.studentsDTO = studentsDTO;
	}
	
	
	
}
