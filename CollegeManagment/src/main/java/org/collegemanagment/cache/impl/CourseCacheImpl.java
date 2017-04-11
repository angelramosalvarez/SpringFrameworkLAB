package org.collegemanagment.cache.impl;

import java.util.Collection;

import javax.inject.Inject;
import javax.inject.Named;

import org.collegemanagment.cache.api.CollegeCache;
import org.collegemanagment.cache.api.CourseCache;
import org.collegemanagment.model.College;
import org.collegemanagment.model.Course;
import org.collegemanagment.validations.InvalidRequestException;


/* Manage CRUD operation to Manage Course in cache*/

/*This class extends from SimpleCache to take advantages the commons CRUD operations 
and Inject common singleton Cache in order to access the data store there */


@Named
public class CourseCacheImpl extends SimpleCacheImpl<Integer, Course> implements CourseCache{

	@Inject
	CollegeCache cacheCollege;
	
	public CourseCacheImpl() {
		super(Integer.class, Course.class);	
	 }
			
	   public Course createCourse(Integer collegeID, Course course){
				   
		   	College college = cacheCollege.getCollege(collegeID);
		   	
		   	return (Course) this.create(college.getCourses(), 
				   				course.getId(),
				   				course);
			
		}
	   
	   public Collection<Course> getAllCourses(Integer collegeID){	   				
				
			College college = cacheCollege.getCollege(collegeID);
				
			return this.getAll(college.getCourses());
		}
	   
	   public Course getCourse(Integer collegeID, Integer courseID){
		   
		   College college = cacheCollege.getCollege(collegeID);
			
			return this.get(college.getCourses(), courseID);
	   }
	   
	   public void deleteCourse(Integer collegeID, Integer courseID){
		   
		    College college = cacheCollege.getCollege(collegeID);
		      
		    this.delete(college.getCourses(), courseID);   
	   }
	   
	   public Course updateCourse(Integer collegeID, Integer courseID, Course course){
		   
		   if(courseID != course.getId()){
			   throw new InvalidRequestException("Course ID must be the same");
		   }
		   
		   College college = cacheCollege.getCollege(collegeID);
		   
		    return (Course) this.update(college.getCourses(),courseID,course);
		   	
	   }
	   
	   
	
	
}
