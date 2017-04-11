package org.collegemanagment.rest.api;

import java.util.Collection;

import org.collegemanagment.assemblers.commons.AssemblyException;
import org.collegemanagment.transferobject.AddressDTO;

public interface AddressResource {
	
	AddressDTO createAddress(Integer collegeID, AddressDTO address) throws AssemblyException;

	Collection<AddressDTO> getAllAddress(Integer collegeID) throws AssemblyException;
	
	AddressDTO getAddress(Integer collegeID, Integer addressID) throws AssemblyException;

	void deleteAddress(Integer collegeID, Integer addressID);
	
	AddressDTO updateAddress(Integer collegeID,Integer addressID, AddressDTO addressDTO) throws AssemblyException;
	
	


}
