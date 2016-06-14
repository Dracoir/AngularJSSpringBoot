package com.ricardorodriguezfl.lunchnlearn.springboot.web.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Ricardo "Rick" Rodriguez
 * @since 6/13/16.
 */
@Configuration
@ConfigurationProperties(prefix="sample")
@PropertySource("classpath:sample.properties")
public class SampleProperties {

    private String firstName;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
