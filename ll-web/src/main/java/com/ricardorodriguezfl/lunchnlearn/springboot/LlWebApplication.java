package com.ricardorodriguezfl.lunchnlearn.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;
import org.springframework.web.servlet.DispatcherServlet;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

/**
 * This is the main application class for this REST application
 * 
 * @author Ricardo Rodriguez
 *
 */
@SpringBootApplication
@EnableSwagger2
@PropertySource({"classpath:data.properties", "classpath:application.properties"})
@Import(RepositoryRestMvcConfiguration.class)
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

	
    public static void main(String[] args) {
        SpringApplication.run(LlWebApplication.class, args);
    }
}
