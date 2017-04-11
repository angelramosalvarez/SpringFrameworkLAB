package org.collegemanagment.cache.api;

import java.util.Collection;

import org.collegemanagment.model.College;

public interface CollegeCache {
	
	College getCollege(Integer collegeID);
		
	College createCollege(College college);
	
	void deleteCollege(Integer key);
	
	College updateCollege(Integer key, College college );
	
	Collection<College> getAllColleges();

}
