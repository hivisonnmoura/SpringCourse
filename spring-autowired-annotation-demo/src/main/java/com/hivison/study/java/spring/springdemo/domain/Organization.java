package com.hivison.study.java.spring.springdemo.domain;

import com.hivison.study.java.spring.springdemo.service.BusinessService;

public class Organization {
	
	private String companyName;
	private int yearOfIncorporation;
	private String postalCode;
	private int employeeCount;
	private String slogan;
	private BusinessService businessService;
	
	
	public Organization(){
		System.out.println("Default constrictor called");
	}

	public Organization(String company, int yearOfIncorporation) {
		super();
		this.companyName = company;
		this.yearOfIncorporation = yearOfIncorporation;
		System.out.println("Constructor called");
	}
/*
	public void initialize() {
		System.out.println("Organization: initialize method called");
	}
	
	public void destroy() {
		System.out.println("Organization: destroy method called");
	}
	
*/
	public void postConstruct() {
		System.out.println("Oranization: postConstruct caleed ......................");
	}
	
	public void preDestroy() {
		System.out.println("Oranization: preDestroy caleed ......................");
	}

	public String corporarteSlogan() {
		return slogan;
	}

	public String comporateService() {
		return businessService.offerService(companyName);
	}


	@Override
	public String toString() {
		return "Organization [companyName=" + companyName + ", yearOfIncorporation=" + yearOfIncorporation + ", postalCode="
				+ postalCode + ", employeeCount=" + employeeCount + "]";
	}



	public void setEmployeeCount(int employeeCount) {
		this.employeeCount = employeeCount;
		System.out.println("setEmplyeeCount called");
	}


	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
		System.out.println("setPostalCode called");
	}



	public void setSlogan(String slogan) {
		this.slogan = slogan;
		System.out.println("setSlogan called");

	}



	public void setBusinessService(BusinessService businessService) {
		this.businessService = businessService;
		System.out.println("setBusinessService called");

	}

}
