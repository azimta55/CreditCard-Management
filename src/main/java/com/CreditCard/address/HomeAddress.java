package com.CreditCard.address;


import javax.persistence.Embeddable;


@Embeddable
public class HomeAddress extends Address {

	public HomeAddress() {
		super();
		
	}

	public HomeAddress(String buildingName, String street, String city, String state, String postalCode,
			String country) {
		super(buildingName, street, city, state, postalCode, country);
		
	}
	
	

}
