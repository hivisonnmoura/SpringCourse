package com.hivison.study.java.spring;

import com.hivison.study.java.spring.dao.OrganizationDAO;
import com.hivison.study.java.spring.domain.Organization;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
@Service
public class DaoUtils {

	public final String createOperation = "CREATE";
	public final String readOperation = "READ";
	public final String updateOperation = "UPDATE";
	public final String deleteOperation = "DELETE";
	public final String cleanupOperation = "TRUNCATE";

	public void printOrganizations(List<Organization> orgs, String operation) {
		System.out.println("\n********* Printing organizations after " + operation + " operation *********");
		orgs.forEach(System.out::println);
	}

	public void printOrganization(Organization organization, String operation) {
		System.out.println("\n********* Printing organization after invoking " + operation + " operation *********\n"
				+ organization);
	}

	public void printSuccessFailure(String operation, boolean param) {
		if (param)
			System.out.println("\nOperation " + operation + " successful");
		else
			System.out.println("\nOperation " + operation + " failed");
	}
	
	public void createSeedData(OrganizationDAO dao) {
        Organization organization1 = new Organization("Amazon", 1994, "65656", 8765, "Work hard, have fun, make history");
        Organization organization2 = new Organization("BMW", 1929, "45454", 5501, "We build ultimate Driving machines");
		Organization organization3 = new Organization("Google", 1996, "57575", 4567, "Don't be evil");

		List<Organization> orgs = new ArrayList<>();
		orgs.add(0, organization1);
		orgs.add(1, organization2);
		orgs.add(2, organization3);

        long createCount = orgs.stream().filter(org -> dao.create(org)).count();

		System.out.println("Created " + createCount + " organizations");
	}

	public void printOrganizationCount(List<Organization> orgs, String operation) {
		System.out.println("\n********* Currently we have " + orgs.size() + " organizations after " + operation
				+ " operation *********");
	}

}
