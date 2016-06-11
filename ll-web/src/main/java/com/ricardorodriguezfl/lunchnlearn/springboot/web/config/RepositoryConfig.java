package com.ricardorodriguezfl.lunchnlearn.springboot.web.config;

import com.ricardorodriguezfl.lunchnlearn.springboot.data.models.Person;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

/**
 * @author Ricardo "Rick" Rodriguez
 * @since 6/10/16.
 */
@Configuration
public class RepositoryConfig extends RepositoryRestMvcConfiguration {

    @Bean
    protected InitializingBean configureRepositoryRestJsonConfiguration(RepositoryRestConfiguration config) {
        return () -> {
            config.exposeIdsFor(Person.class);
        };
    }
}