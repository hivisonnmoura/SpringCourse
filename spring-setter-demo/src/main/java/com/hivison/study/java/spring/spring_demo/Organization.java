package com.hivison.study.java.spring.spring_demo;

public class Organization {
	
	private String company;
	private int yearOfIncorporation;
	private String postalCode;
	private int employeeCount;
	
	
	


	public Organization(String company, int yearOfIncorporation) {
		super();
		this.company = company;
		this.yearOfIncorporation = yearOfIncorporation;
	}



	public void corporarteSlogan() {
		
		String slogan = " We build the ultimate driving machine !";
		System.out.println(slogan);
	}



	@Override
	public String toString() {
		return "Organization [company=" + company + ", yearOfIncorporation=" + yearOfIncorporation + ", postalCode="
				+ postalCode + ", employeeCount=" + employeeCount + "]";
	}



	public void setEmployeeCount(int employeeCount) {
		this.employeeCount = employeeCount;
	}


	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

}
