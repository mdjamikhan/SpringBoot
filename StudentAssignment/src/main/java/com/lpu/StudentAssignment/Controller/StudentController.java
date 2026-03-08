package com.lpu.StudentAssignment.Controller;

import java.io.IOException;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.lpu.StudentAssignment.Entity.StudentAssignment;
import com.lpu.StudentAssignment.Service.StudentService;
import com.lpu.StudentAssignment.exception.SMSException;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class StudentController {
	
	private final StudentService service;

	public StudentController(StudentService service) {
		super();
		this.service = service;
	}
	
	@PostMapping("/register")
	public StudentAssignment save(
			@RequestParam String name,
			@RequestParam String email,
			@RequestParam String course,
			@RequestParam double marks,
			@RequestParam String password,
			@RequestParam String role,
			@RequestParam MultipartFile profileImage,
			@RequestParam MultipartFile assignmentFile
			) throws IOException {
		
		StudentAssignment student = new StudentAssignment();
		
		student.setName(name);
		student.setEmail(email);
		student.setCourse(course);
		student.setMarks(marks);
		student.setPassword(password);
		student.setRole(role);
		student.setProfileImage(profileImage.getBytes());
		student.setAssignmentFile(assignmentFile.getBytes());
		
		return service.saveStudent(student);
	}
	@GetMapping("/{id}")
	public StudentAssignment getStudent(@PathVariable int id) throws SMSException {
		return service.findStudent(id);
	}
	@GetMapping("/all")
	public Page<StudentAssignment> getAllStudents(
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "5") int size,
			@RequestParam(defaultValue = "name") String sortBy) {

		return service.AllStudent(page, size, sortBy);
	}
	
	@PutMapping("/update/{id}")
	public StudentAssignment updateStudent(
			@PathVariable int id,
			@RequestBody StudentAssignment student) {

		return service.updateStudent(id, student);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteStudent(@PathVariable int id) {
		return service.deleteStudent(id);
	}
	
	@GetMapping("/image/{id}")
	public ResponseEntity<byte[]> getImage(@PathVariable int id) throws SMSException {

	    StudentAssignment student = service.findStudent(id);

	    return ResponseEntity.ok()
	            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=assignmentFile.pdf")
	            .contentType(MediaType.APPLICATION_PDF)
	            .body(student.getAssignmentFile());
	}


}



















