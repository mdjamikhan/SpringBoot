package com.lpu.security2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.lpu.security2.Entity.Customer;
import com.lpu.security2.repository.CustomerRepo;

@Service
public class CustomerUserDetailsService implements UserDetailsService {
	
	
	@Autowired
	private   CustomerRepo repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Customer customer=repo.findByName(username);
		// TODO Auto-generated method stub
		return new CustomerUserDetail(customer);
	}
	
	
 
	
	

}
