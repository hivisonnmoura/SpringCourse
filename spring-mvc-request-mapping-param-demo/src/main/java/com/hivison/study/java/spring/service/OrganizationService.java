package com.hivison.study.java.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hivison.study.java.spring.dao.OrganizationDAO;
import com.hivison.study.java.spring.domain.Organization;

@Service
public class OrganizationService {

	@Autowired
	private OrganizationDAO organizationDAO;
	
	public List<Organization> getOrgList(){
		List<Organization> orgList = organizationDAO.getAllOrganizations();
		
		return orgList;
		
	}
}
