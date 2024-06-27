package com.portfolio.website;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MyWebsiteApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(MyWebsiteApplication.class, args);
	}

}
