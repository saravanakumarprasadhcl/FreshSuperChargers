package com.example.demo.Controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.Exceptions.CamundaException;
import com.example.demo.Repo.CategoryRepo;
import com.example.demo.Repo.UserRepo;
import com.example.demo.Service.TaskServiceImpl;
import com.example.entity.Task;
import com.example.entity.category;



@Component
public class Servicetask2 implements JavaDelegate{
	
	
	@Autowired
	 private TaskServiceImpl ts;
	 
	@Autowired 
	private CategoryRepo cr;
	
	@Autowired 
	private UserRepo ur;

	@Override
	public void execute(DelegateExecution execution) throws CamundaException{
	 try {
		System.out.println("/////////////////////Final Service task///////////////////");
		Task task=new Task();
		String date= (String) execution.getVariable("duedate");
		String userid= (String) execution.getVariable("userId");
		String taskid= (String) execution.getVariable("TaskId");
		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate  d1 = LocalDate.parse(date, df);
		//System.out.println("Approver By"+execution.getVariable("approver")); 
		task.setTask((String) execution.getVariable("task"));
		task.setStatus((String) execution.getVariable("status"));
		task.setDuedate(d1);
		task.setUserId(Long.parseLong(userid));
		task.setTaskId(Long.parseLong(taskid));
		String Approver= TaskAssignmentListener.Assignee;
		task.setApprover((String) execution.getVariable("approver"));
		System.out.println(d1);
		System.out.println(task.getTask());
		nextTask(task);
	  }
	  catch(Exception e)
	 {
		  System.out.println("An Exception from Final Service Task Due to ");
		  throw new BpmnError("Camunda Exception",e);
	 }
	 
	}
	
	
    public void nextTask(Task task) {
    try
    {
    	System.out.println(task.getUserId());
    	category c=cr.findById(task.getUserId()).get();
    	//category c=cr.get(task.getUserId());
    	System.out.println(c.getCategory()+" "+c.getUserId());
        Task st = ts.getStatus(task,c);
        ts.setcmplt(task);
        ts.save(st);
    }
    catch(Exception e)
    {
    	System.out.println(e);
    }
}}
