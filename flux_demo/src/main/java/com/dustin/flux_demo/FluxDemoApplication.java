package com.dustin.flux_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"com.dustin.flux_demo"})
public class FluxDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(FluxDemoApplication.class, args);
	}

}
