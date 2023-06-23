package com.hcl.elch.freshersuperchargers.trainingworkflow.controller;

import java.util.List;
import java.util.Set;

import java.util.logging.Level;

import java.util.logging.Logger;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;
import org.camunda.bpm.engine.IdentityService;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.delegate.TaskListener;
import org.camunda.bpm.engine.identity.User;
import org.camunda.bpm.engine.identity.UserQuery;
import org.camunda.bpm.engine.impl.context.Context;
import org.camunda.bpm.engine.runtime.Execution;
import org.camunda.bpm.engine.task.IdentityLink;
import org.camunda.bpm.engine.variable.Variables;
import org.camunda.bpm.engine.variable.value.ObjectValue;
import org.springframework.beans.factory.annotation.Autowired;

import com.hcl.elch.freshersuperchargers.trainingworkflow.exceptions.CamundaException;

//import antlr.collections.List;

public class TaskAssignmentListener implements TaskListener {
	
		@Autowired 
		RuntimeService  rs;

	  protected static final String HOST = "";
	  protected static final String USER = "";
	  protected static final String PWD = "";
	  public static String Assignee=null;
     
	  protected final static Logger LOGGER = Logger.getLogger(TaskAssignmentListener.class.getName());
	  

	  public void notify(DelegateTask delegateTask) {

		 
		  System.out.println("//////////////This is the user task///////////////////");
		  System.out.println("Variables : "+delegateTask.getVariable("groupId"));
		  String taskId = delegateTask.getId();
		  String assignee = delegateTask.getAssignee();
		  List<User> userList = delegateTask.getProcessEngineServices().getIdentityService().createUserQuery().memberOfGroup((String) delegateTask.getVariable("groupId")).list();
		  System.out.println("Group users "+userList);  
		  Assignee=assignee;
	     
	    /*if (assignee != null) {

	      IdentityService identityService = Context.getProcessEngineConfiguration().getIdentityService();
		  User use = identityService.createUserQuery().userId(assignee).singleResult();
		  String email=use.getEmail();*/
		  
		  String recipient= "";
          for(User user : userList)
          {
        	  if (user != null) 
        	  {
        		  recipient+=user.getEmail()+",";
        		  System.out.println("Assignees :"+user.getFirstName());
        	  }
          }
	      System.out.println("Recipient :"+recipient.toString());
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
	            //email.addRecipients(Message.RecipientType.CC,
                      InternetAddress.parse(recipient));

	            email.send();
	            LOGGER.info(
	                "Task Assignment Email successfully sent to group '"  + "' with address '" + recipient + "'.");
	          } 
	          catch (Exception e) {
	            LOGGER.log(Level.WARNING, "Could not send email to assignees in group", e);
	          }

	        } 
	        else {
	          LOGGER.warning("Not sending email to group "  + "', users has no email address.");
	        }

	      } 
	      else {
	        LOGGER.warning("Not sending email to users " + "', users are not enrolled with identity service.");
	      }

	    }*/ 
	}
 }
