package org.collegemanagment.cache.api;

import java.util.Collection;

import org.collegemanagment.model.Course;

public interface CourseCache {
	
	Course createCourse(Integer collegeID, Course course);
	
	Collection<Course> getAllCourses(Integer collegeID);
	
	Course getCourse(Integer collegeID, Integer courseID);
	
	 void deleteCourse(Integer collegeID, Integer courseID);
	 
	 Course updateCourse(Integer collegeID, Integer courseID, Course course);

}
