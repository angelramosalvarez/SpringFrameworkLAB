package org.collegemanagment.assemblers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.inject.Named;

import org.collegemanagment.assemblers.commons.AssemblyException;
import org.collegemanagment.assemblers.commons.SimpleAssembler;
import org.collegemanagment.model.Address;
import org.collegemanagment.model.College;
import org.collegemanagment.model.Course;
import org.collegemanagment.model.Student;
import org.collegemanagment.transferobject.AddressDTO;
import org.collegemanagment.transferobject.CollegeDTO;
import org.collegemanagment.transferobject.CourseDTO;
import org.collegemanagment.transferobject.StudentDTO;


/* Assembler object from Data Transfer Object to Domain Objects and vice versa */

@Named("CollegesAssembler")
public class CollegeAssamblerImpl extends SimpleAssembler<CollegeDTO, College>{

	
	public CollegeAssamblerImpl() {
		super(CollegeDTO.class, College.class);
	}
	
	@Override
	public College createDomainObject(CollegeDTO collegeDTO) throws AssemblyException{
		College college=new College();
		
		college.setId(collegeDTO.getId());
		college.setName(collegeDTO.getName());
		
		
		if(collegeDTO.getAddressesDTO()!=null){
			ConcurrentHashMap<Integer,Address> addresses = new ConcurrentHashMap<Integer, Address>();
			for(AddressDTO addressDTO : collegeDTO.getAddressesDTO()){
				Address address = new Address();
				address.setId(addressDTO.getId());
				address.setLocality(addressDTO.getLocality());
				address.setPostCode(addressDTO.getPostCode());
				address.setPostTown(addressDTO.getPostTown());
				address.setStreetName(addressDTO.getStreetName());
				addresses.put(addressDTO.getId(), address);
			}
			college.setAddresses(addresses);
		}
		
		if(collegeDTO.getCoursesDTO()!=null){
			ConcurrentHashMap<Integer,Course> courses = new ConcurrentHashMap<Integer, Course>();
			for(CourseDTO courseDTO : collegeDTO.getCoursesDTO()){
				Course course = new Course();
				course.setId(courseDTO.getId());
				course.setNameCourse(courseDTO.getNameCourse());
				courses.put (courseDTO.getId(), course);
			}
			college.setCourses(courses);
		}
		
		if(collegeDTO.getStudentsDTO()!=null){
			ConcurrentHashMap<Integer,Student> students = new ConcurrentHashMap<Integer, Student>();
			for(StudentDTO studentDTO : collegeDTO.getStudentsDTO()){
				Student student = new Student();
				student.setId(studentDTO.getId());
				student.setName(studentDTO.getName());
				student.setSurname(studentDTO.getSurname());
				students.put(studentDTO.getId(), student);
			}
			college.setStudents(students);
		}
		
		
		return college;		
	}

	
	public CollegeDTO createDataTransferObject(College college) throws AssemblyException{
	
		 CollegeDTO collegeDTO = new CollegeDTO();
		 collegeDTO.setId(college.getId());
		 collegeDTO.setName(college.getName());
		
		 if(college.getAddresses()!=null){
			 Collection<AddressDTO> addressesDTO = new ArrayList<AddressDTO>();
			 for (Map.Entry<Integer, Address> entry : college.getAddresses().entrySet()) {
				 AddressDTO addressDTO = new AddressDTO();
				 addressDTO.setId(entry.getValue().getId());						 
				 addressDTO.setLocality(entry.getValue().getLocality());
				 addressDTO.setPostCode(entry.getValue().getPostCode());
				 addressDTO.setPostTown(entry.getValue().getPostTown());
				 addressDTO.setStreetName(entry.getValue().getStreetName());		
				 addressesDTO.add(addressDTO);			 			 
			 }
			 collegeDTO.setAddressesDTO(addressesDTO);
		 }
		 
		 if(college.getCourses()!=null){
			 Collection<CourseDTO> coursesDTO = new ArrayList<CourseDTO>();
			 for (Map.Entry<Integer, Course> entry : college.getCourses().entrySet()) {
				 CourseDTO courseDTO = new CourseDTO();
				 courseDTO.setId(entry.getValue().getId());
				 courseDTO.setNameCourse(entry.getValue().getNameCourse());
				 coursesDTO.add(courseDTO);			 			 
			 }
			 collegeDTO.setCoursesDTO(coursesDTO);
		 }
		 
		 if(college.getStudents()!=null){
			 Collection<StudentDTO> studentsDTO = new ArrayList<StudentDTO>();
			 for (Map.Entry<Integer, Student> entry : college.getStudents().entrySet()) {
				  StudentDTO studentDTO = new StudentDTO();
				  studentDTO.setId(entry.getValue().getId());
				  studentDTO.setName(entry.getValue().getName());
				  studentDTO.setSurname(entry.getValue().getSurname());			  			 
				  studentsDTO.add(studentDTO);			 			 
			 }
			 collegeDTO.setStudentsDTO(studentsDTO);
		 }
		 
		return collegeDTO;
	
	}
	
		
	
}
