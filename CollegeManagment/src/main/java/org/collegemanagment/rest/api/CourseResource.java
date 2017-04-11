package org.collegemanagment.rest.api;

import java.util.Collection;

import org.collegemanagment.assemblers.commons.AssemblyException;
import org.collegemanagment.transferobject.CourseDTO;

public interface CourseResource {
	
	
	CourseDTO createCourse(Integer collegeID, CourseDTO courseDTO) throws AssemblyException;
	
	Collection<CourseDTO> getAllCourse(Integer collegeID) throws AssemblyException;
	
	CourseDTO getCourse(Integer collegeID, Integer courseID) throws AssemblyException;

	void deleteCourse(Integer collegeID, Integer courseID);
	
	CourseDTO updateCourse(Integer collegeID, Integer courseID, CourseDTO courseDTO) throws AssemblyException;



}
