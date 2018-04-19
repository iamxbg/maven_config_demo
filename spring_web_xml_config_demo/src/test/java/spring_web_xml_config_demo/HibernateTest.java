package spring_web_xml_config_demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spring_web_xml_config_demo.entity.UserT;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:applicationContext.xml","classpath:dispatcher-servlet.xml"})
public class HibernateTest {
	
	
	@Autowired
	private SessionFactory sf;
	
	@Test
	public void assertSessionFactoryNotNull() {
		Assert.assertNotNull(sf);
	}
	
	@Test
	public void testShowUserName() {
		Session sess=sf.openSession();
			
		UserT user=sess.createQuery("from UserT u",UserT.class).uniqueResult();
		
		System.out.println(user.getName());
		
	}

}
