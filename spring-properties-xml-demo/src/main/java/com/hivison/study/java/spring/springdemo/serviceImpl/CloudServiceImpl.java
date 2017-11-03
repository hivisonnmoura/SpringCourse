package com.hivison.study.java.spring.springdemo.serviceImpl;

import java.util.Random;

import com.hivison.study.java.spring.springdemo.service.BusinessService;

public class CloudServiceImpl  implements BusinessService{

	public String offerService(String companyName) {
		
		Random random = new Random();
		String service = "\nAs an Organization, " + companyName +
				" offers world class Cloud computing infrastructure. " +
				"\nThe annual income exceeds " + random.nextInt(revenue) + " dollars.";
		return service;
		
	}
	
	public void postConstruct() {
		System.out.println("CloudService: postConstruct caleed ......................");
	}
	
	public void preDestroy() {
		System.out.println("CloudService: preDestroy caleed ......................");
	}
	

}
