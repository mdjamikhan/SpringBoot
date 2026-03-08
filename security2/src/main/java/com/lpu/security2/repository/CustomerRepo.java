package com.lpu.security2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lpu.security2.Entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {

    Customer findByName(String name);

}