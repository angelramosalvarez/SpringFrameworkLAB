package org.collegemanagment.model;


/* Domain Object to Address*/

/* This class is used to store Address in memory cache */

public class Address {
	
	private Integer id;
	private String streetName;
	private String locality;
	private String postTown;
	private String postCode;
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
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
	
	

}
