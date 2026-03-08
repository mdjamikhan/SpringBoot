package com.lpu.MobileApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lpu.MobileApp.entity.Product;

public interface productRepository extends JpaRepository<Product, Integer> {

}
