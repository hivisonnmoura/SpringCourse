package com.hivison.study.java.spring.spring_demo;

public class OrganizationFactory {
	
	public Organization getInstance(String companyName, int yearOfIncorporation) {
		System.out.println("Invoke instance factory method.........");
		return new Organization(companyName, yearOfIncorporation);
	}

}
