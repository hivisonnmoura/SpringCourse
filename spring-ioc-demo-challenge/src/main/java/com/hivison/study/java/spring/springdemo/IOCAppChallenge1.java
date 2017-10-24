package com.hivison.study.java.spring.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class IOCAppChallenge1 {
	
	public static void main(String[] args) {
		
		//Create application context
		ApplicationContext applicationContext = new FileSystemXmlApplicationContext("beans-challenge.xml");
		
		//Create bean
		City city = (City) applicationContext.getBean("beanChallenge");
		
		//Invoke city name by bean
		city.cityName();
		
		//Close the application context
		((FileSystemXmlApplicationContext) applicationContext).close();
	}

}
