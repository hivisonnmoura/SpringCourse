package com.hivison.study.java.spring.spring_demo;

public class Organization {
	
	private String company;
	private int yearOfIncorporation;
	
	
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
		return "Organization [company=" + company + ", yearOfIncorporation=" + yearOfIncorporation + "]";
	}

}
