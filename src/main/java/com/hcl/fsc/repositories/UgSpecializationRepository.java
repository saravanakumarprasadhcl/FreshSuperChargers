package com.hcl.fsc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.fsc.mastertables.UgSpecialization;

public interface UgSpecializationRepository extends JpaRepository<UgSpecialization, String>{

}
