package com.lpu.StudentAssignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lpu.StudentAssignment.Entity.StudentAssignment;

public interface StudentRepo extends JpaRepository<StudentAssignment, Integer>{
	
	StudentAssignment findByName(String name);

}
