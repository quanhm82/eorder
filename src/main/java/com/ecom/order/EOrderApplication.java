package com.ecom.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(EOrderApplication.class, args);
	}

}
