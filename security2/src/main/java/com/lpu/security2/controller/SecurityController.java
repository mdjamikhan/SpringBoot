package com.lpu.security2.controller;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lpu.security2.Entity.Customer;
import com.lpu.security2.service.CustomerService;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/customer")
public class SecurityController {
	
	private final CustomerService customerService;

	public SecurityController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}
	
	@PostMapping("/register")
	public Customer reg(  @RequestBody Customer customer) {
		
		return customerService.register(customer);	
		
	}
	
	@GetMapping("/public")
	public String homePage() {
		
		return "Public page";
		
	}
	@GetMapping("/account")
	public String accountPage() {
		
		return "account page";
		
	}
	
	@GetMapping("/delete")
	public String delete() {
		return "Delete Page";
	}
	@GetMapping("/update")
	public String update() {
		return "Update Page";
	}
	
	@DeleteMapping("/deleteById/{id}")
	public String deleteByID(@PathVariable int id) {
		customerService.deleteCustomerById(id);
		return "Deleted";
	}
	@GetMapping("/findCustomer/{id}")
	public Customer findCustomer(@PathVariable int id) {
		return customerService.findCustomerById(id);
		  
	}
	
	@PostMapping("/save")
	public String save() {
		return "saved";
	}
	
	@GetMapping("/csrf")
	public CsrfToken csrf(CsrfToken token) {
		return token;
	}
	
	

}
