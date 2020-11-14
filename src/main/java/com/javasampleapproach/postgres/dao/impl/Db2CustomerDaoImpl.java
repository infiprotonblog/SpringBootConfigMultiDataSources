package com.javasampleapproach.postgres.dao.impl;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.javasampleapproach.postgres.dao.CustomerDao;
import com.javasampleapproach.postgres.model.Customer;

@Repository
public class Db2CustomerDaoImpl extends JdbcDaoSupport implements CustomerDao {

	@Autowired
	@Qualifier("db2.datasource")
	DataSource dataSource;

	@PostConstruct
	void init(){
		setDataSource(dataSource);
	}
	
	@Override
	public void insert(Customer cust) {
		String sql = "INSERT INTO customer " + "(CUST_ID, NAME, AGE) VALUES (?, ?, ?)";
		getJdbcTemplate().update(sql, new Object[] { cust.getCustId(), cust.getName(), cust.getAge() });
	}

}
