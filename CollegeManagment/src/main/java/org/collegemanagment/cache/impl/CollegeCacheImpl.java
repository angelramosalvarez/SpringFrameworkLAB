package org.collegemanagment.cache.impl;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import javax.inject.Named;
import javax.inject.Singleton;

import org.collegemanagment.cache.api.CollegeCache;
import org.collegemanagment.model.College;

/* Manage CRUD operation to manage College cache*/

/*This class extends from SimpleCache to take advantages the commons CRUD operations 
and creates a singleton to store all objects data */


@Named
public class CollegeCacheImpl extends SimpleCacheImpl<Integer, College> implements CollegeCache {
	
	@Singleton
	public ConcurrentMap<Integer, College> cache;
	
	
	public CollegeCacheImpl() {
		super(Integer.class, College.class);
		cache = new ConcurrentHashMap<Integer, College>();
	 }
	
	public College getCollege(Integer collegeID){
		
			return this.get(cache, collegeID);	
		 
	}
	
	public College createCollege(College college){		   
		
		return (College) this.create(cache, college.getId(), college);
		
	}
	
	public void deleteCollege(Integer id){
		
		this.delete(cache, id);
		
	}
	
	public College updateCollege(Integer id, College college ){
		
		return (College) this.update(cache, id, college);
			
	}
	
   public Collection<College> getAllColleges(){
	   
	   return this.getAll(cache);
	
	}
	

	

}
