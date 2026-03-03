package com.lpu.EmployeeApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lpu.EmployeeApp.entity.CompanyApp;

public interface CompanyRepository  extends JpaRepository<CompanyApp, Integer>{

}
