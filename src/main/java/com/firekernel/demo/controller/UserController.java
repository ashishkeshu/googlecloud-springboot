package com.firekernel.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.firekernel.demo.model.User;
import com.firekernel.demo.model.UserRequest;
import com.firekernel.demo.model.UserResponse;
import com.firekernel.demo.service.UserService;

@RestController
@RequestMapping("/v1")
public class UserController {
	@Autowired
	UserService userService;

	@PostMapping("/user/register")
	public UserResponse register(@RequestBody UserRequest registerRequest) {
		return userService.saveUser(registerRequest);
	}

	@PostMapping("/user/login")
	public UserResponse login(@RequestBody UserRequest loginRequest) {
		return userService.validateUser(loginRequest);
	}

	@GetMapping("/user/{id}")
	public User getUserById(@PathVariable(value = "id") Long id) {
		return userService.getUserById(id);
	}

	@PutMapping("/user/{id}")
	public User updateUserById(@PathVariable(value = "id") Long id, @Valid @RequestBody User user) {
		return userService.updateUserById(id, user);
	}

	@DeleteMapping("/user/{id}")
	public ResponseEntity<?> deleteUserById(@PathVariable(value = "id") Long id) {
		return userService.deleteUserById(id);
	}

}
