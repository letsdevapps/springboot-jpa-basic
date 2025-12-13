package com.pro.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pro.model.User;
import com.pro.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserApi {

	@Autowired
	private UserService userService;

	@GetMapping({ "", "/" })
	public List<User> findAll() {
		return userService.findAll();
	}

	@PostMapping("/save")
	public void save(@RequestBody User user) {
		userService.save(user);
	}

	@GetMapping("/users/older-than-18")
	public List<User> getUsersOlderThan18() {
		return userService.getUsersOlderThan18();
	}
}