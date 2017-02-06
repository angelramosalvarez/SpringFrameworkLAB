# Spring Boot, Spring Security and Spring OAuth2 

This code shows us how you can configure SpringBoot in a REST API with Spring Security and Spring OAuth2.

	Compile: mvn clean install -P FatJar
	Execute: mvn spring-boot:run
	
	Test:	
	
		1.- GET TOKEN:
		 
				http://localhost:8082/oauth/token?grant_type=password&username=angel&password=123
		
		2.- ACCESS TO RESOURCE with GET call:
		
			   http://localhost:8082/apirest/oauth/token?access_token=XXXXxx0x0-x000-00x0-0x00-xxxx0000000