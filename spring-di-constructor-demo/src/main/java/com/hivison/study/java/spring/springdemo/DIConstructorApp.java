package com.hivison.study.java.spring.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hivison.study.java.spring.springdemo.domain.HumanResoucesDepart;
import com.hivison.study.java.spring.springdemo.domain.Organization;

public class DIConstructorApp {

	public static void main(String[] args) {
		
		// Create the application context (container)
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cp.xml");
		
		// Create the bean
		Organization org = (Organization) ctx.getBean("myorg");
		
		//Invoke the company slogan via the bean
		System.out.println(org.corporarteSlogan());
		
		//Print organization details
		HumanResoucesDepart depart = (HumanResoucesDepart) ctx.getBean("myhrdept");
		System.out.println(depart.hiringStatus(5500));
		
		//Close the application context (container)
		((ClassPathXmlApplicationContext) ctx).close();

	}

}
