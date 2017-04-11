package org.collegemanagment.managers.impl;

import java.util.Collection;

import javax.inject.Inject;
import javax.inject.Named;

import org.collegemanagment.cache.api.StudentCache;
import org.collegemanagment.cache.impl.StudentCacheImpl;
import org.collegemanagment.managers.api.StudentManager;
import org.collegemanagment.model.Student;


/* Student manager to CRUD operations, it invokes the cache layer */

@Named
public class StudentManagerImpl implements StudentManager{
	
	 @Inject
	   private StudentCache cacheStudent;
	
 
   public Student createStudent(Integer collegeID, Student student){
			   
	   	return cacheStudent.createStudent(collegeID, student);
		
	}
   
   public Collection<Student> getAllStudents(Integer collegeID){	   
			
		return cacheStudent.getAllStudents(collegeID);
	}
   
   public Student getStudent(Integer collegeID, Integer studentID){
	   
	   return cacheStudent.getStudent(collegeID, studentID);
   }
   
   public void deleteStudent(Integer collegeID, Integer studentID){
	   
	   cacheStudent.deleteStudent(collegeID, studentID);   
   }
   
   public Student updateStudent(Integer collegeID, Integer studentID, Student student){
	   
	   return cacheStudent.updateStudent(collegeID, studentID, student);
   }
   
   
}
	


