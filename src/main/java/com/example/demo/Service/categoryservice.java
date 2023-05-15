package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.category;
import com.example.demo.Repo.CategoryRepo;


@Service
public class categoryservice {

	@Autowired
	private CategoryRepo cr;
	
	public category get(long id)
	{
		category c=cr.findById(id).get();
		return c;
	}
	
	
	
}
