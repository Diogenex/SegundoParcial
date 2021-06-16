package com.utn.RecuParcial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class RecuParcialApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecuParcialApplication.class, args);
	}

}
