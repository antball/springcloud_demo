package com.cloud.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class ConfigCenterApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigCenterApplication.class, args);
	}
}
