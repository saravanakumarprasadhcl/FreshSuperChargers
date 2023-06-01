package com.hcl.fsc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.fsc.mastertables.Location;

public interface LocationRepository extends JpaRepository<Location, String> {

}
