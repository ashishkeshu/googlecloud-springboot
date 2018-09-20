package com.firekernel.demo.exception;

public class FireException extends RuntimeException {
	
	public FireException(String message) {
		super(message);
	}

	public FireException(String message, Throwable cause) {
		super(message, cause);
	}
}
