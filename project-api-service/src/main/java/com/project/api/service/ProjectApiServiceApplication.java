package com.project.api.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ProjectApiServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectApiServiceApplication.class, args);
	}

}
