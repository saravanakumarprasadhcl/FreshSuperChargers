package com.example.demo.Exceptions;

public class kafkareceiverexception extends Exception
{
	public kafkareceiverexception(String str, Exception e) {	
		super(str);
		System.out.println(e);
	}  

}
