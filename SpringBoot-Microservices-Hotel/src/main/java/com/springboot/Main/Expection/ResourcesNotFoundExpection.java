package com.springboot.Main.Expection;

public class ResourcesNotFoundExpection extends RuntimeException
{
	public ResourcesNotFoundExpection(String s )
	{
		super(s);
	}
	public ResourcesNotFoundExpection( )
	{
		super("Resources not found expection");
	}
}
