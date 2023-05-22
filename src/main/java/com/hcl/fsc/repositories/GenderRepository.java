package com.hcl.fsc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.hcl.fsc.mastertables.Gender;


@Repository
public interface GenderRepository extends JpaRepository<Gender, Integer>{

}
