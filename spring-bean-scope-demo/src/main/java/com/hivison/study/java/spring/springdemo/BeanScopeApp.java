package com.hivison.study.java.spring.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hivison.study.java.spring.springdemo.domain.Organization;

public class BeanScopeApp {

	public static void main(String[] args) {

		// Create the application context (container)
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cp.xml");

		// Create the bean
		Organization org = (Organization) ctx.getBean("myorg");

		Organization organization = (Organization) ctx.getBean("myorg");
		organization.setPostalCode("9898989");

		
		// Print organization details
		System.out.println(org);
		System.out.println(organization);
		if (org == organization) {
			System.out.println("Singleton scope test: org and org2 point to the same instance");
		} else {
			System.out.println("Both org and org2 are separate instances");
		}

		// Close the application context (container)
		((ClassPathXmlApplicationContext) ctx).close();

	}

}
