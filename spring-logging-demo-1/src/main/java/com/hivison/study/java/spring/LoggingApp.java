package com.hivison.study.java.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.hivison.study.java.spring.dao.OrganizationDAO;
import com.hivison.study.java.spring.domain.Organization;

@Component
public class LoggingApp {

	@Autowired
	private OrganizationDAO dao;
	@Autowired
	private DaoUtils daoUtils;

	public void actionMethod() {
		
		// Creating seed data.
		daoUtils.createSeedData(dao);

		// List organizations
		List<Organization> orgs = dao.getAllOrganizations();
		daoUtils.printOrganizations(orgs, daoUtils.readOperation);

		// Create a new organization record
		Organization org = new Organization("General Electric", 1978, "98989", 5776, "Imagination at work");
		boolean isCreated = dao.create(org);
		daoUtils.printSuccessFailure(daoUtils.createOperation, isCreated);
		daoUtils.printOrganizations(dao.getAllOrganizations(), daoUtils.readOperation);

		// get a single organization
		Organization org2 = dao.getOrganization(1);
		daoUtils.printOrganization(org2, "getOrganization");

		// Updating a slogan for an organization
		Organization org3 = dao.getOrganization(2);
		org3.setSlogan("We build ** awesome ** driving machines!");
		boolean isUpdated = dao.update(org3);
		daoUtils.printSuccessFailure(daoUtils.updateOperation, isUpdated);
		daoUtils.printOrganization(dao.getOrganization(2), daoUtils.updateOperation);

		// Delete an organization
		boolean isDeleted = dao.delete(dao.getOrganization(3));
		daoUtils.printSuccessFailure(daoUtils.deleteOperation, isDeleted);
		daoUtils.printOrganizations(dao.getAllOrganizations(), daoUtils.deleteOperation);

		// Cleanup
		dao.cleanup();
		daoUtils.printOrganizationCount(dao.getAllOrganizations(), daoUtils.cleanupOperation);

	}

	public static void main(String[] args) {
		// Create the application Context
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans-cp.xml");
		LoggingApp mainApp = applicationContext.getBean(LoggingApp.class);
		mainApp.actionMethod();

		// Close the application context
		((ClassPathXmlApplicationContext) applicationContext).close();
	}

}
