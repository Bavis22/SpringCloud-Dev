package com.infy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableFeignClients
@RestController
public class FeignClientApplication {

	@Autowired
	private CardInterface cardInterface;
	
	public static void main(String[] args) {
		SpringApplication.run(FeignClientApplication.class, args);
		System.out.println("Feign client started");
		
	}

	@GetMapping("/card/{cardNo}")
	public CardDetails getCardDetails(@PathVariable("cardNo") String cardNo)
	{
		return cardInterface.getCardDetails(cardNo);
	}
}
