package org.collegemanagment.rest.impl;

import java.util.Collection;

import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

import org.collegemanagment.assemblers.commons.Assembler;
import org.collegemanagment.assemblers.commons.AssemblyException;
import org.collegemanagment.managers.api.CourseManager;
import org.collegemanagment.model.Course;
import org.collegemanagment.rest.api.CourseResource;
import org.collegemanagment.transferobject.CourseDTO;
import org.collegemanagment.validations.Validations;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/* Resources to do CRUD operation with Courses */

@RestController
@RequestMapping("/v1/courses")
public class CourseResourceImpl implements CourseResource{
	
	@Inject
	private CourseManager courseManager;
	
	@Inject	
	private Validations validations;
	
	@Inject 
	@Named("CourseAssembler")
	private Assembler<CourseDTO, Course> courseAssembler;
	
		
	@RequestMapping(value = "", method = RequestMethod.POST)	
	@ResponseStatus(HttpStatus.CREATED)
	@Produces("application/json")
	@Consumes("application/json")
	public @ResponseBody CourseDTO createCourse(
							@NotNull @RequestHeader("collegeID") Integer collegeID,
							@NotNull @RequestBody CourseDTO courseDTO) throws AssemblyException{
			
		validations.checkIsNotNull(collegeID);		
		validations.checkIsNotNull(courseDTO);
		validations.checkIsNotNull(courseDTO.getId());
		
		//Transformation from DTO (Data Transfer Object) to DO (Domain Object)
		Course course = courseAssembler.createDomainObject(courseDTO);		
		Course courseResponse = courseManager.createCourse(collegeID, course);
		CourseDTO courseResponseDTO = courseAssembler.createDataTransferObject(courseResponse);
		
		
		return courseResponseDTO;
		
		
	}
	
	
	@RequestMapping(value = "", method = RequestMethod.GET)	
	@Produces("application/json")
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Collection<CourseDTO> getAllCourse(@NotNull @RequestHeader("collegeID") Integer collegeID) throws AssemblyException{

		validations.checkIsNotNull(collegeID);
		
		
		Collection<Course> courses = courseManager.getAllCourses(collegeID);
		Collection<CourseDTO> coursesDTO = courseAssembler.createDataTransferObjects(courses);
		
		
		return coursesDTO;
		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)	
	@Produces("application/json")
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody CourseDTO getCourse(@NotNull @RequestHeader("collegeID") Integer collegeID, 
												@PathVariable("id") Integer courseID) throws AssemblyException{

		validations.checkIsNotNull(collegeID);
		validations.checkIsNotNull(courseID);
		
		Course course = courseManager.getCourse(collegeID, courseID);
		CourseDTO courseDTO = courseAssembler.createDataTransferObject(course);
		
		return courseDTO;
		
	}
	
				
	@RequestMapping(value = "/{id}" , method = RequestMethod.DELETE)
	@Produces("application/json")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteCourse(@NotNull @RequestHeader("collegeID") Integer collegeID,
							  @NotNull @PathVariable("id") Integer courseID){
		
		validations.checkIsNotNull(collegeID);
		validations.checkIsNotNull(courseID);
		
		courseManager.deleteCourse(collegeID, 
									 courseID);
	}
	

	@RequestMapping(value = "/{id}" , method = RequestMethod.PUT)
	@Produces("application/json")
	@Consumes("application/json")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public @ResponseBody CourseDTO updateCourse(@NotNull @RequestHeader("collegeID") Integer collegeID,
							  @NotNull @PathVariable("id") Integer courseID,
							  @RequestBody CourseDTO courseDTO) throws AssemblyException{
		
		validations.checkIsNotNull(collegeID);
		validations.checkIsNotNull(courseID);
		validations.checkIsNotNull(courseDTO);
		validations.checkIds(courseID, courseDTO.getId());
		
		Course course = courseAssembler.createDomainObject(courseDTO);
		Course courseResponse = courseManager.updateCourse(collegeID,courseID,course);
		CourseDTO courseResponseDTO = courseAssembler.createDataTransferObject(courseResponse);
	
		return courseResponseDTO;
		
		
	}



}
