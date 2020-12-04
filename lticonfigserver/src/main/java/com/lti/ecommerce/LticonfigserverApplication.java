package com.lti.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class LticonfigserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(LticonfigserverApplication.class, args);
	}

}
