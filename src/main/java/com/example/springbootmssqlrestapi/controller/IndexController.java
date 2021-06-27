package com.example.springbootmssqlrestapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class IndexController {

	@RequestMapping(method = RequestMethod.GET)
	public String sayHello() {
		return "Welcome to the Spring Boot Restful API Demo with MSSQL.";
	}
}