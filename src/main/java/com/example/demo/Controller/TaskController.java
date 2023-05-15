package com.example.demo.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Task;
import com.example.demo.Entity.category;
import com.example.demo.Service.TaskService;
import com.example.demo.Service.categoryservice;


@RestController
public class TaskController {
	
	 @Autowired
	    private TaskService ts;
	 
	@Autowired 
	private categoryservice cr;
 
	    @PostMapping("/get")
	    public ResponseEntity<Task> getStatus(@RequestBody Task task) {
	    try {
	    	//task.setStatus("Completed");
	    	//ts.add(task);
	    	category c=cr.get(task.getUserId());
	    	System.out.println(c.getCategory());
	        Task st = ts.getStatus(task,c);
	        ts.setcmplt(task);
	        ts.save(st);
	        return new ResponseEntity<>(st, HttpStatus.OK);
	    }catch(Exception e)
	    {
	    	System.out.println(e);
	    	return new ResponseEntity<>(task, HttpStatus.BAD_REQUEST);
	    }
	
	    }
	    
	    @PostMapping("/add")
	    public ResponseEntity adddata(@RequestBody Task task){
	    	try {
	    		ts.save(task);
	    		return new ResponseEntity<>(HttpStatus.CREATED);
	    	}
	    	catch(Exception e)
	    	{
	    		System.out.println(e);
	    		return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	    	}

	    }
	    
	    @GetMapping("/search")
	    public ResponseEntity<List<Task>> searchbyuserid(@RequestParam long userid){
	    	List<Task> t=ts.getbyuserid(userid);
	    	return new ResponseEntity<>(t,HttpStatus.ACCEPTED);
	    } 
	   
}
