package com.example.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Modules;
import com.example.entity.Task;

public interface ModuleRepo extends JpaRepository<Modules, Long>{
	Modules getBymoduleName(String Name);
}
