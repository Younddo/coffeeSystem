package com.kakao.coffeesystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class CoffeeSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoffeeSystemApplication.class, args);
	}

}
