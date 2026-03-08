package com.lpu.security2.service;

import java.util.Collection;
import java.util.Collections;

import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
 
import com.lpu.security2.Entity.Customer;
 
public class CustomerUserDetail implements UserDetails {
	
	
	private Customer customer; //DB user
	
	

	public CustomerUserDetail(Customer customer) {
		super();
		this.customer = customer;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
 		
		return Collections.singleton(new SimpleGrantedAuthority(customer.getRole()));
	}

	@Override
	public @Nullable String getPassword() {
		
		return customer.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return customer.getName();
	}

}
