package com.hcl.fsc.services.master;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.fsc.controllers.Response;
import com.hcl.fsc.customExpcetion.DuplicateValueException;
import com.hcl.fsc.customExpcetion.NullValueException;
import com.hcl.fsc.customExpcetion.ValueNotPresentException;
import com.hcl.fsc.mastertables.HrL4;
import com.hcl.fsc.mastertables.HrL4;
import com.hcl.fsc.repositories.master.HrL4Repository;
import com.hcl.fsc.repositories.master.ProjectCodeRepository;

@Service
public class HrL4Service {


	@Autowired
	private HrL4Repository hrL4Repository;

	public List<HrL4> getAllHrL4() {
		return this.hrL4Repository.findAll();
	}

	public Optional<HrL4> getHrL4ById(Integer uid) {
		return this.hrL4Repository.findById(uid);
	}

	public Response createNewHrL4(HrL4 hrL4) throws Exception {
		if (hrL4.getUid() != null && this.hrL4Repository.existsById(hrL4.getUid())) {
			throw new DuplicateValueException("Duplicate UID");
		}
		if (hrL4.getHrL4Code() == null) {
			throw new NullValueException("HR L4 Name is Empty");
		}
		if (hrL4.getHrL4Name() == null) {
			throw new NullValueException("HR L4 Code is Empty");
		}
		if (this.hrL4Repository.existsHrL4ByhrL4Code(hrL4.getHrL4Code())) {
			throw new DuplicateValueException("Duplicate HR L4 Code");
		}
		if (this.hrL4Repository.existsHrL4ByhrL4Name(hrL4.getHrL4Name())) {
			throw new DuplicateValueException("Duplicate HR L4 Name");
		} else {
			if (this.hrL4Repository.findAll().size() == 0) {
				hrL4.setUid(1);
				hrL4.setCreatedDate(java.time.LocalDateTime.now());
			} else {
				Integer uid = this.hrL4Repository.findTopByOrderByUidDesc().getUid();
				hrL4.setUid(++uid);
				hrL4.setCreatedDate(java.time.LocalDateTime.now());
			}
			this.hrL4Repository.save(hrL4);
		}
		return new Response("New Record Succefully Created");
	}

	public Response updateHrL4(HrL4 hrL4, Integer uid) throws Exception {
		if (!this.hrL4Repository.existsById(uid)) {
			throw new ValueNotPresentException("UId is not present");
		}
		if (hrL4.getHrL4Name() == null) {
			throw new NullValueException("HR L4 Name is Empty");
		}
		if (hrL4.getHrL4Code() == null) {
			throw new NullValueException("HR L4 Code is Empty");
		}
		if (this.hrL4Repository.existsHrL4ByhrL4Code(hrL4.getHrL4Code())) {
			throw new DuplicateValueException("Duplicate HR L4 Code");
		}
		if (this.hrL4Repository.existsHrL4ByhrL4Name(hrL4.getHrL4Name())) {
			throw new DuplicateValueException("Duplicate HR L4 Name");
		} else {
			HrL4 hr = this.hrL4Repository.getById(uid);
			hrL4.setUid(uid);
			if (hrL4.getHrL4Code() == null) {
				hrL4.setHrL4Code(hr.getHrL4Code());
			}
			if (hrL4.getHrL4Name() == null) {
				hrL4.setHrL4Name(hr.getHrL4Name());
			}
			hrL4.setCreatedDate(hr.getCreatedDate());
			hrL4.setUpdatedDate(java.time.LocalDateTime.now());
			this.hrL4Repository.save(hrL4);
			return new Response("Record Updated Successfully");
		}
	}

	public Response deleteHrL4ById(Integer uid) throws Exception {
		if (!this.hrL4Repository.existsById(uid)) {
			throw new ValueNotPresentException("UID is Incorrect");
		}
		this.hrL4Repository.deleteById(uid);
		return new Response("Record Deleted Successfully");
	}

}
