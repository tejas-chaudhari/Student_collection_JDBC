package com.dev.exceptions;

public class StudentNotFoundException extends RuntimeException {

	@Override
	public String getMessage() {
		return "student not found";
	}

	
}
