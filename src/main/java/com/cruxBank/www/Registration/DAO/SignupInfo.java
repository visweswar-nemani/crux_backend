package com.cruxBank.www.Registration.DAO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import com.sun.istack.NotNull;

@Entity
public class SignupInfo {
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private int id;
	@Column(nullable = false,length = 250)
	private String firstName;
	@Column(nullable = false,length = 250)
	private String lastName;
	@Id
	@Column(nullable = false,length = 250,unique = true)
	private String email;
	@Column(nullable = false,length = 250)
	private String city;
	@Column(nullable = false,length = 250)
	private String state;
	@Column(nullable = false,length = 250,unique = true)
	private Long mobileNumber;
	@Column(nullable = false,length = 250)
	private String address_1;
	@Column(nullable = false,length = 250)
	private String address_2;
	@Column(nullable = false,length = 250)
	private int zip;

	
	
	
	public SignupInfo() {
		super();
	}
	
	


	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
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
	
	
	@Override
	public String toString() {
		return "SignupInfo [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", city=" + city + ", state=" + state + ", mobileNumber=" + mobileNumber + ", address_1=" + address_1
				+ ", address_2=" + address_2 + ", zip=" + zip + "]";
	}
	
}
