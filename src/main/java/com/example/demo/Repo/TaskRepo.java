package com.example.demo.Repo;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Task;

public interface TaskRepo extends JpaRepository<Task, Long> {

	List<Task> getByuserId(long userId);
	
	Task getBytaskId(long taskId);

}
