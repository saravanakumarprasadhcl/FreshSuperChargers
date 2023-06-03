package com.example.demo.Controller;


import java.time.LocalDate;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.variable.Variables;
import org.camunda.bpm.engine.variable.value.ObjectValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.Config.consumer;
import com.example.demo.Exceptions.CamundaException;
import com.example.demo.Repo.ModuleRepo;
import com.example.demo.Repo.TaskRepo;
import com.example.demo.Repo.UserRepo;
import com.example.demo.Service.SchedulerService;
import com.example.demo.Service.TaskServiceImpl;
import com.example.demo.Service.categoryservice;
import com.example.entity.Modules;
import com.example.entity.Task;
import com.example.entity.category;
import com.example.entity.user;


@RestController
public class TaskController implements JavaDelegate {
	
	 @Autowired
	 private RuntimeService runtimeService;
	
	 @Autowired
	 private TaskServiceImpl ts;
	 
	 
	@Autowired 
	private categoryservice cr;
	
	@Autowired 
	private UserRepo ur;
	
	@Autowired 
	private ModuleRepo mr;
	
	@Autowired 
	private TaskRepo tr;
	
	@Autowired 
	RuntimeService  rs;
	
	public Task glob;
	
	
		 public void getdetails(Task task) throws CamundaException
		 {
			 try {
			    Map<String, Object> variables = new HashMap<String, Object>();
			    variables.put("glo",task);
		    	System.out.println("Start Event Connected");
		    	glob=task;
		    	RestTemplate rt=new RestTemplate();
		    	HttpHeaders httpHeaders=new HttpHeaders();
		    	httpHeaders.add("Content_Type","application/json");
		    	HttpEntity<Task> httpen=new HttpEntity<>(task,httpHeaders);
		    	//Sending postman request to Camunda
		    	ResponseEntity<String> re=rt.postForEntity("http://localhost:9002/engine-rest/process-definition/key/Decision/start", httpen, String.class);
			 }
			 catch(Exception e)
			 {
				 System.out.println("Camunda exception Occured");
				 throw new CamundaException("Unable to start the process",e);
			 }
		 }
	
	    
	    public String camundatask1(Task glob) throws Exception
	    {
	    	try {
	    		category c=cr.get(glob.getUserId());
	    		user u=ur.getById(glob.getUserId());
	    		return u.getEmail();
	    	}
	    	catch(Exception e) 
	    	{
	    		System.out.println("Exception Occured, Unable to fetch Email Id ");
	    		throw new Exception(e);
	    	}
	    }
	    
	    
	    public Modules category(Task glob) throws Exception
	    {
	    	try {
	    		Modules m=mr.getBymoduleName(glob.getTask().toUpperCase());
	    		if( m == null)
	    		{
	    			throw new Exception("Task value is Incorrect");
	    		}
	    		else {
	    		   return m;
	    		}
	    	}
	    	catch(Exception e) 
	    	{
	    		//glob.setStatus("Error");
	    		//ts.add(glob);
	    		System.out.println("Exception Occured, Task value is Incorrect or Null");
	    		throw new Exception(e);
	    	}
	    }
	    
	    

	    
		@Override
		public void execute(DelegateExecution execution) throws CamundaException 
		{
		try {
			System.out.println("///////////This is a Service task to send EmailId///////////////");
			Task glo=(Task) execution.getVariable("glob");
			String s=camundatask1(glob);
			execution.setVariable("Email",s);
			Modules m=category(glob);
			execution.setVariable("test", m.getExam());
			execution.setVariable("groupId",m.getGroupId());
			execution.setVariable("task", glob.getTask().toUpperCase());
			execution.setVariable("TaskId", Long.toString(glob.getTaskId()));
			execution.setVariable("userId", Long.toString(glob.getUserId()));
			execution.setVariable("status", glob.getStatus());
			LocalDate localDate = glob.getDuedate();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			String date = localDate.format(formatter);
			execution.setVariable("duedate", date);
		}
		catch(Exception e) 
		{
			throw new BpmnError("Error,  Some Values are missing or wrong in task details",e);
		}
	  } 
		
}
