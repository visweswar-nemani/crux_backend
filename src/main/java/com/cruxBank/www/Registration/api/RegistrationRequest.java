package com.cruxBank.www.Registration.api;

public class RegistrationRequest {
	
	private String firstName;
	private String lastName;
	private String email;
	private String city;
	private String state;
	private Long mobileNumber;
	private String address_1;
	private String address_2;
	private int zip;
	
	
	public RegistrationRequest(String firstName, String lastName, String email, String city, String state,
			Long mobileNumber, String address_1, String address_2, int zip) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.city = city;
		this.state = state;
		this.mobileNumber = mobileNumber;
		this.address_1 = address_1;
		this.address_2 = address_2;
		this.zip = zip;
	}
	
	
	public RegistrationRequest() {
		super();
	}


	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getAddress_1() {
		return address_1;
	}
	public void setAddress_1(String address_1) {
		this.address_1 = address_1;
	}
	public String getAddress_2() {
		return address_2;
	}
	public void setAddress_2(String address_2) {
		this.address_2 = address_2;
	}
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}
	@Override
	public String toString() {
		return "RegistrationRequest [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", city="
				+ city + ", state=" + state + ", mobileNumber=" + mobileNumber + ", address_1=" + address_1
				+ ", address_2=" + address_2 + ", zip=" + zip + "]";
	}	

}
