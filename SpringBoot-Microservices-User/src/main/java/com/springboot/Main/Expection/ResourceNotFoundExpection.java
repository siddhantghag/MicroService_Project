package com.springboot.Main.Expection;

public class ResourceNotFoundExpection extends RuntimeException
{
	public 	ResourceNotFoundExpection()
	{
		super("Resource not found on server !!!");
	}
	
	public 	ResourceNotFoundExpection(String message)
	{
		super(message);
	}
}
