package com.HM.SortNumbers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.HM.SortNumbers")
@EnableAutoConfiguration
@SpringBootApplication
public class SortNumbersApplication extends SpringBootServletInitializer{

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SortNumbersApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(SortNumbersApplication.class, args);
	}
}
