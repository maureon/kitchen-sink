package com.github.maureon.kitchensink;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class KitchenSinkApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		System.out.println("Bootstrapping before loading APP");
		return application.sources(KitchenSinkApplication.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(KitchenSinkApplication.class, args);
	}

}
