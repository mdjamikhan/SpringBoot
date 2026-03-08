package com.lpu.StudentAssignment.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalException {
	

	@ExceptionHandler(SMSException.class)
	public ResponseEntity<Map<String,String>> handleSmsNotFoundException(SMSException ex){
		Map<String,String> map = new HashMap<String,String>();
		map.put("error", ex.getMessage());
		
		return new ResponseEntity<Map<String,String>>(map, HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)    
	public ResponseEntity<Map<String,String>> handleMethodArgumentInvalidException(MethodArgumentNotValidException ex){
		Map<String, String> map = new HashMap<>();
		
		ex.getBindingResult().getFieldErrors().forEach(n -> map.put(n.getField(), n.getDefaultMessage()));
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Map<String,String>> handleException(Exception ex){
		Map<String,String> map = new HashMap<String,String>();
		map.put("error:", ex.getMessage());
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(map);
	}
}


