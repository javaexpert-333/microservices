package com.javaexpert.bankrates;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BankRatesApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankRatesApplication.class, args);
	}

}
