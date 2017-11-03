package com.hivison.study.java.spring;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hivison.study.java.spring.dao.OrganizationDAO;
import com.hivison.study.java.spring.domain.Organization;

public class JdbcTemplateClassicApp2 {

	public static void main(String[] args) {
		// Create the application Context
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans-cp.xml");

		// Create the bean
		OrganizationDAO organizationDao = (OrganizationDAO) applicationContext.getBean("organizationDao");

		// Create seedData
		DaoUtils.createSeedData(organizationDao);

		// List the organizations
		List<Organization> organizations = organizationDao.getAllOrganizations();
		DaoUtils.printOrganizations(organizations, DaoUtils.readOperation);

		// Create a new organization record
		Organization organization = new Organization("General Electric", 1978, "98989", 5776, "Imagination at work");
		boolean isCreated = organizationDao.create(organization);
		DaoUtils.printSuccessFailure(DaoUtils.createOperation, isCreated);
		DaoUtils.printOrganizationCount(organizationDao.getAllOrganizations(), DaoUtils.createOperation);
		DaoUtils.printOrganizations(organizationDao.getAllOrganizations(), DaoUtils.readOperation);

		// Get a single organization
		Organization organization2 = organizationDao.getOrganization(1);
		DaoUtils.printOrganization(organization2, "getOrganization");

		// Updating a slogan for an organization
		Organization organization3 = organizationDao.getOrganization(2);
		organization3.setSlogan("We build ** awesome ** driving machines !");
		boolean isUpdated = organizationDao.update(organization3);
		DaoUtils.printSuccessFailure(DaoUtils.updateOperation, isUpdated);
		DaoUtils.printOrganization(organizationDao.getOrganization(2), DaoUtils.updateOperation);
		
		//Delete an organization
		boolean isDeleted = organizationDao.delete(organizationDao.getOrganization(3));
		DaoUtils.printSuccessFailure(DaoUtils.delateOperation, isDeleted);
		DaoUtils.printOrganizations(organizationDao.getAllOrganizations(), DaoUtils.delateOperation);

		// Cleanup
		organizationDao.cleanup();
		DaoUtils.printOrganizationCount(organizationDao.getAllOrganizations(), DaoUtils.cleanupOperation);

		// Close the application context
		((ClassPathXmlApplicationContext) applicationContext).close();
	}

}
