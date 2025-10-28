package com.example.demo.GlobalException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.Exception.UserSerException;

@ControllerAdvice
public class UserGlobalExHandler {
	@ExceptionHandler(exception = UserSerException.class)
	public ResponseEntity<String> UserExceptionHandler(UserSerException us) {
		return new ResponseEntity<String>(us.getErrorMessage(), us.getHttpStatus());
	}

	@ExceptionHandler(exception = Exception.class)
	public ResponseEntity<String> Exception(Exception e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}

}
