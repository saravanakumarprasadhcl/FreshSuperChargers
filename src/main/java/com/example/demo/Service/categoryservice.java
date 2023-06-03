package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repo.CategoryRepo;
import com.example.entity.category;


@Service
public class categoryservice {

	@Autowired
	private CategoryRepo cr;
	
	public category get(long id) throws Exception
	{
		try {
			category c=cr.findById(id).get();
			return c;
		} 
		catch(Exception e)
		{
			System.out.println("Exception Occured unable to fetch values of id, Id is null or Incorrect ");
			throw new Exception(e);
		}
		
	}
	
	
	
}
