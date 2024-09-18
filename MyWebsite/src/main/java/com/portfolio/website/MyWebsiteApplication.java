package com.portfolio.website;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@ComponentScan(basePackages = {"com.portfolio.website.controller", "com.portfolio.website.service"})
public class MyWebsiteApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(MyWebsiteApplication.class, args);

	}

}
