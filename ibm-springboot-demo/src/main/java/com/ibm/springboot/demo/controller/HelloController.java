package com.ibm.springboot.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.springboot.demo.service.RestConsumeService;

@RestController
public class HelloController {

	@Autowired
	private RestConsumeService restConsumeService;

	@GetMapping("hello")
	public String hello() {
		return restConsumeService.getRestData();
	}
}

//package com.ibm.springboot.demo.controller;
//
//@RestController
//public class HelloController {
//
//	@GetMapping("hello")
//	public String hello() {
//		return "Hello world!";
//	}
//}
