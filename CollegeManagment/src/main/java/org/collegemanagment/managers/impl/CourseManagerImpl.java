package org.collegemanagment.managers.impl;

import java.util.Collection;

import javax.inject.Inject;
import javax.inject.Named;

import org.collegemanagment.cache.api.CourseCache;
import org.collegemanagment.managers.api.CourseManager;
import org.collegemanagment.model.Course;


/* Course manager to CRUD operations, it invokes the cache layer */

@Named
public class CourseManagerImpl implements CourseManager {
	
	   @Inject
	   private CourseCache cacheCourse;
		
	   public Course createCourse(Integer collegeID, Course course){
				   
		   	return cacheCourse.createCourse(collegeID, course);
			
		}
	   
	   public Collection<Course> getAllCourses(Integer collegeID){	   
				
			return cacheCourse.getAllCourses(collegeID);
		}
	   
	   public Course getCourse(Integer collegeID, Integer courseID){
		   
		   return cacheCourse.getCourse(collegeID, courseID);
		   
	   }
	   
	   public void deleteCourse(Integer collegeID, Integer courseID){
		   
		  cacheCourse.deleteCourse(collegeID, courseID);	   
	   }
	   
	   public Course updateCourse(Integer collegeID, Integer courseID, Course course){
		   
		   return cacheCourse.updateCourse(collegeID, courseID, course);
	   }
	   
	   

}
