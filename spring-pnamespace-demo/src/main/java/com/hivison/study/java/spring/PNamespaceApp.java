package com.hivison.study.java.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hivison.study.java.spring.domain.Organization;

public class PNamespaceApp {

	public static void main(String[] args) {
		
		// Create the application context (container)
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cp.xml");
		
		// Create the bean
		Organization org = (Organization) ctx.getBean("myorg");
		
		
		//Pring organization details
		System.out.println(org);
		
		//Close the application context (container)
		((ClassPathXmlApplicationContext) ctx).close();

	}

}
