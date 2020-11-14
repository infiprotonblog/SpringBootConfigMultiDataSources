package com.javasampleapproach.postgres;

import java.util.Random;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.javasampleapproach.postgres.dao.CustomerDao;
import com.javasampleapproach.postgres.dao.impl.Db1CustomerDaoImpl;
import com.javasampleapproach.postgres.dao.impl.Db2CustomerDaoImpl;
import com.javasampleapproach.postgres.model.Customer;

@SpringBootApplication
public class ConfigurationMultiDatasourceApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ConfigurationMultiDatasourceApplication.class, args);
		CustomerDao db1CustomerDao = context.getBean(Db1CustomerDaoImpl.class);
		CustomerDao db2CustomerDao = context.getBean(Db2CustomerDaoImpl.class);

		Random r = new Random();
		Customer cust = new Customer();
		Long id = r.nextLong();
		cust.setCustId(id);
		cust.setName("John");
		cust.setAge(30);
		
		db1CustomerDao.insert(cust);
		db2CustomerDao.insert(cust);
	}
}
