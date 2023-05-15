package com.example.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.category;


public interface CategoryRepo extends JpaRepository<category, Long>{

}
