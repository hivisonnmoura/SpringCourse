package com.hivison.study.java.spring.springdemo.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.hivison.study.java.spring.springdemo.service.BusinessService;

public class Organization {
	
	@Value("${org.postalCode}")
	private String postalCode;
	
	private String companyName;
	private int yearOfIncorporation;
	private int employeeCount;
	private String slogan;
	private BusinessService businessService;
	
	
	public Organization(){
		System.out.println("Default constrictor called");
	}

	public Organization(String companyName, int yearOfIncorporation) {

		this.companyName = companyName;
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
		System.out.println("Organization: postConstruct caleed ......................");
	}
	
	public void preDestroy() {
		System.out.println("Organization: preDestroy caleed ......................");
	}

	public String corporarteSlogan() {
		return slogan;
	}

	public String comporateService() {
		return businessService.offerService(companyName);
	}


	@Override
	public String toString() {
		return "Organization [postalCode=" + postalCode + ", companyName=" + companyName + ", yearOfIncorporation="
				+ yearOfIncorporation + ", employeeCount=" + employeeCount + ", slogan=" + slogan + "]";
	}



	public void setEmployeeCount(int employeeCount) {
		this.employeeCount = employeeCount;
		System.out.println("setEmplyeeCount called");
	}


	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
		System.out.println("setPostalCode called");
	}


	@Autowired
	public void setSlogan(@Value("${org.slogan}") String slogan) {
		this.slogan = slogan;
		System.out.println("setSlogan called");

	}



	public void setBusinessService(BusinessService businessService) {
		this.businessService = businessService;
		System.out.println("setBusinessService called");

	}

}
