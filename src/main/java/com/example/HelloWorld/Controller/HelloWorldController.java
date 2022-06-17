package com.example.HelloWorld.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.retry.annotation.Retryable;
import org.springframework.http.HttpStatus;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jayway.jsonpath.JsonPath;




@RestController
public class HelloWorldController {
	private static final Logger LOGGER = LoggerFactory.getLogger(HelloWorldController.class);
	private int attempt = 1;
	
	
	@RequestMapping("/")
	public String hello() {
		LOGGER.info("Hello World");
		
		return "Hello World";
		
	}
	
	@Retryable(value = {HttpClientErrorException.class}, maxAttempts = 3, backoff = @Backoff(delay = 3000))
	@RequestMapping("/data")
	public List<Result> getJSON(@RequestParam String country_id) throws HttpClientErrorException {
		
		LOGGER.info("Method called.." + attempt++);
		
		final String url = "https://api.openaq.org/v1/locations?limit=100&page=1&offset=0&sort=desc&radius=1000&country_id="+country_id +"&order_by=lastUpdated&dumpRaw=false";
		
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(url, String.class);
		
		List<Result> dataObject = JsonPath.parse(result).read("$.results[*].['city', 'coordinates']");
		
	
		Results res = new Results();
		res.setResults(dataObject);
		LOGGER.info(res.toString());

		
		
			return dataObject;
		}
		
	
	@ExceptionHandler(value = HttpClientErrorException.class)
	public String errorEx(HttpClientErrorException ex) {
		
		String mssg = "Country Code is invalid , please enter a country code with 2 valid characters"
				+ " pattern: [a-zA-Z][a-zA-Z] ";
		
		return mssg;		
	}
}
	
	


