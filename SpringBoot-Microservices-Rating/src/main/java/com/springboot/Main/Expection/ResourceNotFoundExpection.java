package com.springboot.Main.Expection;

public class ResourceNotFoundExpection extends RuntimeException
{
	public ResourceNotFoundExpection()
	{
		super("Resource not Found Expection");
	}
	
	public ResourceNotFoundExpection(String message)
	{
		super(message);
	}
}
