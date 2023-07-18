package com.hcl.fsc;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.fsc.entities.EmployeeProjectDetails;
import com.hcl.fsc.entities.ProjectAssignmentHistory;
import com.hcl.fsc.repositories.EmployeeProjectDetailsRepository;
import com.hcl.fsc.repositories.ProjectAssignmentHistoryRepository;
import lombok.ToString;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;
import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
@AutoConfigureMockMvc
class FreshSuperChargersApplicationTests {

	@Autowired
	MockMvc mvc;

	@Autowired
	WebApplicationContext webApplicationContext;

	@Autowired
	private ProjectAssignmentHistoryRepository projectAssignmentHistoryRepository;

	@Autowired
	private EmployeeProjectDetailsRepository employeeProjectDetailsRepository;
	private   void setUp(){
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	private String mapToJson(Object obj) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.findAndRegisterModules();
		return objectMapper.writeValueAsString(obj);
	}
	private <T> T mapFromJson(String json, Class<T> clazz)
			throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.readValue(json, clazz);
	}
	private EmployeeProjectDetails employeeProjectDetails(){
		EmployeeProjectDetails employeeProjectDetails=new EmployeeProjectDetails();

		employeeProjectDetails.setEmpSAPID(11111);
		employeeProjectDetails.setReportingMgrSAPID(2345678);
		employeeProjectDetails.setHrL4ID(2);
		employeeProjectDetails.setProjID(11);
		employeeProjectDetails.setCustomerName("HCL");
		employeeProjectDetails.setAssignmentStartDate(LocalDate.parse("2023-12-22"));
		employeeProjectDetails.setAssignmentEndDate(LocalDate.parse("2024-02-22"));
		employeeProjectDetails.setFresher("Fresher");
		employeeProjectDetails.setOnOff("onShore");
		employeeProjectDetails.setJob("HCL");
		employeeProjectDetails.setSkill("Java");
		employeeProjectDetails.setFte(2);
		employeeProjectDetails.setSR("HCL");
		employeeProjectDetails.setCreatedBy("HCL");
		employeeProjectDetails.setCreatedDate(LocalDate.parse("2023-07-07"));
		employeeProjectDetails.setUpdatedBy("HCL");
		employeeProjectDetails.setRasStatus("HCL");
		return employeeProjectDetails;
	}
	@Test
	void reassignmentAndMaintainHistoryTest() throws Exception {
		EmployeeProjectDetails oldEmployeeHistory=employeeProjectDetailsRepository.findByEmpSAPID(employeeProjectDetails().getEmpSAPID());

		String inputJson= mapToJson(employeeProjectDetails());
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post("/project")
				.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(202,status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content,"Records Inserted Successfully");

		ProjectAssignmentHistory getRecorded = projectAssignmentHistoryRepository.findFirstByOrderByIdDesc();
		ProjectAssignmentHistory historyExpected = new ProjectAssignmentHistory();
		LocalDate currentDate=LocalDate.now();
		historyExpected.setId(getRecorded.getId());
		historyExpected.setSkill(oldEmployeeHistory.getSkill());
		historyExpected.setAssignment_start_date(oldEmployeeHistory.getAssignmentStartDate());
		historyExpected.setAssignement_end_date(oldEmployeeHistory.getAssignmentEndDate());
		historyExpected.setModified_date(currentDate);
		historyExpected.setRemarks(oldEmployeeHistory.getRemarks());
		historyExpected.setProject_code(oldEmployeeHistory.getProjID());
		String expected=mapToJson(historyExpected);
		String recored=mapToJson(getRecorded);
		assertEquals(expected,recored);
	}



}
