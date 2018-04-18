package spring_web_java_config_demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import spring_web_java_config_demo.config.RootConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {RootConfig.class})
public class HibernateTest {
	
	@Autowired
	private SessionFactory sf;
	
	@Test
	public void testShowUserName() {
		
		Session sess=sf.openSession();
		
			
		List<?> result=sess.createQuery("from User").list();
		
		for(Object x : result) {
			Object[] z=(Object[])x;
			for(Object k : z) {
				System.out.println(k);
			}
		}
		
	}

}
