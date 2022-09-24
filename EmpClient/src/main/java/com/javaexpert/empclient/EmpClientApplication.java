package com.javaexpert.empclient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class EmpClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpClientApplication.class, args);
	}
	
	@Autowired
	@Lazy
	public RestTemplate restTemplate;
	
	@Value("${emp.service.url}")
	public String url;
	
	@GetMapping("/getEmpList")
	public List getEmpList() {
		return restTemplate.getForObject(url, List.class);
	}
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
