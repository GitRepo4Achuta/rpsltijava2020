package com.lti.inventory.configurations;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@Data
public class DbConfiguration {

	@Value("${db_url}")
	private String url;
	@Value("${username}")
	private String userName;
	@Value("${password}")
	private String password;
	@Value("${driver-class-name}")
	private String driverClassName;
	
	private DataSourceBuilder dataSourceBuilder;
	
	@Bean
	public DataSource getDataSource()
	{
		dataSourceBuilder=DataSourceBuilder.create();
		dataSourceBuilder.driverClassName(driverClassName);
		dataSourceBuilder.url(url);
		dataSourceBuilder.username(userName);
		dataSourceBuilder.password(password);		
		return dataSourceBuilder.build();		
		
	}
	
	
	
}
