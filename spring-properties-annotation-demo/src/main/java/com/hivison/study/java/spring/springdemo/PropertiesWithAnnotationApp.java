package com.hivison.study.java.spring.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.hivison.study.java.spring.springdemo.domain.Organization;


public class PropertiesWithAnnotationApp {

	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(PropertyConfig.class);
		Organization org  = (Organization) context.getBean("myorg");
		System.out.println(org);
		System.out.println("Slogan: " + org.corporarteSlogan());
		((AnnotationConfigApplicationContext) context).close();
	}

}
