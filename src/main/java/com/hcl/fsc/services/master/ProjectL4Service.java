package com.hcl.fsc.services.master;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.fsc.controllers.Response;
import com.hcl.fsc.customExpcetion.DuplicateValueException;
import com.hcl.fsc.customExpcetion.NullValueException;
import com.hcl.fsc.customExpcetion.ValueNotPresentException;
import com.hcl.fsc.mastertables.ProjectL4;
import com.hcl.fsc.mastertables.ProjectL4;
import com.hcl.fsc.repositories.master.HrL4Repository;
import com.hcl.fsc.repositories.master.ProjectL4Repository;

@Service
public class ProjectL4Service {

	@Autowired
	private ProjectL4Repository projectL4Repository;

	public List<ProjectL4> getAllProjectL4() {
		return this.projectL4Repository.findAll();
	}

	public Optional<ProjectL4> getProjectL4ById(Integer uid) {
		return this.projectL4Repository.findById(uid);
	}

	public Response createNewProjectL4(ProjectL4 projectL4) throws Exception {
		if (projectL4.getUid() != null && this.projectL4Repository.existsById(projectL4.getUid())) {
			throw new DuplicateValueException("Duplicate UID");
		}
		if (projectL4.getProjectL4Name() == null) {
			throw new NullValueException("Project L4 Name is Empty");
		}
		if (projectL4.getProjectL4Code() == null) {
			throw new NullValueException("Project L4 Code is Empty");
		}
		if (this.projectL4Repository.existsProjectL4ByprojectL4Code(projectL4.getProjectL4Code())) {
			throw new DuplicateValueException("Duplicate Project L4 Code");
		}
		if (this.projectL4Repository.existsProjectL4ByprojectL4Name(projectL4.getProjectL4Name())) {
			throw new DuplicateValueException("Duplicate HR L4 Name");
		} else {
			if (this.projectL4Repository.findAll().size() == 0) {
				projectL4.setUid(1);
				projectL4.setCreatedDate(java.time.LocalDateTime.now());
			} else {
				Integer uid = this.projectL4Repository.findTopByOrderByUidDesc().getUid();
				projectL4.setUid(++uid);
				projectL4.setCreatedDate(java.time.LocalDateTime.now());
			}
			this.projectL4Repository.save(projectL4);
		}
		return new Response("New Record Succefully Created");
	}

	public Response updateProjectL4(ProjectL4 projectL4, Integer uid) throws Exception {
		if (!this.projectL4Repository.existsById(uid)) {
			throw new ValueNotPresentException("UId is not present");
		}
		if (projectL4.getProjectL4Name() == null) {
			throw new NullValueException("Project L4 Name is Empty");
		}
		if (projectL4.getProjectL4Code() == null) {
			throw new NullValueException("Project L4 Code is Empty");
		}
		if (this.projectL4Repository.existsProjectL4ByprojectL4Code(projectL4.getProjectL4Code())) {
			throw new DuplicateValueException("Duplicate Project L4 Code");
		}
		if (this.projectL4Repository.existsProjectL4ByprojectL4Name(projectL4.getProjectL4Name())) {
			throw new DuplicateValueException("Duplicate Project L4 Name");
		} else {
			ProjectL4 proj = this.projectL4Repository.getById(uid);
			projectL4.setUid(uid);
			if (projectL4.getProjectL4Code() == null) {
				projectL4.setProjectL4Code(proj.getProjectL4Code());
			}
			if (projectL4.getProjectL4Name() == null) {
				projectL4.setProjectL4Name(proj.getProjectL4Name());
			}
			projectL4.setCreatedDate(proj.getCreatedDate());
			projectL4.setUpdatedDate(java.time.LocalDateTime.now());
			this.projectL4Repository.save(projectL4);
			return new Response("Record Updated Successfully");
		}
	}

	public Response deleteProjectL4ById(Integer uid) throws Exception {
		if (!this.projectL4Repository.existsById(uid)) {
			throw new ValueNotPresentException("UID is Incorrect");
		}
		this.projectL4Repository.deleteById(uid);
		return new Response("Record Deleted Successfully");
	}

}
