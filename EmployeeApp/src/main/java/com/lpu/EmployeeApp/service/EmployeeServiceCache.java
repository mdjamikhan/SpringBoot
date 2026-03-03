package com.lpu.EmployeeApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.lpu.EmployeeApp.dto.EmployeeDTO;
import com.lpu.EmployeeApp.entity.EmployeeApp;
import com.lpu.EmployeeApp.repository.EmployeeRepository;

@Service

public class EmployeeServiceCache {
	
	@Autowired
	private EmployeeRepository empRepo;
	
	@CachePut(value="employees",key="#result.id")
	
	public EmployeeApp saveEmployeeDTTO(EmployeeApp dto) {
		
		//EmployeeApp employee=DTOtoEntity(dto);
		return empRepo.save(dto); // Database method
 
		
	}
	
	@Cacheable(value="employees",key="#id")
	public EmployeeApp findEmployees( int id){
		
		  return empRepo.findById(id).get();
		 
		
	}
	
	public EmployeeApp DTOtoEntity(EmployeeDTO emp) {
		EmployeeApp em=new EmployeeApp();
		em.setAge(emp.getAge());
		em.setEmail(emp.getEmail());
		em.setName(emp.getName());
		em.setPhone(emp.getPhone());
		return em;
	}
	
 
	
	 
	
	
	public EmployeeDTO entityToDTO(EmployeeApp e) {
		EmployeeDTO dto=new EmployeeDTO();
		dto.setAge(e.getAge());
		dto.setEmail(e.getEmail());
		dto.setName(e.getName());
		dto.setPhone(e.getPhone());
		return dto;
	}

}
