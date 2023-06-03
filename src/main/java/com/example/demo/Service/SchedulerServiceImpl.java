package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.entity.Task;
import com.example.demo.Controller.TaskController;
import  com.example.demo.Repo.SchedulerRepository;

@Service
public class SchedulerServiceImpl implements SchedulerService {
	
	@Autowired
	private SchedulerRepository repo;
	
	@Autowired
	private TaskController cc;
	
	//scheduler for fetch data daily 12am & 12pm

	@Scheduled(cron = "*/10 * * * * *")
	public void fetchTask() {
	 try {
		List<Task> t=repo.findByStatus("InProgress");
		for(Task task1:t) { 
			System.out.println("Schedular Data : "+task1);
			cc.getdetails(task1);
			task1.setStatus("processing");
            repo.save(task1);
		}	
	 }
	 catch(Exception e)
	 {
		 System.out.println("Exception occured, Unable to perform Scheduler Task "+e);
	 }
  }
	
}
