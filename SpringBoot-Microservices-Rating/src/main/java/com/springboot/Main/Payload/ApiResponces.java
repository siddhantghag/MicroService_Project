package com.springboot.Main.Payload;

import org.springframework.http.HttpStatus;

public class ApiResponces 
{
	private String message;
	private boolean succes;
	private HttpStatus httpStatus;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isSucces() {
		return succes;
	}
	public void setSucces(boolean succes) {
		this.succes = succes;
	}
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
	public ApiResponces(String message, boolean succes, HttpStatus httpStatus) {
		super();
		this.message = message;
		this.succes = succes;
		this.httpStatus = httpStatus;
	}
	public ApiResponces() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ApiResponces [message=" + message + ", succes=" + succes + ", httpStatus=" + httpStatus + "]";
	}
}
