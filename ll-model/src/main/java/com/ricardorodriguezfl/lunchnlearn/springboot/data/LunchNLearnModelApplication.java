package com.ricardorodriguezfl.lunchnlearn.springboot.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

/**
 * This is the main application class for this library.
 * 
 * @author Ricardo Rodriguez
 *
 */
@SpringBootApplication
@PropertySource("classpath:data.properties")
public class LunchNLearnModelApplication {

    public static void main(String[] args) {
        SpringApplication.run(LunchNLearnModelApplication.class, args);
    }
}
