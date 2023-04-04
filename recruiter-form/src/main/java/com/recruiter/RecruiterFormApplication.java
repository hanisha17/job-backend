package com.recruiter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class RecruiterFormApplication {
	
	
	public static void main(String[] args) {
		SpringApplication.run(RecruiterFormApplication.class, args);
	}

}
