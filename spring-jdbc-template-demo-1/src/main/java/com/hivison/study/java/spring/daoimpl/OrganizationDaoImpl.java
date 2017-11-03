package com.hivison.study.java.spring.daoimpl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hivison.study.java.spring.dao.OrganizationDAO;
import com.hivison.study.java.spring.domain.Organization;

@Repository("organizationDao")
public class OrganizationDaoImpl implements OrganizationDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {

		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public boolean create(Organization organization) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Organization getOrganization(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Organization> getAllOrganizations() {
		String sqlQuery = "SELECT * FROM organization";
		List<Organization> organizationList = jdbcTemplate.query(sqlQuery, new OrganizationRowMapper());

		return organizationList;
	}

	@Override
	public boolean delete(Organization organization) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Organization organization) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void cleanup() {
		// TODO Auto-generated method stub

	}

}
