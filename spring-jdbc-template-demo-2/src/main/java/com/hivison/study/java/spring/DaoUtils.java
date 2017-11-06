package com.hivison.study.java.spring;

import com.hivison.study.java.spring.dao.OrganizationDAO;
import com.hivison.study.java.spring.domain.Organization;

import java.util.ArrayList;
import java.util.List;

public class DaoUtils {

	public static final String createOperation = "CREATE";
	public static final String readOperation = "READ";
	public static final String updateOperation = "UPDATE";
	public static final String delateOperation = "DELETE";
	public static final String cleanupOperation = "TRUNCATE";

	public static void printOrganizations(List<Organization> orgs, String operation) {
		System.out.println("\n********* Printing organizations after " + operation + " operation *********");
		orgs.forEach(System.out::println);
	}

	public static void printOrganization(Organization organization, String operation) {
		System.out.println("\n********* Printing organization after invoking " + operation + " operation *********\n"
				+ organization);
	}

	public static void printSuccessFailure(String operation, boolean param) {
		if (param)
			System.out.println("\nOperation " + operation + " successful");
		else
			System.out.println("\nOperation " + operation + " failed");
	}

	public static void createSeedData(OrganizationDAO dao) {
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

	public static void printOrganizationCount(List<Organization> orgs, String operation) {
		System.out.println("\n********* Currently we have " + orgs.size() + " organizations after " + operation
				+ " operation *********");
	}

}
