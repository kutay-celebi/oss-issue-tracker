package com.kuartz.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;
import static springfox.documentation.spi.DocumentationType.SWAGGER_2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket workforceManagementApi() {
        return new Docket(SWAGGER_2)
                .groupName("public")
                .select()
                //.apis(withClassAnnotation(RestController.class))
                .paths(regex("/.*"))
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Rest Api microservice")
                .description("Microservice that handles todos")
                .termsOfServiceUrl("http://kutaycelebi.com")
                .contact(new Contact("Kutay Celebi",
                                     "http://kutaycelebi.com",
                                     "mail@kutaycelebi.com")) // email does not exist obviously
                .build();
    }

}
