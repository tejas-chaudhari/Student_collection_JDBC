package com.dev.exceptions;

public class StudentNotAddedException extends RuntimeException{

	@Override
	public String getMessage() {
		return "student not added";
	}

	
}
