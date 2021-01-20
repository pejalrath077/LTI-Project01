package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@EnableSwagger2
public class Restdemo1Application {

	public static void main(String[] args) {
		SpringApplication.run(Restdemo1Application.class, args);
	}

}
