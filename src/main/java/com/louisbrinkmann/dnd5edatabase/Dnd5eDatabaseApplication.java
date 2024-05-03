package com.louisbrinkmann.dnd5edatabase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class Dnd5eDatabaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(Dnd5eDatabaseApplication.class, args);
	}
}
