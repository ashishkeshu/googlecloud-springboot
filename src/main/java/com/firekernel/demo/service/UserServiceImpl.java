package com.firekernel.demo.service;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.firekernel.demo.exception.ErrorCode;
import com.firekernel.demo.exception.FireEntityNotFoundException;
import com.firekernel.demo.exception.FireException;
import com.firekernel.demo.model.ExceptionResponse;
import com.firekernel.demo.model.User;
import com.firekernel.demo.model.UserRequest;
import com.firekernel.demo.model.UserResponse;
import com.firekernel.demo.repository.UserRepository;
import com.firekernel.demo.util.FireLog;
import com.firekernel.demo.util.LoginRequestType;

@Service
public class UserServiceImpl implements UserService {
	private static final Logger LOGGER = Logger.getLogger(UserServiceImpl.class.getName());

	@Autowired
	UserRepository userRepository;

	@Override
	public UserResponse saveUser(UserRequest registerRequest) {
		UserResponse registerResponse = new UserResponse();
		// add some validation for incoming data
		try {
			User user = getUserIfExists(registerRequest);

			User savedUser;

			if (user != null) { // user exists so update
				transformForUpdate(user, registerRequest.getUser());
				savedUser = userRepository.save(user);
			} else { // User does not exist so insert
				savedUser = userRepository.save(registerRequest.getUser());
			}
			registerResponse.setUser(savedUser);
		} catch (FireException e) {
			FireLog.e(LOGGER, "", e);
			ExceptionResponse exceptionResponse = new ExceptionResponse(ErrorCode.ERROR.getCode(), e.getMessage());
			registerResponse.setExceptionResponse(exceptionResponse);
		}
		return registerResponse;
	}

	@Override
	public UserResponse validateUser(UserRequest loginRequest) {
		UserResponse loginResponse = new UserResponse();

		try {
			User user = getUserIfExists(loginRequest);

			if (user == null) {
				ExceptionResponse exceptionResponse = new ExceptionResponse(ErrorCode.ERROR.getCode(), "No User Found");
				loginResponse.setExceptionResponse(exceptionResponse);
				return loginResponse;
			}

			loginResponse.setUser(user);

		} catch (FireException e) {
			FireLog.e(LOGGER, "", e);
			ExceptionResponse exceptionResponse = new ExceptionResponse(ErrorCode.ERROR.getCode(), e.getMessage());
			loginResponse.setExceptionResponse(exceptionResponse);
		}
		return loginResponse;
	}

	@Override
	public User getUserById(Long id) {
		return userRepository.findById(id).orElseThrow(() -> new FireEntityNotFoundException("User Not Found"));
	}

	@Override
	public User updateUserById(Long id, User user) {
		User aUser = userRepository.findById(id).orElseThrow(() -> new FireEntityNotFoundException("User Not Found"));
		transformForUpdate(aUser, user);
		return userRepository.save(aUser);
	}

	@Override
	public ResponseEntity<?> deleteUserById(Long id) {
		userRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}

	private User getUserIfExists(UserRequest userRequest) {
		FireLog.i(LOGGER, "(++) getUserIfExists");
		User user = null;
		switch (LoginRequestType.getLoginRequestType(userRequest.getRequestType())) {
		case EMAIL:
			user = userRepository.getUserByEmailAndPassword(userRequest.getUser().getEmail(),
					userRequest.getUser().getPassword());
			break;
		case CONTACT_NUMBER:
			user = userRepository.getUserByContactNumber(userRequest.getUser().getContactNumber());
			break;
		case FB:
			user = userRepository.getUserByFbId(userRequest.getUser().getFbId());
			break;
		case GOOGLE:
			user = userRepository.getUserByGoogleId(userRequest.getUser().getGoogleId());
			break;
		}
		return user;
	}

	private void transformForUpdate(User oldUser, User newUser) {
		FireLog.v(LOGGER, "(++) transformForUpdate");
		oldUser.setLastName(newUser.getLastName());
		oldUser.setFirstName(newUser.getFirstName());
		oldUser.setBirthday(newUser.getBirthday());
		oldUser.setGender(newUser.getGender());
		oldUser.setAvatar(newUser.getAvatar());
		oldUser.setEmail(newUser.getEmail());
		oldUser.setContactNumber(newUser.getContactNumber());
	}

}
