package com.lpu.MobileApp.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.lpu.MobileApp.dto.MobileDTO;
import com.lpu.MobileApp.entity.Mobile;
import com.lpu.MobileApp.entity.Product;
import com.lpu.MobileApp.repository.MobileRepository;

@Service
public class mobileService {
	
	@Autowired
	private MobileRepository mobrepo;
	
	
	
	@CachePut(value="Mobiles",key="#result.id")

	public MobileDTO addData(MobileDTO dd) {
		Mobile mv=  DTOtoEntity(dd);
		
		Mobile mob=mobrepo.save(mv);
		
		return EntityToDTO(mob);	
		
	}
	

	public Mobile DTOtoEntity(MobileDTO dto) {
		Mobile mm=new Mobile();
		mm.setBrandName(dto.getBrandName());
		mm.setColor(dto.getColor());
		mm.setPrice(dto.getPrice());
		mm.setRam(dto.getRam());
		mm.setModelName(dto.getModelName());
		mm.setStorage(dto.getStorage());
		return mm;
	}
	public MobileDTO EntityToDTO(Mobile dto) {
		MobileDTO mm=new MobileDTO();
		mm.setBrandName(dto.getBrandName());
		mm.setId(dto.getId());
		mm.setColor(dto.getColor());
		mm.setPrice(dto.getPrice());
		mm.setRam(dto.getRam());
		mm.setModelName(dto.getModelName());
		
		mm.setStorage(dto.getStorage());
		return mm;
	}
	@Cacheable(value="Mobiles",key="#id")
	public MobileDTO fetctData(int id) {
		
		Mobile mv=mobrepo.findById(id).get();
		MobileDTO change=EntityToDTO(mv);
		
		return change;
	}
	
	@CacheEvict(value="Mobiles",allEntries = true)
	public String deleteMobile(int id) {
		mobrepo.deleteById(id);
		
		
		return "Data delete Successfully";
	 
	}
	@Cacheable(value="Mobiles")
	public List<MobileDTO> fetchAll(){
 		List<Mobile> checker=mobrepo.findAll();
 		
 		List<MobileDTO> ans=checker.stream().map(this:: EntityToDTO).toList();
 		
 		return ans;
	}
	
	@CachePut(value="Mobiles",key="#id")
	public MobileDTO updateData(int id,MobileDTO dto) {
 		 Mobile mv=mobrepo.findById(id).get();
 		 mv.setBrandName(dto.getBrandName());
 		 mv.setColor(dto.getColor());
 		 mv.setModelName(dto.getModelName());
 		 mv.setPrice(dto.getPrice());
 		 mv.setRam(dto.getRam());
 		 mv.setStorage(dto.getStorage());
 		 
 		 Mobile upd=mobrepo.save(mv);
 		 
 		 MobileDTO dt=EntityToDTO(mv);
 		 return dt;
	}
	@Cacheable(value="Mobiles",key="#id")
	public MobileDTO searchData(int id) {
		Mobile checker=mobrepo.findById(id).orElseThrow(()-> new IllegalArgumentException("No data is found"));
		MobileDTO dto=EntityToDTO(checker);
		return dto;
	}
	
	
	
	public List<MobileDTO> saveAllProduct(List<Mobile> p) {
		
		List<Mobile>ans=mobrepo.saveAll(p);
 
		return ans.stream().map(this::EntityToDTO).toList();
		 
	}
	
	public List<MobileDTO> pageMobile(int pageNumber,int size,String field){
		Pageable pageable=PageRequest.of(pageNumber, size, Sort.by(field).ascending());
		
	    List<Mobile> mobiles = mobrepo.findAll(pageable).getContent();
	    
	    return mobiles.stream().map(this:: EntityToDTO).toList();	
		 
	}
	
	public List<MobileDTO> sortInDesc(String field){
		
		  List<Mobile> mob=mobrepo.findAll(Sort.by(field).descending());
		  return mob.stream().map(this:: EntityToDTO).toList();
		
	}
	
	

}
