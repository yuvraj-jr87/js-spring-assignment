package com.ibm.springboot.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.ibm.springboot.demo.model.Employee;
import com.ibm.springboot.demo.repository.EmployeeRepository;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTests {
	
	@MockBean
	private EmployeeRepository employeeRepository;
	
	@InjectMocks
	private EmployeeServiceImpl employeeServiceImpl;
	
	@BeforeEach
	public void setUp()
	{
		java.util.List<Employee> empList = new ArrayList<>();
		empList.add(new Employee());
		empList.add(new Employee());
		empList.add(new Employee());
		
		when(employeeRepository.findAll()).thenReturn(empList);
	}
	
	@Test
	public void testAllEmps()
	{
		assertEquals(employeeServiceImpl.getAllEmployees().size(), 3);
	}

}
