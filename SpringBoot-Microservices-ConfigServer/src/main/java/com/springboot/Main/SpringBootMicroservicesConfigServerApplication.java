package com.springboot.Main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class SpringBootMicroservicesConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMicroservicesConfigServerApplication.class, args);
	}

}
