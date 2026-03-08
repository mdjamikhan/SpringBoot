package com.lpu.MobileApp.Service;

 import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.lpu.MobileApp.entity.Product;
import  com.lpu.MobileApp.repository.productRepository;
 
@Service
public class ProductService {
	private  productRepository productRepository;
	@Autowired
	
	public ProductService(productRepository productRepository) {
		super();
		this.productRepository=productRepository;
	}
	
	public List<Product> saveAllProduct(List<Product> p) {
		return productRepository.saveAll(p);
		 
	}
	
	public List<Product> productPagination(int pageNumber,int size) {
		Pageable pageable=PageRequest.of(pageNumber, size);
		
		return productRepository.findAll(pageable).getContent();
	}
	
	
	public List<Product> sortProductByFeildInDesc(String field){
		return productRepository.findAll(Sort.by(field).descending());

		
		
		
	}
	
	public List<Product> sortproductPagination(int pageNumber,int size,String field) {
		Pageable pageable=PageRequest.of(pageNumber, size, Sort.by(field).ascending());
		
		return productRepository.findAll(pageable).getContent();
	}
	

}
