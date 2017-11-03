package com.hivison.study.java.spring;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hivison.study.java.spring.dao.OrganizationDAO;
import com.hivison.study.java.spring.domain.Organization;

public class JdbcTemplateClassicApp1 {
	
	public static void main(String[] args) {
		 // Create the application Context
		ApplicationContext  applicationContext = new ClassPathXmlApplicationContext("beans-cp.xml");
		
		//Create the bean
		OrganizationDAO organizationDao = (OrganizationDAO) applicationContext.getBean("organizationDao");
		List<Organization> organizationList = organizationDao.getAllOrganizations();
		
		organizationList.forEach(System.out::println);
		
		//Close the application context
		((ClassPathXmlApplicationContext) applicationContext).close();
	}

}
