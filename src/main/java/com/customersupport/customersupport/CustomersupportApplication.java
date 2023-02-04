package com.customersupport.customersupport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CustomersupportApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomersupportApplication.class, args);
	}

}
