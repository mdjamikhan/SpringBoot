package com.lpu.StudentAssignment.Service;

 
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
 import org.springframework.stereotype.Service;

import com.lpu.StudentAssignment.Entity.StudentAssignment;
import com.lpu.StudentAssignment.exception.SMSException;
import com.lpu.StudentAssignment.repository.StudentRepo;

@Service
public class StudentService {
	
	private final StudentRepo repo;
	private final PasswordEncoder passwordencoder;

	public StudentService(StudentRepo repo, PasswordEncoder passwordencoder) {
		super();
		this.repo = repo;
		this.passwordencoder = passwordencoder;
	}

 
	public StudentAssignment saveStudent(StudentAssignment assignment) {
		String encoded = passwordencoder.encode(assignment.getPassword());
		assignment.setPassword(encoded);
		return repo.save(assignment);
	}

 	@PostAuthorize("returnObject.name == authentication.name")
 	public StudentAssignment findStudent(int id) throws SMSException {
 	    return repo.findById(id)
 	            .orElseThrow(() -> new SMSException("Error is found"));
 	}
 	@PreAuthorize("hasRole('ADMIN')")
 	public Page<StudentAssignment> AllStudent(int page, int size, String sortBy) {

 	    PageRequest pageable = PageRequest.of(page, size, Sort.by(sortBy).ascending());

 	    return repo.findAll(pageable);
 	}

 	public StudentAssignment updateStudent(int id, StudentAssignment updatedStudent) {
		
		StudentAssignment student = repo.findById(id).orElseThrow();

		student.setName(updatedStudent.getName());
		student.setEmail(updatedStudent.getEmail());
		student.setCourse(updatedStudent.getCourse());
		student.setMarks(updatedStudent.getMarks());
		student.setProfileImage(updatedStudent.getProfileImage());
		student.setAssignmentFile(updatedStudent.getAssignmentFile());

 		String encoded = passwordencoder.encode(updatedStudent.getPassword());
		student.setPassword(encoded);

		return repo.save(student);
	}

 	public String deleteStudent(int id) {
		repo.deleteById(id);
		return "Student deleted successfully";
	}
 	
 

}