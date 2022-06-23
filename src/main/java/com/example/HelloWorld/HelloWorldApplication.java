package com.example.HelloWorld;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;



@EnableRetry
@SpringBootApplication
public class HelloWorldApplication implements ApplicationRunner {
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(HelloWorldApplication.class);;
	@Value("${person.name}")
	private String name;

	public static void main(String[] args) {
		
		SpringApplication.run(HelloWorldApplication.class, args);
		

	}
	@Override
	public void run(ApplicationArguments args) throws Exception
	{
		LOGGER.info("Name: " + name);
	}
	


}
