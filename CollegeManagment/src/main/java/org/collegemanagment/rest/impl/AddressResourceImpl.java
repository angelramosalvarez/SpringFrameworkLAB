package org.collegemanagment.rest.impl;

import java.util.Collection;

import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

import org.collegemanagment.assemblers.commons.Assembler;
import org.collegemanagment.assemblers.commons.AssemblyException;
import org.collegemanagment.managers.api.AddressManager;
import org.collegemanagment.model.Address;
import org.collegemanagment.rest.api.AddressResource;
import org.collegemanagment.transferobject.AddressDTO;
import org.collegemanagment.validations.Validations;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/* Resources to do CRUD operation with Address */

@RestController
@RequestMapping("/v1/address")
public class AddressResourceImpl implements AddressResource{
	
	@Inject
	private AddressManager addressManager;
	
	@Inject	
	private Validations validations;
	
	@Inject 
	@Named("AddressAssembler")
	private Assembler<AddressDTO, Address> addressAssembler;
	
	
		
	@RequestMapping(value = "", method = RequestMethod.POST)	
	@ResponseStatus(HttpStatus.CREATED)
	@Produces("application/json")
	@Consumes("application/json")
	public @ResponseBody AddressDTO createAddress(
							@NotNull @RequestHeader("collegeID") Integer collegeID,
							@NotNull @RequestBody AddressDTO addressDTO) throws AssemblyException {
	
		validations.checkIsNotNull(collegeID);
		validations.checkIsNotNull(addressDTO);
		validations.checkIsNotNull(addressDTO.getId());
		
		//Transformation from DTO (Data Transfer Object) to DO (Domain Object)
		Address address = addressAssembler.createDomainObject(addressDTO);		
		Address addressResponse = addressManager.createAddress(collegeID, address);
		AddressDTO addressResponseDTO = addressAssembler.createDataTransferObject(addressResponse);
		
		
		return  addressResponseDTO ;
		
		
	}
	
	
	@RequestMapping(value = "", method = RequestMethod.GET)	
	@Produces("application/json")
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Collection<AddressDTO> getAllAddress(@NotNull @RequestHeader("collegeID") Integer collegeID) throws AssemblyException{

		validations.checkIsNotNull(collegeID);
		
		Collection<Address> addresses = addressManager.getAllAddress(collegeID);
		Collection<AddressDTO> addressesDTO = addressAssembler.createDataTransferObjects(addresses);
		
		
		return addressesDTO;
		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)	
	@Produces("application/json")
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody AddressDTO getAddress(@NotNull @RequestHeader("collegeID") Integer collegeID, 
												@PathVariable("id") Integer addressID) throws AssemblyException{

		validations.checkIsNotNull(collegeID);
		validations.checkIsNotNull(addressID);
		
		Address address = addressManager.getAddress(collegeID, addressID);
		AddressDTO addressDTO = addressAssembler.createDataTransferObject(address);
		
		return addressDTO;
		
	}
	
				
	@RequestMapping(value = "/{id}" , method = RequestMethod.DELETE)
	@Produces("application/json")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteAddress(@NotNull @RequestHeader("collegeID") Integer collegeID,
							  @NotNull @PathVariable("id") Integer addressID){
		
		validations.checkIsNotNull(collegeID);
		validations.checkIsNotNull(addressID);
		
		addressManager.deleteAddress(collegeID, 
									 addressID);
	}
	

	@RequestMapping(value = "/{id}" , method = RequestMethod.PUT)
	@Produces("application/json")
	@Consumes("application/json")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public @ResponseBody AddressDTO  updateAddress(@NotNull @RequestHeader("collegeID") Integer collegeID,
							  @NotNull @PathVariable("id") Integer addressID,
							  @RequestBody AddressDTO addressDTO) throws AssemblyException{
		
		validations.checkIsNotNull(collegeID);
		validations.checkIsNotNull(addressID);
		validations.checkIsNotNull(addressDTO);
		validations.checkIds(addressID, addressDTO.getId());
		
		Address address = addressAssembler.createDomainObject(addressDTO);		
		Address addressResponse = addressManager.updateAddress(collegeID,addressID,address);
		AddressDTO addressResponseDTO = addressAssembler.createDataTransferObject(addressResponse);
		
		
		return addressResponseDTO;
		
		
		
	}


}
