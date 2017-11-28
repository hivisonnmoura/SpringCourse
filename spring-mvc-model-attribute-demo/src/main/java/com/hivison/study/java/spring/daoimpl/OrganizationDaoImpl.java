package com.hivison.study.java.spring.daoimpl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.hivison.study.java.spring.dao.OrganizationDAO;
import com.hivison.study.java.spring.domain.Organization;

@Repository
public class OrganizationDaoImpl implements OrganizationDAO {

	private NamedParameterJdbcTemplate namedParamJdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {

		namedParamJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	public boolean create(Organization organization) {
		SqlParameterSource beanParams = new BeanPropertySqlParameterSource(organization);
		String sqlQuery = "INSERT INTO organization "
				+ "(company_name,year_of_incorporation, postal_code, employee_count, slogan)"
				+ " VALUES(:companyName,:yearOfIncorporation,:postalCode,:employeeCount,:slogan)";

		return namedParamJdbcTemplate.update(sqlQuery, beanParams) == 1;

	}

	@Override
	public Organization getOrganization(Integer id) {
		SqlParameterSource params = new MapSqlParameterSource("ID", id);
		String sqlQuery = "SELECT id, company_name, year_of_incorporation, postal_code, employee_count, slogan "
				+ "FROM organization WHERE id = :ID";

		Organization org = namedParamJdbcTemplate.queryForObject(sqlQuery, params, new OrganizationRowMapper());
		return org;

	}

	@Override
	public List<Organization> getAllOrganizations() {
		String sqlQuery = "SELECT * FROM organization";
		List<Organization> organizationList = namedParamJdbcTemplate.query(sqlQuery, new OrganizationRowMapper());

		return organizationList;
	}

	@Override
	public boolean delete(Organization organization) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(organization);
		String sqlQuery = "DELETE FROM organization WHERE id = :id";

		return namedParamJdbcTemplate.update(sqlQuery, params) == 1;
	}

	@Override
	public boolean update(Organization organization) {
		SqlParameterSource beanParams = new BeanPropertySqlParameterSource(organization);
		String sqlQuery = "UPDATE organization SET slogan = :slogan WHERE id = :id";
		return namedParamJdbcTemplate.update(sqlQuery, beanParams) == 1;
	}

	@Override
	public void cleanup() {
		String sqlQuery = "TRUNCATE TABLE organization";
		namedParamJdbcTemplate.getJdbcOperations().execute(sqlQuery);

	}

}
