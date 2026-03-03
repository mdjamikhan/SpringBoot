package com.lpu.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpu.demo.Entity.Student;
import com.lpu.demo.respository.studentRepository;

@Service
public class StudentService {
	@Autowired
	private studentRepository repository;


	public Student saveStudent(Student student) {
		return repository.save(student);
		
	}
	public Student getStudentById(int id) {
	    return repository.findById(id).orElse(null);
	}
	public String deleteById(int id) {
		Student s=repository.findById(id).get();
		
		repository.deleteById(id);
		
		return "Delete"+s;
		
		
 	}
	public List<Student> getALl() {
		List<Student> ls=repository.findAll();
		return ls;
	}
	
	public List<Student> saveALL(List<Student>ls){
		return repository.saveAll(ls);
	}
	
//	public StudentService() {
//		
//	}
//	
	
//	@Autowired
//	public StudentService(studentRepository repository) {
//		super();
//		this.repository = repository;
//	}
	

}
