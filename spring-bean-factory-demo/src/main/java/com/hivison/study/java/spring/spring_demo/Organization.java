package com.hivison.study.java.spring.spring_demo;

public class Organization {
	
	private String companyName;
	private int yearOfIncorporation;
	
	
	public Organization(String companyName, int yearOfIncorporation) {
		super();
		this.companyName = companyName;
		this.yearOfIncorporation = yearOfIncorporation;
	}



	public void corporarteSlogan() {
		
		String slogan = " We build the ultimate driving machine !";
		System.out.println(slogan);
	}
	
	public static Organization createInstance(String companyName, int yearOfIncorporation) {
		System.out.println("Invoke the static factory method..............");
		return new Organization(companyName, yearOfIncorporation);
	}



	@Override
	public String toString() {
		return "Organization [companyName=" + companyName + ", yearOfIncorporation=" + yearOfIncorporation + "]";
	}

}
