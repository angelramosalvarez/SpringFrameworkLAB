package org.collegemanagment.cache.api;

import java.util.Collection;

import org.collegemanagment.model.Address;

public interface AddressCache {
	
	Address createAddress(Integer collegeID, Address address);
	
	Collection<Address> getAllAddress(Integer collegeID);
	
	Address getAddress(Integer collegeID, Integer addressID);
	
	void deleteAddress(Integer collegeID, Integer addressID);
	
	Address updateAddress(Integer collegeID, Integer addressID, Address address);

}
