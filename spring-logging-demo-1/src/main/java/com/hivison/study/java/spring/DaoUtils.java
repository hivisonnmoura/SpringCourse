package com.hivison.study.java.spring;

import com.hivison.study.java.spring.dao.OrganizationDAO;
import com.hivison.study.java.spring.domain.Organization;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
@Service
public class DaoUtils {

	private static Logger LOG  = LoggerFactory.getLogger(DaoUtils.class);
	
	public final String createOperation = "CREATE";
	public final String readOperation = "READ";
	public final String updateOperation = "UPDATE";
	public final String deleteOperation = "DELETE";
	public final String cleanupOperation = "TRUNCATE";

	public void printOrganizations(List<Organization> orgs, String operation) {
		LOG.info("\n********* Printing organizations after " + operation + " operation *********");
		orgs.forEach(org -> LOG.info(org.toString()));
	}

	public void printOrganization(Organization organization, String operation) {
		LOG.info("\n********* Printing organization after invoking " + operation + " operation *********\n"
				+ organization);
	}

	public void printSuccessFailure(String operation, boolean param) {
		if (param)
			LOG.info("\nOperation " + operation + " successful");
		else
			LOG.info("\nOperation " + operation + " failed");
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

		LOG.info("Created " + createCount + " organizations");
	}

	public void printOrganizationCount(List<Organization> orgs, String operation) {
		LOG.info("\n********* Currently we have " + orgs.size() + " organizations after " + operation
				+ " operation *********");
	}

}
