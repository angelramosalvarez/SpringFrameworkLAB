package org.collegemanagment.validations;

import javax.inject.Named;


/* Commons validations operation to check Null and Blank values */

@Named
public class Validations {
	
	public void checkIds(Integer id1, Integer id2){
		
		if(id1 != id2){
			   throw new InvalidRequestException("Address ID must be the same");
		 }
		
	}
	
	
	public void checkIsNotNull(Object... objects){
		for(Object object: objects){
			if(object==null){
				throw new InvalidRequestException("Passed parameter can not be null");
			}
		}
	}
	

	
	public void checkIsNotNullAndNotBlank(String... objects){
		checkIsNotNull((Object[])objects);
		for(String object: objects){
			object=object.trim();
			if(object.length()==0){
				throw new InvalidRequestException("Passed parameter can not be blank");
			}
		}
	}
	
	

}
