package org.collegemanagment.cache.impl;

import java.util.Collection;

import javax.inject.Inject;
import javax.inject.Named;

import org.collegemanagment.cache.api.AddressCache;
import org.collegemanagment.cache.api.CollegeCache;
import org.collegemanagment.model.Address;
import org.collegemanagment.model.College;


/* Manage CRUD operations to Address in cache*/

/*This class extends from SimpleCache to take advantages the commons CRUD operations 
  and Inject common singleton Cache in order to access the data store there */

@Named
public class AddressCacheImpl extends SimpleCacheImpl<Integer, Address> implements AddressCache{

	
	@Inject
	CollegeCache cacheCollege;
		
		
	 public AddressCacheImpl() {
		super(Integer.class, Address.class);	
	 }
	
	 public Address createAddress(Integer collegeID, Address address) {
		   
		 	 College college = cacheCollege.getCollege(collegeID);
		 				   		
			 return (Address) this.create(college.getAddresses(), 
				   				    	  address.getId(),
				   				    	  address);
			
			
	  }
	   
	  public Collection<Address> getAllAddress(Integer collegeID){	   
				
			College college = cacheCollege.getCollege(collegeID);
			
			return this.getAll(college.getAddresses());
			
	  }
	  
	  public Address getAddress(Integer collegeID, Integer addressID){
		  
		  College college = cacheCollege.getCollege(collegeID);
		  
		  return this.get(college.getAddresses(), addressID);
	  }
	   
	  public void deleteAddress(Integer collegeID, Integer addressID){
		   
		    College college = cacheCollege.getCollege(collegeID);
		      
		    this.delete(college.getAddresses(), addressID);
		   
	   }
	   
	   public Address updateAddress(Integer collegeID, Integer addressID, Address address){
		   
		   
		   College college = cacheCollege.getCollege(collegeID);
		   
		    return (Address) this.update(college.getAddresses(),addressID,address);
		   
	   }
	   
}
