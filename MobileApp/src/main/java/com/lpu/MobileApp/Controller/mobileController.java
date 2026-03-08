package com.lpu.MobileApp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lpu.MobileApp.Service.mobileService;
import com.lpu.MobileApp.dto.MobileDTO;
import com.lpu.MobileApp.entity.Mobile;

@RestController
@RequestMapping("/api/Mobile")
public class mobileController {
	
	
	@Autowired
	private mobileService service;
	
	
	@PostMapping("/addMobile")
	public ResponseEntity<MobileDTO> addMobile(@RequestBody MobileDTO m ){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.addData(m));
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<MobileDTO> findMobile(@PathVariable int id){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.fetctData(id));
	}
	
	@DeleteMapping("/deleteMobile/{id}")
	public String deleteMobile(@PathVariable int id){
		return (service.deleteMobile(id));
		
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<MobileDTO>> findingAll(){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.fetchAll());
	}
	
	@PostMapping("/updateData/{id}")
	public ResponseEntity<MobileDTO> updateData(@PathVariable int id,@RequestBody MobileDTO dt){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.updateData(id, dt));
	}
	
	@GetMapping("/search/{id}")
	public String search(@PathVariable int id) {
		MobileDTO dt= service.searchData(id);
		if(dt==null) return "Mobile Data is Not Found";
		
		return dt.toString();
	}
	
	@PostMapping("/saveAllMobile")
	public ResponseEntity<List<MobileDTO>> savelAll(@RequestBody List<Mobile> m){
		
		
	return ResponseEntity.status(HttpStatus.CREATED).body(service.saveAllProduct(m));
	}
	
	
	
	@GetMapping("/pageMobile/{pageNumber}/{size}/{field}")
	public List<MobileDTO> getPage(@PathVariable int pageNumber, @PathVariable int size, @PathVariable String field){
		return service.pageMobile(pageNumber, size, field);
	}
	
	@GetMapping("/sortDesc/{field}")
	public ResponseEntity<List<MobileDTO>> sortDesc(@PathVariable String field ){
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.sortInDesc(field));
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
