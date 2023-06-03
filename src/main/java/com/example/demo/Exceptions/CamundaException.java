package com.example.demo.Exceptions;

public class CamundaException extends Exception {
	
	public CamundaException(String s,Exception e)
	{
		//super(s);
		System.out.println(s);
	}

}
