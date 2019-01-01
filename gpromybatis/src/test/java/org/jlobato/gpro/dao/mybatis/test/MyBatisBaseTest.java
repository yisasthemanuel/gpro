package org.jlobato.gpro.dao.mybatis.test;

import org.junit.After;
import org.junit.Before;
import org.springframework.context.support.ClassPathXmlApplicationContext;;

public class MyBatisBaseTest {
	protected ClassPathXmlApplicationContext contexto = null;

	@Before
	public void setUp() throws Exception {
		//Cargamos el contexto spring (el mismo contexto que la aplicación web)
		contexto = new ClassPathXmlApplicationContext("/spring-applicationContext.xml");
		
	}

	@After
	public void tearDown() throws Exception {
		contexto.close();
	}
	
}
