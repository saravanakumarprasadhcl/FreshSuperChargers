package com.example.demo.Controller;

import java.util.logging.Level;

import java.util.logging.Logger;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;
import org.camunda.bpm.engine.IdentityService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.delegate.TaskListener;
import org.camunda.bpm.engine.identity.User;
import org.camunda.bpm.engine.impl.context.Context;

public class TaskAssignmentListener implements TaskListener {

	  protected static final String HOST = "";
	  protected static final String USER = "";
	  protected static final String PWD = "";
	  public static String Assignee=null;

	  protected final static Logger LOGGER = Logger.getLogger(TaskAssignmentListener.class.getName());

	  public void notify(DelegateTask delegateTask) {

		  
		  System.out.println("//////////////This is the user task///////////////////");
		  String taskId = delegateTask.getId();
		  String assignee = delegateTask.getAssignee();
		  System.out.println("Assignee "+assignee);
		  System.out.println("http://localhost:8080/camunda/app/tasklist/default/#/task="+taskId);
		  Assignee=assignee;
	   /* String assignee = delegateTask.getAssignee();
	    //String taskId = delegateTask.getId();

	    if (assignee != null) {

	      IdentityService identityService = Context.getProcessEngineConfiguration().getIdentityService();
	      User user = identityService.createUserQuery().userId(assignee).singleResult();

	      if (user != null) {

	        String recipient = user.getEmail();
           System.out.println("Recipient :"+recipient);
           System.out.println("http://localhost:8080/camunda/app/tasklist/default/#/task="+taskId);
	        /*if (recipient != null && !recipient.isEmpty()) {

	          Email email = new SimpleEmail();
	          email.setCharset("utf-8");
	          email.setHostName(HOST);
	          email.setAuthentication(USER, PWD);

	          try {
	            email.setFrom("noreply@camunda.org");
	            email.setSubject("Task assigned: " + delegateTask.getName());
	            email.setMsg("Please complete: http://localhost:8080/camunda/app/tasklist/default/#/task=" + taskId);

	            email.addTo(recipient);

	            email.send();
	            LOGGER.info(
	                "Task Assignment Email successfully sent to user '" + assignee + "' with address '" + recipient + "'.");
	          } 
	          catch (Exception e) {
	            LOGGER.log(Level.WARNING, "Could not send email to assignee", e);
	          }

	        } 
	        else {
	          LOGGER.warning("Not sending email to user " + assignee + "', user has no email address.");
	        }

	      } 
	      else {
	        LOGGER.warning("Not sending email to user " + assignee + "', user is not enrolled with identity service.");
	      }

	    }*/  

	  }

	}