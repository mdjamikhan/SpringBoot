package com.lpu.demo.respository;

 
import org.springframework.data.jpa.repository.JpaRepository;
 import org.springframework.stereotype.Repository;

import com.lpu.demo.Entity.College;
 
 
@Repository

public interface collegeRepository  extends JpaRepository<College, Integer>{
	
 
	
	

}
