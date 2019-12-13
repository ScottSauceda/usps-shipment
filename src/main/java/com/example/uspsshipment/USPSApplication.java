package com.example.uspsshipment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class USPSApplication {

	public static void main(String[] args) {
		SpringApplication.run(USPSApplication.class, args);
	}

}
