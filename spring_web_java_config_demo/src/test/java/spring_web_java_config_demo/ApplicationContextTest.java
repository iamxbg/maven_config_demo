package spring_web_java_config_demo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import spring_web_java_config_demo.config.RootConfig;
import spring_web_java_config_demo.config.WebConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {RootConfig.class,WebConfig.class})
public class ApplicationContextTest implements ApplicationContextAware{

	private ApplicationContext ac;
	
	@Test
	public void testDataSourceNotNull() {
		
	
		
		System.out.println("Dude");
		
		System.out.println("applicationName:"+ac.getApplicationName());
	
		Assert.assertNotNull(ac);
		
		

	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		this.ac=applicationContext;
	}
	
}
