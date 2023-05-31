package com.hcl.fsc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.fsc.mastertables.State;

public interface StateRepository extends JpaRepository<State, String>{

}
