package com.firekernel.demo.model;

public class StorageResponse {
	private ExceptionResponse exceptionResponse;
	private FireFile fireFile;

	public StorageResponse() {
	}

	public StorageResponse(FireFile fireFile) {
		this.fireFile = fireFile;
	}

	public StorageResponse(ExceptionResponse exceptionResponse) {
		this.exceptionResponse = exceptionResponse;
	}

	public ExceptionResponse getExceptionResponse() {
		return exceptionResponse;
	}

	public void setExceptionResponse(ExceptionResponse exceptionResponse) {
		this.exceptionResponse = exceptionResponse;
	}

	public FireFile getFireFile() {
		return fireFile;
	}

	public void setFireFile(FireFile fireFile) {
		this.fireFile = fireFile;
	}

}
