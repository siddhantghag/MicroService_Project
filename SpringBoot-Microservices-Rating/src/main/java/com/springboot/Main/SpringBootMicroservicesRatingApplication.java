package com.springboot.Main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringBootMicroservicesRatingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMicroservicesRatingApplication.class, args);
	}

}




