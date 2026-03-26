package com.pro.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
		userService.saveAndUpdate(user);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody @Valid User userUpdate) {
		return userService.findById(id).map(existingUser -> {
			existingUser.setName(userUpdate.getName());
			existingUser.setEmail(userUpdate.getEmail());
			existingUser.setBirthDate(userUpdate.getBirthDate());
			User updatedUser = userService.saveAndUpdate(existingUser);
			return ResponseEntity.ok(updatedUser);
		}).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable Long id) {
		return userService.findById(id).map(user -> {
			userService.delete(user);
			return ResponseEntity.noContent().build(); // 204
		}).orElseGet(() -> ResponseEntity.notFound().build()); // 404
	}

	@GetMapping("/older-than-18")
	public List<User> getUsersOlderThan18() {
		return userService.getUsersOlderThan18();
	}
}