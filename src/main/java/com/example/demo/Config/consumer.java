package com.example.demo.Config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.demo.Controller.TaskController;
import com.example.demo.Exceptions.kafkareceiverexception;
import com.example.entity.Task;


@Service
public class consumer {
	
	@Autowired
	private TaskController cc;
	
	
	@KafkaListener(topics = "newTask", groupId = "myGroup1")
	public void receiveFomKafka(Task t) throws kafkareceiverexception {
	 try {
		System.out.println("Message received :- "+t.toString());
		cc.getdetails(t);
	}
	catch(Exception e)
	 {
		System.out.println("Caught the Kafka Exception");
		throw new kafkareceiverexception("Unable to receive messages from producer",e); 
	 }
	}
}
