package com.ricardorodriguezfl.lunchnlearn.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * This is the main application class for this REST application
 * 
 * @author Ricardo Rodriguez
 *
 */
@SpringBootApplication
@PropertySource({"classpath:data.properties", "classpath:application.properties"})
public class LlWebApplication {

    //-----------------------------------------------------------------------------------------------------------------
    @Bean
    public DispatcherServlet dispatcherServlet() {
    	DispatcherServlet dispatcherServlet = new DispatcherServlet();
    	return dispatcherServlet;
    }

	//-----------------------------------------------------------------------------------------------------------------
    /**
     * Configures the servlet url-mapping(s)
     * 
     * @param dispatcherServlet DispatcherServlet
     * @return ServletRegistrationBean
     */
    @Bean
    public ServletRegistrationBean dispatcherRegistration(DispatcherServlet dispatcherServlet) {
        ServletRegistrationBean registration = new ServletRegistrationBean(
                dispatcherServlet);
        registration.addUrlMappings("/people_rest/*"); // You can add additional mappings here
        return registration;
    }

    //-----------------------------------------------------------------------------------------------------------------
    public static void main(String[] args) {
        SpringApplication.run(LlWebApplication.class, args);
    }
}
