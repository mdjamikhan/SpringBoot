package com.lpu.StudentAssignment.Service;

import java.util.Collection;
import java.util.Collections;

import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.lpu.StudentAssignment.Entity.StudentAssignment;

public class StudentDetails  implements UserDetails{
	
	private  StudentAssignment assignment;
	
	
	
	

	public StudentDetails(StudentAssignment assignment) {
		super();
		this.assignment = assignment;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		 
		return  Collections.singleton(new SimpleGrantedAuthority(assignment.getRole()));
	}

	@Override
	public @Nullable String getPassword() {
		 
		return assignment.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return assignment.getName();
	}

}
