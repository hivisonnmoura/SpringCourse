package com.hivison.study.java.spring.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCAppChallenge2 {
	
	public static void main(String[] args) {
		
		//Create application context
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans-challenge.xml");
		
		//Create bean
		City city = (City) applicationContext.getBean("beanChallenge");
		
		//Invoke the method cityName by bean
		city.cityName();
		
		//Close appliation context
		((ClassPathXmlApplicationContext) applicationContext).close();
		
	}

}
