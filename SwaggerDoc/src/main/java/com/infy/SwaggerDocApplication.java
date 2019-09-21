package com.infy;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@RestController
@EnableSwagger2
public class SwaggerDocApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwaggerDocApplication.class, args);
		System.out.println("swagger started");
	}

	@GetMapping("/get")
	public String test() {
		return"hello";
	}
	
	@PostMapping("/post/{id}")
	public Object testpost(@PathVariable("id") int id) {
		
		return new Object();
	}
	
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	   public List<String> getProducts() {
	      List<String> productsList = new ArrayList<>();
	      productsList.add("Honey");
	      productsList.add("Almond");
	      return productsList;
	   }
	   @RequestMapping(value = "/products", method = RequestMethod.POST)
	   public String createProduct() {
	      return "Product is saved successfully";
	   }
	   
	   @Bean
	   public Docket productApi() {
	      return new Docket(DocumentationType.SWAGGER_2).select()
	         .apis(RequestHandlerSelectors.basePackage("com.infy")).build();
	   }
}
