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
		String sqlQuery = "INSERT INTO organization "
				+ "(company_name,year_of_incorporation, postal_code, employee_count, slogan)" + "VALUES(?,?,?,?,?)";
		Object[] args = new Object[] { organization.getCompanyName(), organization.getYearOfIncorporation(),
				organization.getPostalCode(), organization.getEmployeeCount(), organization.getSlogan() };

		return jdbcTemplate.update(sqlQuery, args) == 1;
	}

	@Override
	public Organization getOrganization(Integer id) {
		String sqlQuery = "SELECT id, company_name,year_of_incorporation, postal_code, employee_count, slogan "
				+ "FROM organization WHERE id = ?";
		Object[] args = new Object[] { id };
		Organization organization = jdbcTemplate.queryForObject(sqlQuery, args, new OrganizationRowMapper());

		return organization;
	}

	@Override
	public List<Organization> getAllOrganizations() {
		String sqlQuery = "SELECT * FROM organization";
		List<Organization> organizationList = jdbcTemplate.query(sqlQuery, new OrganizationRowMapper());

		return organizationList;
	}

	@Override
	public boolean delete(Organization organization) {
		String sqlQuery = "DELETE FROM organization WHERE id = ?";
		Object[] args = new Object[] {organization.getId()};
		return jdbcTemplate.update(sqlQuery, args) == 1;
	}

	@Override
	public boolean update(Organization organization) {
		String sqlQuery = "UPDATE organization SET slogan = ? WHERE id = ?";
		Object[] args = new Object[] { organization.getSlogan(), organization.getId() };

		return jdbcTemplate.update(sqlQuery, args) == 1;
	}

	@Override
	public void cleanup() {
		String sqlQuery = "TRUNCATE TABLE organization";
		jdbcTemplate.execute(sqlQuery);

	}

}
