package com.hivison.study.java.spring.domain;

public class Address {

	private String street;
	private String city;
	private String zipCode;

	

	@Override
	public String toString() {
		return "Address [street=" + street + ", city=" + city + ", zipCode=" + zipCode + "]";
	}



	public void setStreet(String street) {
		this.street = street;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

}
