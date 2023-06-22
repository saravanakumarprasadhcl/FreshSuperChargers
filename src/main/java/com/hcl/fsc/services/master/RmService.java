package com.hcl.fsc.services.master;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.fsc.controllers.Response;
import com.hcl.fsc.customExpcetion.DuplicateValueException;
import com.hcl.fsc.customExpcetion.NullValueException;
import com.hcl.fsc.customExpcetion.ValueNotPresentException;
import com.hcl.fsc.mastertables.Rm;
import com.hcl.fsc.mastertables.Rm;
import com.hcl.fsc.repositories.master.HrL4Repository;
import com.hcl.fsc.repositories.master.RmRepository;

@Service
public class RmService {


	
	@Autowired
	private RmRepository rmRepository;


	public List<Rm> getAllRM() {
		return this.rmRepository.findAll();
	}
	
	public Optional<Rm> getRmById(Integer uid){
		return this.rmRepository.findById(uid);
	}

	public Response createNewRm(Rm rm) throws Exception {
		if (rm.getUid() != null && this.rmRepository.existsById(rm.getUid())) {
			throw new DuplicateValueException("Duplicate UID");
		}
		if (rm.getSapId() == null) {
			throw new NullValueException("SAP Id is Empty");
		}
		if (rm.getRmName() == null) {
			throw new NullValueException("RM name is Empty");
		}
		if (this.rmRepository.existsRmBysapId(rm.getSapId())) {
			throw new DuplicateValueException("Duplicate SAP Id");
		}
		if (this.rmRepository.existsRmByrmName(rm.getRmName())) {
			throw new DuplicateValueException("Duplicate RM  Name");
		} else {
			if (this.rmRepository.findAll().size() == 0) {
				rm.setUid(1);
				rm.setCreatedDate(java.time.LocalDateTime.now());
			} else {
				Integer uid = this.rmRepository.findTopByOrderByUidDesc().getUid();
				rm.setUid(++uid);
				rm.setCreatedDate(java.time.LocalDateTime.now());
			}
			this.rmRepository.save(rm);
		}
		return new Response("New Record Succefully Created");
	}

	public Response updateRm(Rm rm, Integer uid) throws Exception {
		if (!this.rmRepository.existsById(uid)) {
			throw new ValueNotPresentException("UId is not present");
		}
		if (rm.getSapId() == null) {
			throw new NullValueException("SAP Id is Empty");
		}
		if (rm.getRmName() == null) {
			throw new NullValueException("RM name is Empty");
		}
		if (this.rmRepository.existsRmBysapId(rm.getSapId())) {
			throw new DuplicateValueException("Duplicate SAP ID");
		}
		if (this.rmRepository.existsRmByrmName(rm.getRmName())) {
			throw new DuplicateValueException("Duplicate RM Name");
		} else {
			Rm obj = this.rmRepository.getById(uid);
			rm.setUid(uid);
			if (rm.getSapId() == null) {
				rm.setSapId(obj.getSapId());
			}
			if (rm.getRmName() == null) {
				rm.setRmName(obj.getRmName());
			}
			rm.setCreatedDate(obj.getCreatedDate());
			rm.setUpdatedDate(java.time.LocalDateTime.now());
			this.rmRepository.save(rm);
			return new Response("Record Updated Successfully");
		}
	}

	public Response deleteRmById(Integer uid) throws Exception {
		if (!this.rmRepository.existsById(uid)) {
			throw new ValueNotPresentException("UID is Incorrect");
		}
		this.rmRepository.deleteById(uid);
		return new Response("Record Deleted Successfully");
	}

	
}
