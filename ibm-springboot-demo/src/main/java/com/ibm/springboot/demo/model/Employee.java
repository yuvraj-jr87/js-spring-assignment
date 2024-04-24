package com.ibm.springboot.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("employees")
public class Employee {

	@Id
	private String employeeId;
	private String firstName;
	private Double salary;
	private String email;
	public Employee(String employeeId, String firstName, Double salary, String email) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.salary = salary;
		this.email = email;
	}
	public Employee() {
		
	}
	public Employee(String employeeId, String firstName, Double salary) {
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.salary = salary;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", salary=" + salary + ", email="
				+ email + "]";
	}


	

}
