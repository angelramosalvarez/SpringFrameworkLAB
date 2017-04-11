package org.collegemanagment.managers.api;

import java.util.Collection;

import org.collegemanagment.model.Student;

public interface StudentManager {
	
	 Student createStudent(Integer collegeID, Student student);
	 
	 Collection<Student> getAllStudents(Integer collegeID);
	 
	 Student getStudent(Integer collegeID, Integer studentID);
	  
	 void deleteStudent(Integer collegeID, Integer studentID);
 
	 Student updateStudent(Integer collegeID, Integer studentID, Student student);

			

}
