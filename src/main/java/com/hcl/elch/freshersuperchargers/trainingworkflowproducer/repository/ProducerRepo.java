package com.hcl.elch.freshersuperchargers.trainingworkflowproducer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hcl.elch.freshersuperchargers.trainingworkflowproducer.entity.Task;

public interface ProducerRepo extends JpaRepository<Task, Long>{
	@Query("SELECT e FROM Task e WHERE e.Status = ?1 and CURDATE() > e.duedate")
	List<Task> findByStatus(String course);
}
