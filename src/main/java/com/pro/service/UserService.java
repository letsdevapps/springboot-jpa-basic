package com.pro.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pro.model.User;
import com.pro.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public void save(User user) {
		userRepository.save(user);
	}

	public List<User> getUsersOlderThan18() {
		// Data de 18 anos atrás
		LocalDate eighteenYearsAgo = LocalDate.now().minusYears(18);

		// Encontrar usuários que nasceram antes dessa data
		return userRepository.findByBirthDateBefore(eighteenYearsAgo);
	}
}