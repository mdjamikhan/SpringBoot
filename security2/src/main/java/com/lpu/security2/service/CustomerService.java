package com.lpu.security2.service;

import java.util.List;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.lpu.security2.Entity.Customer;
import com.lpu.security2.repository.CustomerRepo;

@Service
public class CustomerService {
	
	private final CustomerRepo customerRepo;
	private final PasswordEncoder passwordencoder;
	
	
	
	

	public CustomerService(CustomerRepo customerRepo, PasswordEncoder passwordencoder) {
		super();
		this.customerRepo = customerRepo;
		this.passwordencoder = passwordencoder;
	}
 
	
	public Customer register(Customer customer) {
		String encodedPass=passwordencoder.encode(customer.getPassword());
		
		customer.setPassword(encodedPass);
		return customerRepo.save(customer);
	}
	
	//@PostAuthorize("returnObject.username == authentication.name")
	public void deleteCustomerById(int id) {
		customerRepo.deleteById(id);
	}
	@PostAuthorize("returnObject.name == authentication.name")
	public Customer findCustomerById(int id) {
		return customerRepo.findById(id).get();
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	public List<Customer> findAllCustomer(){
		return customerRepo.findAll();
	}
	
	
	
	

}
