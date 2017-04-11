package org.collegemanagment.transferobject;


/*Address Data Transfer Object*/ 

/* This class is used the communication with the client*/

public class AddressDTO {
	
	private Integer id;
	private String streetName;
	private String locality;
	private String postTown;
	private String postCode;
	
	
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getLocality() {
		return locality;
	}
	public void setLocality(String locality) {
		this.locality = locality;
	}
	public String getPostTown() {
		return postTown;
	}
	public void setPostTown(String postTown) {
		this.postTown = postTown;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	

}
