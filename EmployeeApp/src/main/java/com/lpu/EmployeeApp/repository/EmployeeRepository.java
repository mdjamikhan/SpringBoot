package com.lpu.EmployeeApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lpu.EmployeeApp.entity.EmployeeApp;

public interface EmployeeRepository  extends JpaRepository<EmployeeApp, Integer>{
	
	

}
