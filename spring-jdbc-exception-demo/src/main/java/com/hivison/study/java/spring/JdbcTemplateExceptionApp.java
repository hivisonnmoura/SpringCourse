package com.hivison.study.java.spring;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.util.SystemPropertyUtils;

import com.hivison.study.java.spring.dao.OrganizationDAO;
import com.hivison.study.java.spring.domain.Organization;

public class JdbcTemplateExceptionApp {
	
	public static void main(String[] args) {
		 // Create the application Context
		ApplicationContext  applicationContext = new ClassPathXmlApplicationContext("beans-cp.xml");
		
		//Create the bean
		OrganizationDAO organizationDao = (OrganizationDAO) applicationContext.getBean("organizationDao");
		List<Organization> organizationList = null;
		
		try {
			organizationList = organizationDao.getAllOrganizations();
		}catch(BadSqlGrammarException bge) {
			System.out.println("SUB EXCEPTION MESSAGE: " + bge.getMessage());
			System.out.println("SUB EXCEPTION CLASS: " + bge.getClass());
		}catch (DataAccessException dae) {
			System.out.println("EXCEPTION MESSAGE: " + dae.getMessage());
			System.out.println("EXCEPTION CLASS: " + dae.getClass());
		}
		
		organizationList.forEach(System.out::println);
		
		//Close the application context
		((ClassPathXmlApplicationContext) applicationContext).close();
	}

}
