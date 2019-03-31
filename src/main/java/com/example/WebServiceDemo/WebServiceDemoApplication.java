package com.example.WebServiceDemo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


@ComponentScan("com.example.controller")
@SpringBootApplication
@EnableSwagger2

public class WebServiceDemoApplication {
	
	static {
		System.out.println("hiiiiS");
	}
	
	
	
	@Bean
	public RestTemplate getRestTemplate()
	{
		return new RestTemplate();
	}

	public static void main(String[] args) {
		System.out.println("hiii");
		
				SpringApplication.run(WebServiceDemoApplication.class, args);
	}
	
	

}
//access token
//refresh token