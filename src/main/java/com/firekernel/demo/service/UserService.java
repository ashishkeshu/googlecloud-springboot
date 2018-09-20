package com.firekernel.demo.service;

import org.springframework.http.ResponseEntity;

import com.firekernel.demo.model.User;
import com.firekernel.demo.model.UserRequest;
import com.firekernel.demo.model.UserResponse;

public interface UserService {

	UserResponse saveUser(UserRequest registerRequest);

	UserResponse validateUser(UserRequest loginRequest);

	User getUserById(Long id);

	User updateUserById(Long id, User user);

	ResponseEntity<?> deleteUserById(Long id);

}
