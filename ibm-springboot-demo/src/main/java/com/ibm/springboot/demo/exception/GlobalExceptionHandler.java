package com.ibm.springboot.demo.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ibm.springboot.demo.model.Department;
import com.ibm.springboot.demo.model.Employee;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<Employee> handleEmployeeNotFoundException(EmployeeNotFoundException e) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", e.getMessage());
		HttpStatus status = HttpStatus.NOT_FOUND;
		ResponseEntity<Employee> response = new ResponseEntity<Employee>(null, headers, status);
		return response;
	}
	
	@ExceptionHandler(DepartmentNotFoundException.class)
	public ResponseEntity<Department> handleDepartmentNotFoundException(DepartmentNotFoundException d) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", d.getMessage());
		HttpStatus status = HttpStatus.NOT_FOUND;
		ResponseEntity<Department> response = new ResponseEntity<Department>(null, headers, status);
		return response;
	}
}
