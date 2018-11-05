package org.jlobato.gpro.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import net.sf.ehcache.constructs.web.ShutdownListener;

/**
 * Sustituye al web.xml
 * 
 * @author JLOBATO
 *
 */
public class AppInitializer implements WebApplicationInitializer {

	/**
	 * En el arranque de la aplicación
	 */
	public void onStartup(ServletContext container) throws ServletException {
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.scan("org.jlobato.gpro");
        container.addListener(new ContextLoaderListener(context));
        container.addListener(new ShutdownListener());
 
        ServletRegistration.Dynamic dispatcher = container.addServlet("mvc.gpro", new DispatcherServlet(context));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
	}

}
