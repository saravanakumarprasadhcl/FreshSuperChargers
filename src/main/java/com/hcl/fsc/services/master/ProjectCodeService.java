package com.hcl.fsc.services.master;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.fsc.controllers.Response;
import com.hcl.fsc.customExpcetion.DuplicateValueException;
import com.hcl.fsc.customExpcetion.NullValueException;
import com.hcl.fsc.customExpcetion.ValueNotPresentException;
import com.hcl.fsc.mastertables.ProjectCode;
import com.hcl.fsc.repositories.master.ProjectCodeRepository;

import jakarta.persistence.EntityExistsException;

@Service
public class ProjectCodeService {

	@Autowired
	private ProjectCodeRepository projectCodeRepository;

	public List<ProjectCode> getAllProjectCode() {
		return this.projectCodeRepository.findAll();
	}

	public Optional<ProjectCode> getProjectCodeById(Integer uid) {
		return this.projectCodeRepository.findById(uid);
	}

	public Response createNewProjectCode(ProjectCode projectCode) throws Exception {
		if (projectCode.getUid() != null && this.projectCodeRepository.existsById(projectCode.getUid())) {
			throw new DuplicateValueException("Duplicate UID");
		}
		if (projectCode.getProjectName() == null) {
			throw new NullValueException("Project Name is Empty");
		}
		if (projectCode.getProjectCode() == null) {
			throw new NullValueException("Project Code is Empty");
		}
		if (this.projectCodeRepository.existsProjectCodeByprojectCode(projectCode.getProjectCode())) {
			throw new DuplicateValueException("Duplicate Project Code");
		}
		if (this.projectCodeRepository.existsProjectCodeByprojectName(projectCode.getProjectName())) {
			throw new DuplicateValueException("Duplicate Project Name");
		} else {
			if (this.projectCodeRepository.findAll().size() == 0) {
				projectCode.setUid(1);
				projectCode.setCreatedDate(java.time.LocalDateTime.now());
			} else {
				Integer uid = this.projectCodeRepository.findTopByOrderByUidDesc().getUid();
				projectCode.setUid(++uid);
				projectCode.setCreatedDate(java.time.LocalDateTime.now());
			}
			this.projectCodeRepository.save(projectCode);
		}
		return new Response("New Record Succefully Created");
	}

	public Response updateProjectCode(ProjectCode projectCode, Integer uid) throws Exception {
		if (!this.projectCodeRepository.existsById(uid)) {
			throw new ValueNotPresentException("UId is not present");
		}
		if (projectCode.getProjectName() == null) {
			throw new NullValueException("Project Name is Empty");
		}
		if (projectCode.getProjectCode() == null) {
			throw new NullValueException("Project Code is Empty");
		}
		if (this.projectCodeRepository.existsProjectCodeByprojectCode(projectCode.getProjectCode())) {
			throw new DuplicateValueException("Duplicate Project Code");
		}
		if (this.projectCodeRepository.existsProjectCodeByprojectName(projectCode.getProjectName())) {
			throw new DuplicateValueException("Duplicate Project Name");
		} else {
			ProjectCode pc = this.projectCodeRepository.getById(uid);
			projectCode.setUid(uid);
			if (projectCode.getProjectCode() == null) {
				projectCode.setProjectCode(pc.getProjectCode());
			}
			if (projectCode.getProjectName() == null) {
				projectCode.setProjectName(pc.getProjectName());
			}
			projectCode.setCreatedDate(pc.getCreatedDate());
			projectCode.setUpdatedDate(java.time.LocalDateTime.now());
			this.projectCodeRepository.save(projectCode);
			return new Response("Record Updated Successfully");
		}
	}
	
	public Response deleteProjectCodeById(Integer uid) throws Exception{
		if (!this.projectCodeRepository.existsById(uid)) {
			throw new ValueNotPresentException("UID is Incorrect");
		}
		this.projectCodeRepository.deleteById(uid);
		return new Response("Record Deleted Successfully");
	}

}
