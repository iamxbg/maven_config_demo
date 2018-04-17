package spring_web_java_config_demo.config;

import java.security.spec.DSAGenParameterSpec;
import java.sql.Driver;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Controller;

@Configuration
@ComponentScan(basePackages= {"spring_web_java_config_demo"}
	,excludeFilters= {@Filter(classes= {Configuration.class,Controller.class})})
public class RootConfig implements ApplicationContextAware{
	
	private ApplicationContext ac;

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
	

	@Bean
	@Autowired
	public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
		LocalSessionFactoryBean sf=new LocalSessionFactoryBean();
			sf.setDataSource(dataSource);
			sf.setPackagesToScan("spring_web_java_config_demo.entity");
			
			Properties props=ac.getResource(arg0)
			
			sf.setHibernateProperties(hibernateProperties);
			
			return sf;
	}


	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		this.ac=applicationContext;
	}
	
}
