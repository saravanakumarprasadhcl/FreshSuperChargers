package com.hcl.elch.freshersuperchargers.trainingworkflow.controller;

import org.camunda.bpm.engine.RuntimeService;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;
import org.camunda.bpm.engine.IdentityService;
import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.kie.internal.task.api.TaskVariable.VariableType;
import org.camunda.bpm.engine.identity.User;
import org.springframework.beans.factory.annotation.Autowired;

import com.hcl.elch.freshersuperchargers.trainingworkflow.entity.Task;
import com.hcl.elch.freshersuperchargers.trainingworkflow.exceptions.CamundaException;

public class JavaEmailSending implements JavaDelegate {
	
	@Autowired
	private TaskController tc;
	
	@Autowired
	RuntimeService rs;
	
  public String mailSending(String Email,String Task) {
	System.out.println(Email+" "+Task); 
	
	  /*final String HOST = "";
	  final String USER = "";
	  final String PWD = "";
	  
	  final Logger LOGGER = Logger.getLogger(JavaEmailSending.class.getName());
	
	  String recipient = Email;
	  
	  if (recipient != null && !recipient.isEmpty()) {

          Email email = new SimpleEmail();
          email.setCharset("utf-8");
          email.setHostName(HOST);
          email.setAuthentication(USER, PWD);
          try {
	            email.setFrom("noreply@camunda.org");
	            email.setSubject("Exam Link for "+Task);
	            email.setMsg("Please complete: Exam Link");

	            email.addTo(recipient);

	            email.send();
	            LOGGER.info(
	                "Task Exam Link Email successfully sent to user '");
	          } 
	          catch (Exception e) {
	            LOGGER.log(Level.WARNING, "Could not send email", e);
	          }
	  }
	  else {
          LOGGER.warning("Not sending email to user, "  + " user has no email address.");
        }*/

	  return "Emailing";
  }

  	@Override
  	public void execute(DelegateExecution execution) throws CamundaException 
  	{
  		try {
  		System.out.println("///////////This is Email Sending Task about status////////////////");
  		String Email=(String) execution.getVariable("Email");
  		String Task=(String) execution.getVariable("task");
  		String s=mailSending(Email,Task.toUpperCase());
  		System.out.println(s);
  		}catch(Exception e)
  		{
  			e.printStackTrace();
  			throw new BpmnError("Exception Occured", e);
  		}
	}
}