package com.ltk.api.solar.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.TransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import static com.ltk.api.solar.SolarApplication.CONFIGURATION;

@Log4j2
@Configuration
@EnableJpaRepositories(basePackages = "com.ltk.api.solar.repositories", repositoryImplementationPostfix = "Impl")
public class DatabaseConfiguration {
	
	@Bean
	public EntityManagerFactory entityManagerFactory() {
		
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		factory.setPackagesToScan("com.ltk.api.solar.models");
		factory.setDataSource(dataSource());
		factory.afterPropertiesSet();
		
		return factory.getObject();
	}
	
	@Bean
	public DataSource dataSource() {
		
		if(CONFIGURATION == EConfiguration.DESENVOLVIMENTO) {
			
			DriverManagerDataSource dataSource = new DriverManagerDataSource();
			dataSource.setDriverClassName("org.postgresql.Driver");
			dataSource.setUrl("jdbc:postgresql://localhost:5432/postgres");
			dataSource.setUsername("api");
			dataSource.setPassword("1823205");
			
			return dataSource;
		} else {
			
			throw new RuntimeException("Datasource não foi definido para a produção!");
			
		}
	}
	
	@Bean
	public TransactionManager transactionManager() {
		
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
		transactionManager.setDataSource(dataSource());
		
		return transactionManager;
	}
	
}
