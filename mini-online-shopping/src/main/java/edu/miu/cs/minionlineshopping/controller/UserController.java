package edu.miu.cs.minionlineshopping.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.cs.minionlineshopping.model.User;
import edu.miu.cs.minionlineshopping.serviceImpl.UserServiceImpl;

@RestController
public class UserController {

	@Autowired
	UserServiceImpl userService;

	@PostMapping("/users")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User savedUser = userService.createUser(user);

		return new ResponseEntity<User>(savedUser, HttpStatus.CREATED);
	}

	@PostMapping("users/{id}")
	public void updateUser(@RequestBody User user) {
		userService.updateUser(user);
	}

	@GetMapping("users")
	public List<User> findAllUsers() {
		return userService.findAllUser();
	}

	@GetMapping("users/{id}")
	public Optional<User> findAUser(@PathVariable Long id) {
		return userService.findUser(id);
	}

	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
	}
}
