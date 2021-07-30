package com.mycompany.wuzzuffinal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.mycompany.wuzzuffinal"})

public class WuzzuffinalApplication {

	public static void main(String[] args) {
		SpringApplication.run(WuzzuffinalApplication.class, args);
	}

}
