package com.example.demo.GlobalException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.Exception.BookSerException;

@ControllerAdvice
public class BookGlobalEx {
	@ExceptionHandler(exception = BookSerException.class)
	public ResponseEntity<String> BookExceptionHandler(BookSerException bs) {
		return new ResponseEntity<String>(bs.getErrorMessage(), bs.getHttpStatus());
	}

	@ExceptionHandler(exception = Exception.class)
	public ResponseEntity<String> Exception(Exception e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}

}
