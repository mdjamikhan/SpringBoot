package com.lpu.demo.controller;

 import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/lpu")
@RestController
public class LpuController {
	
	
	@RequestMapping("/m1")
	public String m1() {
		return "m1 saved";
	}
	@PostMapping("/student")
	public String saveStudent() {
		return "student saved";
	}
	@PostMapping("/trainner")
	public String saveTrainner() {
		return "trainner saved";
	}
	@PostMapping("/security")
	public String saveSecurity() {
		return "Security saved";
	}
	

}
