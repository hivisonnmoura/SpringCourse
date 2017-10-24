package com.hivison.study.java.spring.springdemo.domain;

import com.hivison.study.java.spring.springdemo.service.BusinessService;

public class Organization {
	
	private String companyName;
	private int yearOfIncorporation;
	private String postalCode;
	private int employeeCount;
	private String slogan;
	private BusinessService businessService;
	

	public Organization(String company, int yearOfIncorporation) {
		super();
		this.companyName = company;
		this.yearOfIncorporation = yearOfIncorporation;
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
	}


	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}



	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}



	public void setBusinessService(BusinessService businessService) {
		this.businessService = businessService;
	}

}
