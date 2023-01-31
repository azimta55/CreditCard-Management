package com.CreditCard.address;


import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public  class Address {

	private String buildingName;
	private String street;
	private String city;
	private String state;
	private String postalCode;
	private String country;
	
	
	public String getBuildingName() {
		return buildingName;
	}
	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
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
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "Address [buildingName=" + buildingName + ", street=" + street + ", city=" + city + ", state=" + state
				+ ", postalCode=" + postalCode + ", country=" + country + "]";
	}
	public Address(String buildingName, String street, String city, String state, String postalCode, String country) {
		super();
		this.buildingName = buildingName;
		this.street = street;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
		this.country = country;
	}
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	
	
	
	
}
	
	