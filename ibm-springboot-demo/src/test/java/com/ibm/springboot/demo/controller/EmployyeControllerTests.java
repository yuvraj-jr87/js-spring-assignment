package com.ibm.springboot.demo.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.ibm.springboot.demo.model.Employee;
import com.ibm.springboot.demo.service.EmployeeServiceImpl;

@WebMvcTest(EmployeeController.class)
public class EmployyeControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private EmployeeServiceImpl employeeServiceImpl;

	@BeforeEach
	public void setUp() {
		java.util.List<Employee> empList = new ArrayList<>();
		empList.add(new Employee("101", "Sonu", 10.5));
		empList.add(new Employee("102", "Monu", 12.5));
		empList.add(new Employee("103", "Tonu", 14.5));

		when(employeeServiceImpl.getAllEmployees()).thenReturn(empList);
	}

	@Test
	public void testEmployeeControllerStatus() throws Exception {
		mockMvc.perform(get("/emp/get-all-emps")).andExpect(status().isOk());
	}

	@Test
	public void testEmployeeControllerMediaType() throws Exception {
		mockMvc.perform(get("/emp/get-all-emps")).andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}

	@Test
	public void testEmployeeControllerPrint() throws Exception {
		mockMvc.perform(get("/emp/get-all-emps")).andDo(print());
	}

}
