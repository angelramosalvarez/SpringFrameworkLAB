package org.collegemanagment.managers.impl;

import java.util.Collection;

import javax.inject.Inject;
import javax.inject.Named;

import org.collegemanagment.cache.api.AddressCache;
import org.collegemanagment.managers.api.AddressManager;
import org.collegemanagment.model.Address;

/* Address manager to CRUD operations, it invokes the cache layer*/

@Named
public class AddressManagerImpl implements AddressManager{
	
	   @Inject
	   private AddressCache cacheAddress;
		
	   public Address createAddress(Integer collegeID, Address address) {
				   
		   return cacheAddress.createAddress(collegeID, address);
			
		}
	   
	   public Collection<Address> getAllAddress(Integer collegeID){	   
				
			return cacheAddress.getAllAddress(collegeID);
		}
	   
	   public Address getAddress(Integer collegeID, Integer addressID){
		   
		   return cacheAddress.getAddress(collegeID, addressID);
	   }
	   
	   public void deleteAddress(Integer collegeID, Integer addressID){
		   
		   cacheAddress.deleteAddress(collegeID, addressID);
	   }
	   
	   public Address updateAddress(Integer collegeID, Integer addressID, Address address){
		   
		   return cacheAddress.updateAddress(collegeID, addressID, address);
	   }
	   

}
