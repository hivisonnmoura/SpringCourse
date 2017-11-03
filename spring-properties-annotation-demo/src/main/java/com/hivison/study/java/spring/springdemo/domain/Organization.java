package com.hivison.study.java.spring.springdemo.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.hivison.study.java.spring.springdemo.service.BusinessService;

@Component("myorg")
public class Organization {
	
	@Value("${nameOfCompany}")
	private String companyName;
	
	@Value("${startUpYear}")
	private int yearOfIncorporation;
	
	@Value("${postalCode}")
	private String postalCode;
	
	@Value("${empCount:222222}")
	private int employeeCount;
	
	@Value("${corporateSlogan:We build world class software!}")
	private String slogan;
	
	private String missionStatement;
	
	@Autowired
	private Environment env;
	
	private BusinessService businessService;
	
	
	public Organization(){
		System.out.println("Default constrictor called");
	}

	public Organization(String company, int yearOfIncorporation) {
		this.companyName = company;
		this.yearOfIncorporation = yearOfIncorporation;
		System.out.println("Constructor called");
	}
	
	public String corporarteSlogan() {
		missionStatement = env.getProperty("statement");
		return missionStatement + " and also " + slogan;
	}

	public void postConstruct() {
		System.out.println("Oranization: postConstruct caleed ......................");
	}
	
	public void preDestroy() {
		System.out.println("Oranization: preDestroy caleed ......................");
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
