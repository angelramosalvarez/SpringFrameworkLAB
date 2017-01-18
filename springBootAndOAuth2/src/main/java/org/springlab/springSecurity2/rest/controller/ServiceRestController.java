package org.springlab.springSecurity2.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ServiceRestController {
		
	@RequestMapping("/apirest")
	@ResponseStatus(HttpStatus.OK)
	public String toDoSomething() {
		return "Return REST service";
	}
	
}
