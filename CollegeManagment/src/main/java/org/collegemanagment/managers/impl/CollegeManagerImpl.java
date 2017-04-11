package org.collegemanagment.managers.impl;

import java.util.Collection;

import javax.inject.Inject;
import javax.inject.Named;

import org.collegemanagment.cache.api.CollegeCache;
import org.collegemanagment.managers.api.CollegeManager;
import org.collegemanagment.model.College;


/* College manager to CRUD operations, it invokes the cache layer*/

@Named
public class CollegeManagerImpl implements CollegeManager {
	
	
	@Inject
	private CollegeCache cacheCollege;
	
	
	
	public College createCollege(College college) {
		
		return cacheCollege.createCollege(college);

		
	}
	
	public Collection<College> getAllColleges() {
		
		return cacheCollege.getAllColleges();
	}
	
	public College getCollege(Integer id){
		
		return cacheCollege.getCollege(id);
	}
	
	public void deleteCollege(int id){
		
		cacheCollege.deleteCollege(id);	
	}

	public College updateCollege(Integer id, College college){
		
		return cacheCollege.updateCollege(id, college);
	}
}
