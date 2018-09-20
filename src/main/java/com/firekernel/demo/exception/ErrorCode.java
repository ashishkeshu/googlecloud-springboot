package com.firekernel.demo.exception;

public enum ErrorCode {
	OK(200), ERROR(201);

	private int errorCode;

	ErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public int getCode() {
		return errorCode;
	}

}
