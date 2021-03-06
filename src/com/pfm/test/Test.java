package com.pfm.test;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.PropertyConfigurator;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Log4jConfigurer;
import org.springframework.web.util.Log4jWebConfigurer;

import com.pfm.dao.hibernate.TestDao;

@SuppressWarnings("deprecation")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
	"classpath:config/xml/applicationContext.xml"
})
public class Test {



	@Resource
	private TestDao testDao;

	@BeforeClass/*must be static function*/
	public static void config(){
		PropertyConfigurator.configure("resources/config/properties/log4j.properties");
	}

	@org.junit.Test
	public void test() {
		//fail("Not yet implemented");
		assertNotNull(testDao);
		com.pfm.bean.Test t = new com.pfm.bean.Test();
		t.setName("fadfsd");
		testDao.test(t);
		List list = testDao.list();
		System.out.println(list.size());
		for(Object o : list)
		{
			//testDao.delete((com.pfm.bean.Test) o);
			System.out.println(o);
		}

	}

}
