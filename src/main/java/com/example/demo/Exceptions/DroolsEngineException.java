package com.example.demo.Exceptions;

public class DroolsEngineException extends Exception 
{

	public  DroolsEngineException(String str,Exception e) {	
		super(str);
		System.out.println(e);
	}
}
