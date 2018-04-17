package sping_web_xml_config_demo;

import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class ApplicationContextTest {

	
	public static void main(String... args) {
		
		ApplicationContext ac=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		
	}
	
}
