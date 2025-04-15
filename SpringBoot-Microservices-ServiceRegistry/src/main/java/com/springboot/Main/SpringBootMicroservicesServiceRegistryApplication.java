package com.springboot.Main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


//@EnableEurekaServer -: This Annotation to activate Eureka Server related configuration.



@SpringBootApplication
@EnableEurekaServer
public class SpringBootMicroservicesServiceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMicroservicesServiceRegistryApplication.class, args);
	}
}
