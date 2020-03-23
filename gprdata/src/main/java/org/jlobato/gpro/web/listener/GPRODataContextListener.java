package org.jlobato.gpro.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author JLOBATO
 *
 */
public class GPRODataContextListener implements ServletContextListener {
	
	/**
	 * 
	 */
	private static final Logger logger = LoggerFactory.getLogger(GPRODataContextListener.class);

	/**
	 * 
	 */
	public void contextDestroyed(ServletContextEvent evt) {
		logger.info("GPRO Data contextDestroyed");
	}

	/**
	 * 
	 */
	public void contextInitialized(ServletContextEvent evt) {		
		logger.info("GPRO Data contextInitialized");
		logger.info("GPRO deploy dir: {}", evt.getServletContext().getRealPath("/"));
		//TODO Cambiar las propiedades del generatorConfig.xml para que los directorios y propiedades de conexión a la base de datos no estén a huevo
		//TODO Conseguir varias estas propiedades en función del entorno
	}

}
