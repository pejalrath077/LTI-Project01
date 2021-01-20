package com.example.demo;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class Restdemo1Application {
	// @Autowired
	// private RequestFormRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Restdemo1Application.class, args);
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.withClassAnnotation(RestController.class)).paths(PathSelectors.any()).build()
				.apiInfo(apiInfo()).useDefaultResponseMessages(false);
	}

	@Bean
	public ApiInfo apiInfo() {
		final ApiInfoBuilder builder = new ApiInfoBuilder();
		builder.title("iFulfill Api").version("1.0").license("(C) Copyright LTI")
				.description("List of all the APIs of LTI iFulfill through Swagger UI");
		return builder.build();
	}

	// @Bean
	// CorsConfigurationSource corsConfigurationSource() {
	// CorsConfiguration configuration = new CorsConfiguration();
	// configuration.setAllowedOrigins(Arrays.asList("https://boot-hheroku.herokuapp.com"));
	// configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE",
	// "HEAD", "OPTIONS"));
	// configuration.setAllowedHeaders(Arrays.asList("Access-Control-Allow-Headers",
	// "Access-Control-Allow-Origin",
	// "Access-Control-Request-Method", "Access-Control-Request-Headers", "Origin",
	// "Cache-Control", "Content-Type"));
	// final UrlBasedCorsConfigurationSource source = new
	// UrlBasedCorsConfigurationSource();
	// source.registerCorsConfiguration("/**", configuration);
	// return source;
	// }

	// @Override
	// public void run(String... args) throws Exception {
	// repository.deleteAll();
	// repository.save(new RequestForm("Windows 10", "Issues Here", "1/19/2021",
	// "Medium", "Pejal", "Pending", "Sutter",
	// "1/21/2021", "1/22/2021", "No Remarks", "Pejal"));
	// repository.save(new RequestForm("MacOS", "Issues Here", "1/15/2021", "High",
	// "Anthony", "Complete", "Sutter",
	// "1/16/2021", "1/17/2021", "Requested attention ASAP", "Anthony"));

	// System.out.println("RequestFormsFound with findAll():");
	// System.out.println("---------------------------------");
	// for (RequestForm requestform : repository.findAll()) {
	// System.out.println(requestform);
	// }

	// System.out.println();

	// System.out.println("RequestForms found with findBySystem('Windows'):");
	// System.out.println("------------------------------------------------");
	// System.out.println(repository.findBySystem("Windows"));

	// System.out.println("RequestForms found with findByStatus('Open')");
	// System.out.println("--------------------------------------------");
	// for (RequestForm requestform : repository.findByStatus("Open")) {
	// System.out.println(requestform);
	// }
	// }
}
