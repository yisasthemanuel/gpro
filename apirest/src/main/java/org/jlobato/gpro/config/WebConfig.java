package org.jlobato.gpro.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Configuración de Spring por anotaciones
 * 
 * @author JLOBATO
 *
 */
@Configuration
@EnableWebMvc
@PropertySource("classpath:/config.properties")
@ComponentScan(basePackages = "org.jlobato.gpro")
@ImportResource("classpath:/spring-database.xml")
public class WebConfig {
	
	/**
	 * Para que los propiedades estén disponibles en los XMLs de configuración
	 * 
	 * @return
	 */
	@Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }	

}
