package spring_web_java_config_demo.config;

import java.security.spec.DSAGenParameterSpec;
import java.sql.Driver;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

@Configuration
public class RootConfig {

	private String jdbc_driver;
	private String jdbc_url;
	private String jdbc_username;
	private String jdbc_password;
	
		
	@Bean
	public DataSource dataSource() {

		BasicDataSource ds= new BasicDataSource();
			ds.setUsername(jdbc_username);
			ds.setPassword(jdbc_password);
			ds.setUrl(jdbc_url);
			ds.setDriverClassName(jdbc_driver);
			
		return ds;
	}
}
