package com.hivison.study.java.spring.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hivison.study.java.spring.springdemo.domain.Organization;

public class PropertiesWithXMLApp {

	public static void main(String[] args) {
		
		// Create the application context (container)
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cp.xml");
		
	
		Organization organization = (Organization) ctx.getBean("myorg");
		System.out.println(organization);
		
		//Close the application context (container)
		((ClassPathXmlApplicationContext) ctx).close();

	}

}
