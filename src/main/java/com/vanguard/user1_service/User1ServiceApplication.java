package com.vanguard.user1_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class User1ServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(User1ServiceApplication.class, args);
	}

}
