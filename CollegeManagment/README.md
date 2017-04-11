# Java 8, Spring Boot and Spring REST API

This is a complete example shows how create a web service for managing data for a college. The resources to be managed are College, Address, Course and Student.

College and its related objects are stored and retrieved from a caching layer during CRUD operations, and all data is lost when the application is stopped.

- Compile project with Maven: 
	
			mvn clean package
	
- Execute Jar application (Jar is created in target directory): 
	
			java -jar CollegeManagment.jar
			
			
- Methods you can invoke:
	
	   HOST: http://localhost:8080
	   Context: /collegemanagment
   	    

		/v1/address/{id}],methods=[DELETE]
		/v1/address/{id}],methods=[PUT]
		/v1/address],methods=[POST]
		/v1/address],methods=[GET]
		/v1/address/{id},methods=[GET]
		/v1/colleges/{id}],methods=[DELETE]
		/v1/colleges/{id}],methods=[PUT]
		/v1/colleges],methods=[POST]
		/v1/colleges],methods=[GET]
		/v1/colleges/{id},methods=[GET]
		/v1/courses/{id}],methods=[DELETE]
		/v1/courses],methods=[POST]
		/v1/courses/{id}],methods=[PUT]
		/v1/courses],methods=[GET]
		/v1/courses/{id},methods=[GET]
		/v1/students/{id}],methods=[DELETE]
		/v1/students],methods=[POST]
		/v1/students],methods=[GET]
		/v1/students/{id},methods=[PUT]
		/v1/students/{id},methods=[GET]
		
		
- EXAMPLES

		Example1: CREATE A NEW COLLEGE
	
			 - Http request: http://localhost:8080/collegemanagment/v1/colleges
			 - method: POST
			 - Headers:
					Content-Type: application/json
			 - Raw payload JSON:
					{
					 "id" : 1,
					 "name" : "nombre del collage 1",
					 "addressesDTO" : [{"id": "1", 
									 "streetName" : "street name 2",
									 "locality" : "locality2",
									 "postTown" : "postTown2",
									 "postCode" : "postCode2"}],
					 "coursesDTO" : [{"id": "1", "nameCourse" : "course name 1"},
								  {"id": "2", "nameCourse" : "course name 2"}],
					 "studentsDTO" : [{"id": "1", "name" : "student name 1", "surname" : "estudent surname 1"},
								   {"id": "2", "name" : "student name 2", "surname" : "estudent surname 2"}]   
					}
					
				
		Example2: GET COURSES
		
			- Http request: http://localhost:8080/collegemanagment/v1/courses
			- method: GET
			- Headers:
				Content-Type: application/json
				collegeID: 1
				
				
		Example3: UPDATE A COURSE
		
			- Http request: http://localhost:8080/collegemanagment/v1/courses/1
			- method: PUT
			- Headers:
				Content-Type: application/json
				collegeID: 1
			- Raw payload JSON:
				{
					"id": 2,
					"nameCourse": "UPDATE name course"
				}
		
		
	
 