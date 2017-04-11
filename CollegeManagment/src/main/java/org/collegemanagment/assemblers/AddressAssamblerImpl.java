package org.collegemanagment.assemblers;

import javax.inject.Named;

import org.collegemanagment.assemblers.commons.AssemblyException;
import org.collegemanagment.assemblers.commons.SimpleAssembler;
import org.collegemanagment.model.Address;
import org.collegemanagment.transferobject.AddressDTO;

/* Assembler object from Data Transfer Object to Domain Objects and vice versa */

@Named("AddressAssembler")
public class AddressAssamblerImpl extends SimpleAssembler<AddressDTO, Address>{

	
	public AddressAssamblerImpl() {
		super(AddressDTO.class, Address.class);
	}
	
	@Override
	public Address createDomainObject(AddressDTO addressDTO) throws AssemblyException{
		
			Address address = new Address();
			address.setId(addressDTO.getId());
			address.setLocality(addressDTO.getLocality());
			address.setPostCode(addressDTO.getPostCode());
			address.setPostTown(addressDTO.getPostTown());
			address.setStreetName(addressDTO.getStreetName());
			
		return address;		
		
	}

	
	public AddressDTO createDataTransferObject(Address address) throws AssemblyException{
	
		 AddressDTO addressDTO = new AddressDTO();
		 addressDTO.setId(address.getId());						 
		 addressDTO.setLocality(address.getLocality());
		 addressDTO.setPostCode(address.getPostCode());
		 addressDTO.setPostTown(address.getPostTown());
		 addressDTO.setStreetName(address.getStreetName());		
			 
		 return addressDTO;
		 
	}
	

	
	
		
	
}
