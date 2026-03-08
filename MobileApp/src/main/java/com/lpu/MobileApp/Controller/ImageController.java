package com.lpu.MobileApp.Controller;

 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
 import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.lpu.MobileApp.entity.FileData;
import com.lpu.MobileApp.entity.Mobile;
import com.lpu.MobileApp.repository.ImageDataRepository;
import com.lpu.MobileApp.repository.MobileRepository;

@RestController
@RequestMapping("/fileApi")

public class ImageController    {
	@Autowired
	private ImageDataRepository imageDatarepo;
	@Autowired
	private MobileRepository mobRepo;
	
	@PostMapping("/upload")
	public String upload(@RequestParam("file") MultipartFile file) throws Exception{
		FileData fi=new FileData();
		fi.setFileName(file.getOriginalFilename());
		fi.setFieldType(file.getContentType());
		fi.setData(file.getBytes());
		FileData saved=imageDatarepo.save(fi);
		return "Saved In DB with ID: "+fi.getId();
	}
	
	@GetMapping("/getImage/{id}")
	public ResponseEntity<byte[]> getImage(@PathVariable long id){
		FileData f=imageDatarepo.findById(id).orElseThrow();
		
		//return ResponseEntity.status(HttpStatus.ACCEPTED).contentType(MediaType.IMAGE_JPEG).body(f.getData());
		
		return ResponseEntity.ok()
		        .header(HttpHeaders.CONTENT_DISPOSITION, "Inline;filename=image.jpg") // attachment=DOwnload // Inline = display
		        .contentType(MediaType.IMAGE_JPEG)
		        .body(f.getData());
		
	}
	@PostMapping("/uploadImage/{id}/image")
	public String uploadImage(@PathVariable int id,
	                          @RequestParam("file") MultipartFile file) throws Exception {

	    Mobile mob = mobRepo.findById(id).orElseThrow();

	    FileData fi = new FileData();
	    fi.setFileName(file.getOriginalFilename());
	    fi.setFieldType(file.getContentType());
	    fi.setData(file.getBytes());

	    FileData savedImage = imageDatarepo.save(fi);

	    mob.setFileData(savedImage);   
	    mobRepo.save(mob);

	    return "Image uploaded and linked to mobile id: " + id;
	}

}
