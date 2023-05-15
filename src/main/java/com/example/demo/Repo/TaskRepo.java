package com.example.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Task;

public interface TaskRepo extends JpaRepository<Task, Long> {

	Task getByuserId(long userId);
	
	Task getBytaskId(long taskId);
   
}
