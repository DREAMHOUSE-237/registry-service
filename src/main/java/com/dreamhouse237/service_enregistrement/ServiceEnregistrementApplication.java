package com.dreamhouse237.service_enregistrement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class ServiceEnregistrementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceEnregistrementApplication.class, args);
	}

}
