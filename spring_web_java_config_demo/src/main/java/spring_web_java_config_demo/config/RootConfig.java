package spring_web_java_config_demo.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.sql.DataSource;
import javax.transaction.TransactionManager;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
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
	public LocalSessionFactoryBean sessionFactory() throws IOException {
		LocalSessionFactoryBean sf=new LocalSessionFactoryBean();
			sf.setDataSource(dataSource());
			sf.setPackagesToScan("spring_web_java_config_demo.entity");
			
			Properties props=new Properties();
			InputStream is=this.getClass().getClassLoader().getResourceAsStream("hibernate.properties");
			if(is==null) {
				System.out.println("inputstream is null");
			}
			props.load(is);

			sf.setHibernateProperties(props);
			
			return sf;
	}

	@Bean("transactionManager")
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager htm=new HibernateTransactionManager(sessionFactory);

		return htm;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		this.ac=applicationContext;
	}
	
}
