package com.hivison.study.java.spring.springdemo.serviceImpl;

import java.util.Random;

import com.hivison.study.java.spring.springdemo.service.RecruitmentService;

public class AgencyRecruitmentServiceImpl implements RecruitmentService {

	public String recruitEmployees(String companyName, String departmentName, int numberOfRecruitments) {
		Random random = new Random();
		
		StringBuilder hiringFacts = new StringBuilder();
		
		hiringFacts.append("\n" + companyName + "'s ");
		hiringFacts.append(departmentName + " hired ");
		hiringFacts.append(random.nextInt(numberOfRecruitments) + " employees ");
		hiringFacts.append("using varios hiring agencies.");
		
		return hiringFacts.toString();
	}

}
