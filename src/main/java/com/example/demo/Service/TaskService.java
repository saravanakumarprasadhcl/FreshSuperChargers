package com.example.demo.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Entity.Task;
import com.example.demo.Entity.category;
import com.example.demo.Repo.TaskRepo;


@Service
public class TaskService {
	
	 @Autowired
	 private KieContainer kieContainer;
	 
	 @Autowired
	 private TaskRepo tr;
	 
	 String status="Completed";

	public Task getStatus(Task task,category category) {
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
		  System.out.println(e);
	  }
	}


	public void add(Task t)
	{
		tr.save(t);
	}
	
	
	//to update status of current task 
	public void setcmplt(Task task) {
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
		tr.save(t1);
	}
	
	public List<Task> getbyuserid(long id){
		return tr.getByuserId(id);
	}
}
