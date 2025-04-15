package com.springboot.Main.Expection;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExpectionHandler 
{
	@ExceptionHandler(ResourcesNotFoundExpection.class)
	public ResponseEntity<Map<String ,Object>> notFoundExpection(ResourcesNotFoundExpection ex)
	{
		Map map = new HashMap<>();
		map.put("message", ex.getMessage());
		map.put("succes", false);
		map.put("status", HttpStatus.NOT_FOUND);	
		return  new ResponseEntity<Map<String,Object>>(map ,HttpStatus.NOT_FOUND);  
	}
}
