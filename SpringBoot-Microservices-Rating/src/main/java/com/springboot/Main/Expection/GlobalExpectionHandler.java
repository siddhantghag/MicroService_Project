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
	public ResponseEntity<ApiResponces> globalExpectionHandle(ResourceNotFoundExpection expection)
	{
		ApiResponces apiResponces = new ApiResponces();
		apiResponces.setMessage("Resource Not Found ");
		apiResponces.setSucces(false);
		apiResponces.setHttpStatus(HttpStatus.NOT_FOUND);
		return  new ResponseEntity<ApiResponces>(apiResponces, HttpStatus.NOT_FOUND);
	}
}
