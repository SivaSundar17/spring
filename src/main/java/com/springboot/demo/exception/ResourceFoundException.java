package com.springboot.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class ResourceFoundException extends RuntimeException{
	
	public ResourceFoundException(String message) {
		super(message);
	}
}
	
