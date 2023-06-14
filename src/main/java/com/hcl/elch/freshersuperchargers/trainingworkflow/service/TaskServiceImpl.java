package com.hcl.elch.freshersuperchargers.trainingworkflow.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.hcl.elch.freshersuperchargers.trainingworkflow.controller.TaskController;
import com.hcl.elch.freshersuperchargers.trainingworkflow.entity.Task;
import com.hcl.elch.freshersuperchargers.trainingworkflow.entity.Category;
import com.hcl.elch.freshersuperchargers.trainingworkflow.exceptions.DroolsEngineException;
import com.hcl.elch.freshersuperchargers.trainingworkflow.repo.TaskRepo;


@Service
public class TaskServiceImpl {
	
	 @Autowired
	 private KieContainer kieContainer;
	 
	 @Autowired
	 private TaskRepo tr;
	 
	 String status="Completed";
	 

	public Task getStatus(Task task,Category category) throws DroolsEngineException{
	try {
		Map<String,List<String>> tasks=new HashMap<>();
		tasks.put("group1",Arrays.asList("NEW_HIRE","FUNDAMENTALS","DATABASE", "DB_EXAM", "JAVA"));
	    tasks.put("group2",Arrays.asList("FUNDAMENTALS","DATABASE", "DB_EXAM", "JAVA","SPRINGBOOT","JAVA_EXAM"));
	    tasks.put("group3",Arrays.asList("DATABASE", "DB_EXAM", "JAVA","SPRINGBOOT","JAVA_EXAM","JENKINS","AWS"));
	    tasks.put("group4",Arrays.asList("DATABASE", "DB_EXAM", "JAVA","SPRINGBOOT","JAVA_EXAM","JENKINS","AWS","SPLUNK"));
	    List<String> a=new ArrayList<>();
	    String s="null";
	    String last="null";
	    
	    System.out.println(tasks);
	    for(Map.Entry<String,List<String>> key : tasks.entrySet())
	    {
	    	if(key.getKey().equals(category.getCategory()))
	    	{
	    		a=key.getValue();
	    		System.out.println("Arraylist size:"+a.size());
	    		for(int i=0;i<a.size();i++)
	    		{
	    			if(i<a.size()-1 && a.get(i).equals(task.getTask()))
	    			{
	    			   s=a.get(i+1);
	    			}
	    		}
	    		if(s=="null")
	    		{
	    			s=a.get(a.size()-1);
	    		}
	    		if(task.getTaskId()==a.size())
	    		{
                   last="last";
	    		}
	    	}
	    }
	    System.out.println(last);
		System.out.println(category.getCategory()+" "+category.getUserId());
		if(last!="last") {
		KieSession kieSession =kieContainer.newKieSession();
		Task t1=new Task();
		kieSession.setGlobal("t1",t1);
		kieSession.setGlobal("tasks",tasks);
		kieSession.setGlobal("A",s);
		kieSession.insert(task);
		kieSession.insert(category);
		kieSession.fireAllRules();
		kieSession.dispose();
		return t1;
		}
		else {
			task.setStatus(status);
			return task;
		}}
	catch(Exception e)
	{
		System.out.println("Caught the Drools Exception");
		throw new DroolsEngineException("Unable to perform the Drools Task,Because of drl file", e);	
	}
	}

	
	//to save new record details 
	public void save(Task st) 
	{
	  try 
	  {
		  System.out.println(st.getStatus());
		  if(st.getStatus()!="Completed")
		  {
			  tr.save(st);
		  }
		  else {
			  //tr.save(st);
		  }
	  }
	  catch(Exception e)
	  {
		  System.out.println("Unable to add new task details "+e);
	  }
	}


	/*public  void add(Task t)
	{
		
		System.out.println(t.getStatus()+" "+t.getId());
		t.setStatus("InProgress");
		tr.save(t);
	}*/
	
	
	//to update status of current task 
	public void setComplete(Task task) {
	try {
		List<Task> t=tr.getByuserId(task.getUserId());
		long n = 0;
		for(Task tr: t)
		{
			if(tr.getTaskId()==task.getTaskId()) {
			  n=tr.getId();
			}
		}
		Task t1=tr.getById(n);
		System.out.println(task.getStatus());
		t1.setStatus(task.getStatus());
		System.out.println("Approver Name "+task.getApprover());
		t1.setApprover(task.getApprover());
		tr.save(t1);
	  }catch(Exception e)
		{
		  System.out.println("Exception occured, Unable to update the status of current task "+e);
		}
	}

	
	public List<Task> getByUserId(long id) throws Exception{
	  try {
		return tr.getByuserId(id);
	  }
	  catch(Exception e)
	  {
		  e.printStackTrace();
		  throw new Exception(e);
	  }
	}
	
}
