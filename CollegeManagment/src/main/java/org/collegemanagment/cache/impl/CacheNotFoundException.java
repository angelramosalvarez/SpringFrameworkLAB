package org.collegemanagment.cache.impl;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CacheNotFoundException extends RuntimeException {
	

	private static final long serialVersionUID = -1330784751300554147L;
	
    public CacheNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    public CacheNotFoundException(String message) {
        super(message);
    }
    public CacheNotFoundException(Throwable cause) {
        super(cause);
    }

	
	
	
}
