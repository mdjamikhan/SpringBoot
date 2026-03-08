package com.lpu.MobileApp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lpu.MobileApp.Service.ProductService;
import com.lpu.MobileApp.entity.Product;

@RestController

public class ProductController {
	@Autowired
	private ProductService productService;
	
	
	@PostMapping("/saveAllPro")
	public List<Product> saveAllPro(@RequestBody List<Product> ls){
		return  productService.saveAllProduct(ls);
	}
	
	@GetMapping("/page/{pageNumber}/{size}")
	
	private List<Product> productPage( @PathVariable int pageNumber, @PathVariable int  size){
		return productService.productPagination(pageNumber, size);
	}
	@GetMapping("/sort/{field}")
	private List<Product> sortByFeild(@PathVariable String field){
		return productService.sortProductByFeildInDesc(field);
	}
	@GetMapping("/pageWhilePagi/{pageNumber}/{size}/{field}")
	private List<Product> sortByWhilePageination(@PathVariable int pageNumber,@PathVariable int size,  @PathVariable String field){
		return productService.sortproductPagination(pageNumber, size, field);
	}

}
