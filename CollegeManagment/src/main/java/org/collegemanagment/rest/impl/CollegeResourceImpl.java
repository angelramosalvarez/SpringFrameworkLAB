package org.collegemanagment.rest.impl;

import java.util.Collection;

import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

import org.collegemanagment.assemblers.commons.Assembler;
import org.collegemanagment.assemblers.commons.AssemblyException;
import org.collegemanagment.managers.api.CollegeManager;
import org.collegemanagment.model.College;
import org.collegemanagment.rest.api.CollegeResource;
import org.collegemanagment.transferobject.CollegeDTO;
import org.collegemanagment.validations.Validations;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/* Resources to do CRUD operation with College */

@RestController
@RequestMapping("/v1/colleges")
public class CollegeResourceImpl implements CollegeResource{
	
	@Inject
	private CollegeManager collegeManager;
	
	@Inject	
	private Validations validations;
	
	@Inject 
	@Named("CollegesAssembler")
	private Assembler<CollegeDTO, College> collegeAssembler;
	
			
	@RequestMapping(value = "", method = RequestMethod.POST)	
	@ResponseStatus(HttpStatus.CREATED)
	@Produces("application/json")
	@Consumes("application/json")
	public @ResponseBody CollegeDTO createCollege(								
							@NotNull @RequestBody CollegeDTO collegeDTO) throws AssemblyException {
				
		validations.checkIsNotNull(collegeDTO);
		validations.checkIsNotNull(collegeDTO.getId());
		
		//Transformation from DTO (Data Transfer Object) to DO (Domain Object)
		College college = collegeAssembler.createDomainObject(collegeDTO);		
		College collegeResponse = collegeManager.createCollege(college);
		CollegeDTO collegeResponseDTO = collegeAssembler.createDataTransferObject(collegeResponse);
		
		return collegeResponseDTO;
	}
	
	
	@RequestMapping(value = "", method = RequestMethod.GET)	
	@Produces("application/json")
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Collection<CollegeDTO> getAllColleges() throws AssemblyException{

		
		Collection<College> colleges = collegeManager.getAllColleges();
		Collection<CollegeDTO> collegesDTO = collegeAssembler.createDataTransferObjects(colleges);
		
		return collegesDTO;
		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)	
	@Produces("application/json")
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody CollegeDTO getCollege(@PathVariable("id") Integer id) throws AssemblyException{

		validations.checkIsNotNull(id);
		
		College college = collegeManager.getCollege(id);
		CollegeDTO collegesDTO = collegeAssembler.createDataTransferObject(college);
		
		return collegesDTO;
		
	}
	
		
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE )
	@Produces("application/json")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteCollege(@PathVariable("id") Integer id){
		
		validations.checkIsNotNull(id);
		
		
		collegeManager.deleteCollege(id);
		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT )
	@Produces("application/json")
	@Consumes("application/json")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public  @ResponseBody CollegeDTO updateCollege(@PathVariable("id") Integer id,
							  @RequestBody CollegeDTO collegeDTO) throws AssemblyException{
		
		validations.checkIsNotNull(id);
		validations.checkIsNotNull(collegeDTO);
		validations.checkIds(id, collegeDTO.getId());
		
		College college = collegeAssembler.createDomainObject(collegeDTO);				
		College collegeResponse = collegeManager.updateCollege(id, college);
        CollegeDTO collegeResponseDTO = collegeAssembler.createDataTransferObject(collegeResponse);
		
		return collegeResponseDTO;
	}
	
}


