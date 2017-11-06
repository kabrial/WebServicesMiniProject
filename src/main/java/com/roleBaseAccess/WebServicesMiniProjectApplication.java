package com.roleBaseAccess;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;



@SpringBootApplication
public class WebServicesMiniProjectApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(WebServicesMiniProjectApplication.class);
    }
	public static void main(String[] args) {
		SpringApplication.run(WebServicesMiniProjectApplication.class, args);
	}
}
