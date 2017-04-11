package org.collegemanagment.rest.api;

import java.util.Collection;

import org.collegemanagment.assemblers.commons.AssemblyException;
import org.collegemanagment.transferobject.CollegeDTO;
import org.springframework.web.bind.annotation.ResponseBody;

public interface CollegeResource {
	
	
	CollegeDTO createCollege(CollegeDTO collegeDTO) throws AssemblyException;

	Collection<CollegeDTO> getAllColleges() throws AssemblyException;
	
	@ResponseBody CollegeDTO getCollege(Integer id) throws AssemblyException;
	
	void deleteCollege(Integer id);

	CollegeDTO updateCollege(Integer id, CollegeDTO collegeDTO) throws AssemblyException;
	
}
