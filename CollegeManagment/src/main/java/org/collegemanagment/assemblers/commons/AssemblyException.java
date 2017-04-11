package org.collegemanagment.assemblers.commons;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The exception that send the method of the assemblers.
 *
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class AssemblyException extends RuntimeException{

	private static final long serialVersionUID = -4741488733357237434L;
	
	/**
	 * Default constructor of assembly exception.
	 */
	public AssemblyException(){		
	}
	
	/**
	 * The assembly exception.
	 * @param cause the cause of the exception.
	 */
	public AssemblyException(Exception cause) {
		super(cause);
	}

	public AssemblyException(String exceptionMessage) {
		super(exceptionMessage);
	}

	public AssemblyException(String message, Throwable cause) {
	    super(message, cause);
	}
	
	
}
