package com.admin;

//Define a custom exception class
public class EmailAlreadyExistsException extends Exception {
	public EmailAlreadyExistsException(String message) {
		super(message);
	}
}
