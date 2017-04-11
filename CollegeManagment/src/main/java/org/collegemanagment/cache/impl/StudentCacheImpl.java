package org.collegemanagment.cache.impl;

import java.util.Collection;

import javax.inject.Inject;
import javax.inject.Named;

import org.collegemanagment.cache.api.CollegeCache;
import org.collegemanagment.cache.api.StudentCache;
import org.collegemanagment.model.College;
import org.collegemanagment.model.Student;

/* Manage CRUD operation to Student in cache*/

/*This class extends from SimpleCache to take advantages the commons CRUD operations 
and Inject common singleton Cache in order to access the data store there */


@Named
public class StudentCacheImpl extends SimpleCacheImpl<Integer, Student> implements StudentCache{
	
		@Inject
		CollegeCache cacheCollege;
		
		public StudentCacheImpl() {
			super(Integer.class, Student.class);	
		 }

	   public Student createStudent(Integer collegeID, Student student){
				   
		   	College college = cacheCollege.getCollege(collegeID);
		   	
		    return (Student) this.create(college.getStudents(), 
							    		student.getId(),
							    		student);
			
		}
	   
	   public Collection<Student> getAllStudents(Integer collegeID){	   
				
		   		College college = cacheCollege.getCollege(collegeID);
				
				return this.getAll(college.getStudents());
				
		}
	   
	   public Student getStudent(Integer collegeID, Integer studentID){
		   
		   College college = cacheCollege.getCollege(collegeID);
			
			return this.get(college.getStudents(), studentID);
	   }
	   
	   public void deleteStudent(Integer collegeID, Integer studentID){
		   
		    College college = cacheCollege.getCollege(collegeID);
		      
		    this.delete(college.getStudents(), studentID);
  
	   }
	   
	   public Student updateStudent(Integer collegeID, Integer studentID, Student student){
		   
		   
		   
		   College college = cacheCollege.getCollege(collegeID);
		   
		    return (Student) this.update(college.getStudents(), studentID, student);
	
	   }
	   
}
