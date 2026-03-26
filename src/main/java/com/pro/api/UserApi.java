package com.pro.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pro.model.User;
import com.pro.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserApi {

	@Autowired
	private UserService userService;

	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		return ResponseEntity.ok().body(userService.findAll());
	}

	@PostMapping
	public void createUser(@RequestBody(required = true) @Valid User user) {
		// required ja esta sempre true por padrão, coloquei apenas pra lembrar
		userService.save(user);
	}

	@GetMapping("/older-than-18")
	public List<User> getUsersOlderThan18() {
		return userService.getUsersOlderThan18();
	}
}