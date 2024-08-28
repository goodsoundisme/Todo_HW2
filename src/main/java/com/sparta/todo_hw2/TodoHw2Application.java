package com.sparta.todo_hw2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class TodoHw2Application {

	public static void main(String[] args) {
		SpringApplication.run(TodoHw2Application.class, args);
	}

}
