package com.lpu.demo_Security1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
	
	@GetMapping("/reg")
	public String registor() {
		return "registeration";
	}
	
	
	@GetMapping("/home")
	public String home() {
		return "hii";
	}
	
	@GetMapping("/home2")
	public String home2() {
		return "Home Page";
	}

}
