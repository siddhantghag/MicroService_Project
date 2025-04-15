package com.springboot.Main.Expection;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.springboot.Main.Payload.ApiResponces;

@RestControllerAdvice
public class GlobalExpectionHandler 
{
	@ExceptionHandler(ResourceNotFoundExpection.class)
	public ResponseEntity<ApiResponces> handlerResourceNotFoundExpection(ResourceNotFoundExpection resourceNotFoundExpection)
	{
		String message =resourceNotFoundExpection.getMessage(); 
		ApiResponces responces = new ApiResponces();
		responces.setMessage(message);
		responces.setSucces(true);
		responces.setHttpStatus(HttpStatus.NOT_FOUND);
		return  new ResponseEntity<ApiResponces> (responces ,HttpStatus.NOT_FOUND);
		
	}
}
