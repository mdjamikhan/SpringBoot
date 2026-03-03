package com.lpu.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpu.demo.Entity.College;
import com.lpu.demo.respository.collegeRepository;

@Service

public class collegeService {
	
	@Autowired
	private collegeRepository repo;
	
	
	public College saveCollege(College c) {
		
		if (c.getStudent() == null) {
            c.getStudent().forEach(s -> s.setCollege(c));
        }

        return repo.save(c);
	}
	public College finding(int id) {
		return repo.findById(id).orElse(null);
	}
	
	

}
