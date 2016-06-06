package com.ricardorodriguezfl.lunchnlearn.springboot.data.config;

import com.ricardorodriguezfl.lunchnlearn.springboot.data.utilities.MyLogger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configures bean aspects for this library
 * 
 * @author Ricardo Rodriguez
 *
 */
@Configuration
public class AspectConfig {

    /**
     * Creates a MyLogger bean for this library
     * @return MyLogger
     */
	@Bean
	public MyLogger myLogger() {
		return new MyLogger();
	}
}
