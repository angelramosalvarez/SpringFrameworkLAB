package org.collegemanagment.assemblers;

import javax.inject.Named;

import org.collegemanagment.assemblers.commons.AssemblyException;
import org.collegemanagment.assemblers.commons.SimpleAssembler;
import org.collegemanagment.model.Course;
import org.collegemanagment.transferobject.CourseDTO;

/* Assembler object from Data Transfer Object to Domain Objects and vice versa */

@Named("CourseAssembler")
public class CourseAssamblerImpl extends SimpleAssembler<CourseDTO, Course>{

	
	public CourseAssamblerImpl() {
		super(CourseDTO.class, Course.class);
	}
	
	@Override
	public Course createDomainObject(CourseDTO courseDTO) throws AssemblyException{
		
		    Course course = new Course();
			course.setId(courseDTO.getId());
			course.setNameCourse(courseDTO.getNameCourse());
				
		  return course;		
	}

	
	public CourseDTO createDataTransferObject(Course course) throws AssemblyException{
	
		 
		 CourseDTO courseDTO = new CourseDTO();
		 courseDTO.setId(course.getId());
		 courseDTO.setNameCourse(course.getNameCourse());
					 			 
		
		return courseDTO;
	
	}
	
		
	
}
