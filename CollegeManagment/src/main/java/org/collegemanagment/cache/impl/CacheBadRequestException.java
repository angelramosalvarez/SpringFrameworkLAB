package org.collegemanagment.cache.impl;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class CacheBadRequestException extends RuntimeException {
	
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -5152914447027752658L;
	
	
	public CacheBadRequestException(String message, Throwable cause) {
        super(message, cause);
    }
    public CacheBadRequestException(String message) {
        super(message);
    }
    public CacheBadRequestException(Throwable cause) {
        super(cause);
    }

	
	
	
}
