package org.collegemanagment.assemblers;

import javax.inject.Named;

import org.collegemanagment.assemblers.commons.AssemblyException;
import org.collegemanagment.assemblers.commons.SimpleAssembler;
import org.collegemanagment.model.Student;
import org.collegemanagment.transferobject.StudentDTO;

/* Assembler object from Data Transfer Object to Domain Objects and vice versa */

@Named("StudentAssembler")
public class StudentAssamblerImpl extends SimpleAssembler<StudentDTO, Student>{

	
	public StudentAssamblerImpl() {
		super(StudentDTO.class, Student.class);
	}
	
	@Override
	public Student createDomainObject(StudentDTO studentDTO) throws AssemblyException{
			
			Student student = new Student();
			student.setId(studentDTO.getId());
			student.setName(studentDTO.getName());
			student.setSurname(studentDTO.getSurname());
		
		
		return student;		
	}

	
	public StudentDTO createDataTransferObject(Student student) throws AssemblyException{
	
		 
			  StudentDTO studentDTO = new StudentDTO();
			  studentDTO.setId(student.getId());
			  studentDTO.setName(student.getName());
			  studentDTO.setSurname(student.getSurname());			  			 
			  	 			
		 
		return studentDTO;
	
	}
	
		
	
}
