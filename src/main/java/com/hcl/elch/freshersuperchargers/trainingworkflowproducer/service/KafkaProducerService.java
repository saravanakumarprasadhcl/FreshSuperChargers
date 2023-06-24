package com.hcl.elch.freshersuperchargers.trainingworkflowproducer.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.hcl.elch.freshersuperchargers.trainingworkflowproducer.entity.Task;
import com.hcl.elch.freshersuperchargers.trainingworkflowproducer.repository.ProducerRepo;

@Service
public class KafkaProducerService {

	private final KafkaTemplate<String,Task> kafkaTemplate;
	
	@Autowired
	private ProducerRepo repo;

	@Autowired
	public KafkaProducerService(KafkaTemplate<String, Task> kafkaTemplate) {
	this.kafkaTemplate = kafkaTemplate;
	}
	
	@Scheduled(fixedRate = 1000) //Fetching data 
	public void sendMessage() {
		List<Task> t=repo.findByStatus("InProgress");
		//t.forEach(task-> kafkaTemplate.send("newTask",Long.toString(task.getId()),task));
		for(Task t1:t) {
			kafkaTemplate.send("newTask",Long.toString(t1.getId()),t1);
			t1.setStatus("Processing");
			repo.save(t1);				
		}
	}
	//This is for testing purpose

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducerService.class);

	@KafkaListener(topics = "newTask", groupId = "myGroup1")
	public void receiveFomKafka(Task t) {
		LOGGER.info("Message from kafka topic is :- "+t.toString());
	}
}
