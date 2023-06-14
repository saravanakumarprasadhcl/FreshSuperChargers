package com.hcl.fsc.services.master;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.fsc.controllers.Response;
import com.hcl.fsc.customExpcetion.DuplicateValueException;
import com.hcl.fsc.customExpcetion.NullValueException;
import com.hcl.fsc.customExpcetion.ValueNotPresentException;
import com.hcl.fsc.mastertables.CustomerName;
import com.hcl.fsc.mastertables.CustomerName;
import com.hcl.fsc.repositories.master.CustomerNameRepository;
import com.hcl.fsc.repositories.master.HrL4Repository;

@Service
public class CustomerNameService {

	@Autowired
	private CustomerNameRepository customerNameRepository;

	public List<CustomerName> getAllCustomerName() {
		return this.customerNameRepository.findAll();
	}

	public Optional<CustomerName> getCustomerById(Integer uid) {
		return this.customerNameRepository.findById(uid);
	}

	public Response createNewCustomerName(CustomerName customerName) throws Exception {
		if (customerName.getUid() != null && this.customerNameRepository.existsById(customerName.getUid())) {
			throw new DuplicateValueException("Duplicate UID");
		}
		if (customerName.getCustomerName() == null) {
			throw new NullValueException("Customer name  is Empty");
		}
		if (this.customerNameRepository.existsCustomerNameBycustomerName(customerName.getCustomerName())) {
			throw new DuplicateValueException("Duplicate Customer Name");
		} else {
			if (this.customerNameRepository.findAll().size() == 0) {
				customerName.setUid(1);
				customerName.setCreatedDate(java.time.LocalDateTime.now());
			} else {
				Integer uid = this.customerNameRepository.findTopByOrderByUidDesc().getUid();
				customerName.setUid(++uid);
				customerName.setCreatedDate(java.time.LocalDateTime.now());
			}
			this.customerNameRepository.save(customerName);
		}
		return new Response("New Record Succefully Created");
	}

	public Response updateCustomerName(CustomerName customerName, Integer uid) throws Exception {
		if (!this.customerNameRepository.existsById(uid)) {
			throw new ValueNotPresentException("UId is not present");
		}
		if (customerName.getCustomerName() == null) {
			throw new NullValueException("Customer Name is Empty");
		}
		if (this.customerNameRepository.existsCustomerNameBycustomerName(customerName.getCustomerName())) {
			throw new DuplicateValueException("Duplicate Customer name");
		} else {
			CustomerName obj = this.customerNameRepository.getById(uid);
			customerName.setUid(uid);
			if (customerName.getCustomerName() == null) {
				customerName.setCustomerName(obj.getCustomerName());
			}
			customerName.setCreatedDate(obj.getCreatedDate());
			customerName.setUpdatedDate(java.time.LocalDateTime.now());
			this.customerNameRepository.save(customerName);
			return new Response("Record Updated Successfully");
		}
	}

	public Response deleteCustomerNameById(Integer uid) throws Exception {
		if (!this.customerNameRepository.existsById(uid)) {
			throw new ValueNotPresentException("UID is Incorrect");
		}
		this.customerNameRepository.deleteById(uid);
		return new Response("Record Deleted Successfully");
	}

}
