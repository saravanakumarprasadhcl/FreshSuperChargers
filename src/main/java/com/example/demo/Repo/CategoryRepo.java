package com.example.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.category;


public interface CategoryRepo extends JpaRepository<category, Long>{

}
