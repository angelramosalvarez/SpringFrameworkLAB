package org.collegemanagment.managers.api;

import java.util.Collection;

import org.collegemanagment.model.Address;

public interface AddressManager {
	
	 Address createAddress(Integer collegeID, Address address);
			
	 Collection<Address> getAllAddress(Integer collegeID);	   
	 
	 Address getAddress(Integer collegeID, Integer addressID);
		
	 void deleteAddress(Integer collegeID, Integer addressID);

	 Address updateAddress(Integer collegeID, Integer addressID, Address address);
						
}
