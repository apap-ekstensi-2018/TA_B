package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ProjectApapApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectApapApplication.class, args);
		
		/*BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		String passwd = encoder.encode("password");
		
		System.out.println("encode : ");
		
	      // passwd - password from database
	      System.out.println(passwd); // print hash

	      // true for all 5 iteration
	      System.out.println(encoder.matches("password", passwd));*/
	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
