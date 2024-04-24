package com.ibm.springboot.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ibm.springboot.demo.model.Employee;
import com.ibm.springboot.demo.service.EmployeeService;

@SpringBootTest

class AppTests {
//
//	@Test
//	void contextLoads() {
//	}
	
	@Autowired
	private EmployeeService employeeService;
	
	private static final Logger LOG = LoggerFactory.getLogger(AppTests.class);
	
	@BeforeAll
	public static void setUp() {
		LOG.info("Before all");
	}
	

	@AfterAll
	public static void tearDown() {
		LOG.info("After all");
	}
	
	@Test
	public void testAddEmp()
	{
		Employee e = new Employee("asdf","test name",56.8,"test@gmail.com");
		assertEquals(employeeService.addEmployee(e),e);
	}
	
//	@Test
//	public void testAllEmps()
//	{
//		assertEquals(employeeService.getAllEmployees().size(), 15);
//	}
//	
//	@Test
//	public void testAllEmps2()
//	{
//		assertNotEquals(employeeService.getAllEmployees().size(), 16);
//	}
	
	
////Positive test case
//	@Test
//	public void testTest() {
//		Integer expected=10;
//		Integer actual=5+5;
//		assertEquals(expected, actual);
//	}
//	
////Neagtive test case
//	@Test
//	public void testTest2() {
//		Integer unexpected=10;
//		Integer actual=5+4;
//		assertNotEquals(unexpected, actual);
//	}

}
