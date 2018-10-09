package com.example.firstproject.exceptionhandler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(IndexOutOfBoundsException.class)
	public String loginExceptionHandler(IndexOutOfBoundsException dae) {
		return "Enter Valid Username and Password";
	}

	
	@ExceptionHandler(Throwable.class)
	public String allExceptionHandler(Throwable th) {
		return "Enter Valid Details";
	}

}
