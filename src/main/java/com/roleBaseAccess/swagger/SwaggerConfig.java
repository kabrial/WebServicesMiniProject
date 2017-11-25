package com.roleBaseAccess.swagger;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket postsApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("com.roleBaseAccess.restcontroller")
                .apiInfo(apiInfo()).select().paths(regex("/api.*")).build();
    }


    @SuppressWarnings("deprecation")
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Only Rest API Documentation for Role Base Access for /api/dataEmployee")
                .description("Web Services Project 2017/2018 Authors: Kevin ABRIAL & Alexis BARTHELEMY")
                .contact("kevin.abrial@etu.univ-st-etienne.fr,alexis.barthelemy@etu.univ-st-etienne.fr")
                .version("1.0")
                .build();
    }

}