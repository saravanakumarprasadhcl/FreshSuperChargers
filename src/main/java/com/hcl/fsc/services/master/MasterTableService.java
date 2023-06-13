package com.hcl.fsc.services.master;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.fsc.mastertables.CustomerName;
import com.hcl.fsc.repositories.master.CustomerNameRepository;

@Service
public class MasterTableService {

	@Autowired
	private CustomerNameRepository customerNameRepository;

	public List<CustomerName> getAllCustomerName() {
		return this.customerNameRepository.findAll();
	}

}
