package com.lpu.EmployeeApp.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Entity

public class EmployeeApp  implements Serializable{
	
    private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	
	private int id;
 	
	
	private String name;
 	private long phone;
	
 
	private String email;
 
	private int age;
	
	@ManyToOne
	@JoinColumn
	@JsonBackReference
	private CompanyApp company;
	
	
	
	
	
	
	
	
	public CompanyApp getCompany() {
		return company;
	}
	public void setCompany(CompanyApp company) {
		this.company = company;
	}
	public EmployeeApp() {
		 
	}
	public int getId() {
		return id;
	}
  
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	
	
	
	

}
