package org.collegemanagment.managers.api;

import java.util.Collection;

import org.collegemanagment.model.College;

public interface CollegeManager {
	
	College createCollege(College college);
	
	Collection<College> getAllColleges();
	
	College getCollege(Integer id);
	
	void deleteCollege(int id);
		
	College updateCollege(Integer id, College college);

}
