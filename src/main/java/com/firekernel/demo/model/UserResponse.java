package com.firekernel.demo.model;

public class UserResponse {
	private ExceptionResponse exceptionResponse;
	private User user;

	public ExceptionResponse getExceptionResponse() {
		return exceptionResponse;
	}

	public void setExceptionResponse(ExceptionResponse exceptionResponse) {
		this.exceptionResponse = exceptionResponse;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
