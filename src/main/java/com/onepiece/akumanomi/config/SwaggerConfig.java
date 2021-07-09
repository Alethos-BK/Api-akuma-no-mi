package com.onepiece.akumanomi.config;

import static springfox.documentation.builders.PathSelectors.regex;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.VendorExtension;


@Configuration
@EnableSwagger2
public class SwaggerConfig {

	
	@Bean
	public Docket swagger() {
		return new Docket(DocumentationType.SWAGGER_2) 
				.select() 
				.apis(RequestHandlerSelectors.any()) 
				.paths(regex("/api.*"))
				.build() 
				.apiInfo(info()); 
	}
	
	private ApiInfo info() {
		return new ApiInfo(
				"Akuma no Mi api", 
				"ApiRest para venda de Akumas no Mi", 
				"1.0", 
				"Termos de Serviços", 
				new Contact("Alice Periles", 
						"https://www.linkedin.com/in/alice-periles/", 
						"odahcamperiles@gmail.com"), 
				"Apache License Version 2.0",
				"https://www.apache.org/licesen.html", 
				new ArrayList<VendorExtension>());
	}
	
}