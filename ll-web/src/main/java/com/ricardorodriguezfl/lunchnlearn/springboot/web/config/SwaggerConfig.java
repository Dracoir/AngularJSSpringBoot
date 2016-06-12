package com.ricardorodriguezfl.lunchnlearn.springboot.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Ricardo "Rick" Rodriguez
 * @since 6/10/16.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    //-----------------------------------------------------------------------------------------------------------------
    @Bean
    public Docket newsApi() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ricardorodriguezfl.lunchnlearn.springboot"))
                .paths(PathSelectors.any())
                .build();
        docket.pathMapping("/people_rest/");
        return docket;
    }

    //-----------------------------------------------------------------------------------------------------------------
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Person Repository")
                .description("Spring REST implementating, using Swagger")
                .termsOfServiceUrl("#")
                .contact("Ricardo Rodriguez")
                .license("Apache License Version 2.0")
                .licenseUrl("#")
                .version("1.0")
                .build();
    }
}
