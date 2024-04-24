package com.ibm.springboot.demo.exception;

public class EmployeeNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = -4373158775284035841L;

	public EmployeeNotFoundException(String message) {
		super(message);
	}

	public EmployeeNotFoundException() {
		super();
	}

}
