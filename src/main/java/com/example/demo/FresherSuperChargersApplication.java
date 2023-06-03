package com.example.demo;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.camunda.bpm.spring.boot.starter.event.PostDeployEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.example.demo.Controller.TaskController;
import com.example.demo.Service.SchedulerService;
import com.example.demo.Service.SchedulerServiceImpl;
import com.example.demo.Service.TaskServiceImpl;

@SpringBootApplication
@EnableProcessApplication
@EnableScheduling
@EntityScan(basePackages = {"com.example.entity"})
public class FresherSuperChargersApplication {
	public static void main(String[] args) {
		SpringApplication.run(FresherSuperChargersApplication.class, args);
	}
}
