package com.hivison.study.java.spring.dao;

import java.util.List;

import javax.sql.DataSource;

import com.hivison.study.java.spring.domain.Organization;

public interface OrganizationDAO {
	
	// Set the data-source will be required to create a connection to the database.
	public void setDataSource(DataSource dataSource);
	
	// Create a record in the organization table.
	public boolean create(Organization organization);
	
	// Retrieve a single organization
	public Organization getOrganization(Integer  id);
	
	// Retrieve all organization from the table
	public List<Organization> getAllOrganizations();
	
	// Delete a specific organization from the table.
	public boolean delete (Organization organization);
	
	// Update an existing organization
	public boolean update (Organization organization);
	
	public void cleanup();

}
