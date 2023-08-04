package com.lcwd.foodmenu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class FoodMenuServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodMenuServiceApplication.class, args);
	}

}
