package com.example.demo.Exception;

import org.springframework.http.HttpStatus;

public class UserSerException extends RuntimeException {
	private String errorMessage;
	private HttpStatus httpStatus;

	public String getErrorMessage() {
		return errorMessage;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public UserSerException(String errorMessage, HttpStatus httpStatus) {
		super();
		this.errorMessage = errorMessage;
		this.httpStatus = httpStatus;
	}

}
