package com.pro.configuration;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.pro.model.User;
import com.pro.repository.UserRepository;

@Configuration
public class DataLoader {

	@Bean
	CommandLineRunner loadUsers(UserRepository repository) {
		return args -> {
			repository.save(new User("Joao", "joao@email.com", LocalDate.of(1990, 1, 1)));
			repository.save(new User("Maria", "maria@email.com", LocalDate.of(2000, 1, 1)));
			repository.save(new User("Jose", "jose@email.com", LocalDate.of(2010, 1, 1)));
		};
	}
}