// Spring WebClient is a non-blocking and reactive web client to perform HTTP requests. It is also the replacement for the classic RestTemplate. It is a part of spring-webflux library and also offers support for both synchronous and asynchronous operations. The DefaultWebClient class implements this WebClient interface.


package com.example.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
	}

}
