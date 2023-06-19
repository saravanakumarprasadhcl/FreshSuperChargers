package com.hcl.fsc.services;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import com.hcl.fsc.entities.EmployeeProjectDetails;

import com.hcl.fsc.repositories.EmployeeProjectDetailsRepository;


@Service

public class EmployeeProjectDetailsService {


    @Autowired

    private EmployeeProjectDetailsRepository employeeProjectDetailsRepository;


    public EmployeeProjectDetails add(EmployeeProjectDetails employeeProjectDetails) {

        return employeeProjectDetailsRepository.save(employeeProjectDetails);

    }


}