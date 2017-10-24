package com.hivison.study.java.spring.spring_demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class IOCApp1 {

	public static void main(String[] args) {
		
		// Create the application context (container)
		ApplicationContext ctx = new FileSystemXmlApplicationContext("beans.xml");
		
		// Create the bean
		Organization org = (Organization) ctx.getBean("myorg");
		
		//Invoke the company slogan via the bean
		org.corporarteSlogan();
		
		//Close the application context (container)
		((FileSystemXmlApplicationContext) ctx).close();

	}

}
