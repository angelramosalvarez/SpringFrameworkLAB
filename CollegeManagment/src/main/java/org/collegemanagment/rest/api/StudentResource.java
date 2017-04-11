package org.collegemanagment.rest.api;

import java.util.Collection;

import javax.validation.constraints.NotNull;

import org.collegemanagment.assemblers.commons.AssemblyException;
import org.collegemanagment.transferobject.StudentDTO;
import org.springframework.web.bind.annotation.RequestHeader;

public interface StudentResource {
	
	
	StudentDTO createStudent(Integer collegeID, StudentDTO studentDTO) throws AssemblyException;
	
 	Collection<StudentDTO> getAllStudents(Integer collegeID) throws AssemblyException;
 	
 	StudentDTO getStudent(@NotNull @RequestHeader("collegeID") Integer collegeID,Integer studentID) throws AssemblyException;
 	
	void deleteStudent(Integer collegeID, Integer studentID);
	
	StudentDTO updateStudent(Integer collegeID, Integer studentID, StudentDTO studentDTO) throws AssemblyException;





}
