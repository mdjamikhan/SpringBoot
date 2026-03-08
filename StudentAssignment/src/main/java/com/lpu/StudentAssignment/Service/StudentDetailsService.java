package com.lpu.StudentAssignment.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.lpu.StudentAssignment.Entity.StudentAssignment;
import com.lpu.StudentAssignment.repository.StudentRepo;

@Service
public class StudentDetailsService implements UserDetailsService {
	
	@Autowired
	private StudentRepo repo;
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 
		StudentAssignment assignment=repo.findByName(username);
		return new StudentDetails(assignment);
	}

}
