package com.lpu.EmployeeApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

 import com.lpu.EmployeeApp.entity.EmployeeApp;
import com.lpu.EmployeeApp.service.EmployeeServiceCache;

import jakarta.validation.Valid;

@RestController

public class EmployeeControllerCache {
	
	@Autowired
	private EmployeeServiceCache service;
	
	@PostMapping("/empCache")
	public ResponseEntity<EmployeeApp> saveEmployee(@Valid @RequestBody EmployeeApp ee){
		
		 
	        return ResponseEntity
	                .status(HttpStatus.CREATED)
	                .body(service.saveEmployeeDTTO(ee));
		//return ResponseEntity.status(HttpStatus.CREATED).body(service.saveEmployeeDTTO(ee));
	}
	
	@GetMapping("/getCaches/{id}")
     public ResponseEntity<EmployeeApp> findEmployee(@PathVariable int id) {

        EmployeeApp employee = service.findEmployees(id);
        //EmployeeDTO dto = service.entityToDTO(employee);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(employee);
    }

	
	

}
