package com.hivison.study.java.spring.springdemo.domain;


import com.hivison.study.java.spring.springdemo.service.RecruitmentService;

public class HumanResoucesDepart implements Department {
	
	private String deptName;
	private RecruitmentService recruitmentService;
	private Organization organization;
	
	

	public HumanResoucesDepart(RecruitmentService recruitmentService, Organization organization) {
		super();
		this.recruitmentService = recruitmentService;
		this.organization = organization;
	}



	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}



	public String hiringStatus(int numberOfRecruitments) {
		String hiringFacts = recruitmentService.recruitEmployees(organization.getCompanyName(), 
				deptName, numberOfRecruitments);
		return hiringFacts;
	}

}
