package org.collegemanagment.rest.impl;

import java.util.Collection;

import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

import org.collegemanagment.assemblers.commons.Assembler;
import org.collegemanagment.assemblers.commons.AssemblyException;
import org.collegemanagment.managers.api.StudentManager;
import org.collegemanagment.model.Student;
import org.collegemanagment.rest.api.StudentResource;
import org.collegemanagment.transferobject.StudentDTO;
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


/* Resources to do CRUD operation with Students */

@RestController
@RequestMapping("/v1/students")
public class StudentResourceImpl implements StudentResource {
	
		@Inject
		private StudentManager studentManager;
		
		@Inject	
		private Validations validations;
		
		@Inject 
		@Named("StudentAssembler")
		private Assembler<StudentDTO, Student> studentAssembler;
		
		
			
		@RequestMapping(value = "", method = RequestMethod.POST)	
		@ResponseStatus(HttpStatus.CREATED)
		@Produces("application/json")
		@Consumes("application/json")
		public @ResponseBody StudentDTO createStudent(
								@NotNull @RequestHeader("collegeID") Integer collegeID,
								@NotNull @RequestBody StudentDTO studentDTO) throws AssemblyException{
		
			validations.checkIsNotNull(collegeID);
			validations.checkIsNotNull(studentDTO);
			validations.checkIsNotNull(studentDTO.getId());
			
			//Transformation from DTO (Data Transfer Object) to DO (Domain Object)			
			Student student = studentAssembler.createDomainObject(studentDTO);		
			Student studentResponse = studentManager.createStudent(collegeID, student);
			StudentDTO studentResponseDTO = studentAssembler.createDataTransferObject(studentResponse);
		
			
			return studentResponseDTO;
			
			
		}
		
		
		@RequestMapping(value = "", method = RequestMethod.GET)	
		@Produces("application/json")
		@ResponseStatus(HttpStatus.OK)
		public @ResponseBody Collection<StudentDTO> getAllStudents(@NotNull @RequestHeader("collegeID") Integer collegeID) throws AssemblyException{

			validations.checkIsNotNull(collegeID);
			
			Collection<Student> students = studentManager.getAllStudents(collegeID);
			Collection<StudentDTO> studentsDTO = studentAssembler.createDataTransferObjects(students);
			
			
			return studentsDTO;
			
		}
		
		@RequestMapping(value = "/{id}" , method = RequestMethod.GET)	
		@Produces("application/json")
		@ResponseStatus(HttpStatus.OK)
		public @ResponseBody StudentDTO getStudent(@NotNull @RequestHeader("collegeID") Integer collegeID, 
													@PathVariable("id") Integer studentID) throws AssemblyException{

			validations.checkIsNotNull(collegeID);
			validations.checkIsNotNull(studentID);
			
			Student student = studentManager.getStudent(collegeID, studentID);
			StudentDTO studentDTO = studentAssembler.createDataTransferObject(student);
			
			return studentDTO;
			
		}
		
					
		@RequestMapping(value = "/{id}" , method = RequestMethod.DELETE)
		@Produces("application/json")
		@ResponseStatus(HttpStatus.NO_CONTENT)
		public void deleteStudent(@NotNull @RequestHeader("collegeID") Integer collegeID,
								  @NotNull @PathVariable("id") Integer studentID){
			
			validations.checkIsNotNull(collegeID);
			validations.checkIsNotNull(studentID);
			
			studentManager.deleteStudent(collegeID, 
										 studentID);
		}
		

		@RequestMapping(value = "/{id}" , method = RequestMethod.PUT)
		@Produces("application/json")
		@Consumes("application/json")
		@ResponseStatus(HttpStatus.NO_CONTENT)
		public @ResponseBody StudentDTO  updateStudent(@NotNull @RequestHeader("collegeID") Integer collegeID,
								  @NotNull @PathVariable("id") Integer studentID,
								  @RequestBody StudentDTO studentDTO) throws AssemblyException{
			
			validations.checkIsNotNull(collegeID);
			validations.checkIsNotNull(studentID);
			validations.checkIsNotNull(studentDTO);
			validations.checkIds(studentID, studentDTO.getId());
			
						
			Student student = studentAssembler.createDomainObject(studentDTO);				
			Student studentResponse = studentManager.updateStudent(collegeID,studentID,student);
			StudentDTO studentResponseDTO = studentAssembler.createDataTransferObject(studentResponse);
		
			return studentResponseDTO;
			
		}
	


}
