package com.ricardorodriguezfl.lunchnlearn.springboot.data.config;

import com.ricardorodriguezfl.lunchnlearn.springboot.data.models.Person;
import com.ricardorodriguezfl.lunchnlearn.springboot.data.services.PersonService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configures data-related beans for this application
 * 
 * @author Ricardo Rodriguez
 *
 */
@Configuration
public class DataConfig {

    /**
     * This is a simple initialization method, introduced in the early days of Spring.
     * This method is called after the method parameter bean has been initialized.
     * @param personService PersonService used to access the data
     * @return InitializingBean
     */
	@Bean
	public InitializingBean getPersonService(PersonService personService) {
		return () -> {
			personService.savePerson(new Person("Rick", "Rodriguez"));
			personService.savePerson(new Person("John", "Smith"));
			personService.savePerson(new Person("Jennifer", "Jones"));
			personService.savePerson(new Person("Bob", "Jones"));
		};
	}
	
}
