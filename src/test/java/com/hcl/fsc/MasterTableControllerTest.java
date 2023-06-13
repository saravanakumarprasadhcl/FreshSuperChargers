package com.hcl.fsc;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.json.JSONArray;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import com.hcl.fsc.controllers.MasterTableController;
import com.hcl.fsc.services.MasterTableServiceImpl;





@RunWith(SpringRunner.class)
@SpringBootTest
 public class MasterTableControllerTest {

	@Autowired
	public MasterTableController controller;

	@Autowired
	private WebApplicationContext context;

	@Autowired
	public MasterTableServiceImpl service;

	private MockMvc mockMvc;


	@Before
    public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
      //  mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

	@Test
	public void getRecordAllTables() throws Exception {

		List<String> tablesList = Arrays.asList("gender","lob","location","region","collegeTiering","state","l1","l2","l3","l4","ugdegree","offeredband","offeredsubband","offereddesignation","onboardingstatus");
		for(String s : tablesList) {
			MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/master/"+s))
	                .andReturn();
			String jsonResponse = result.getResponse().getContentAsString();
	        System.out.println(s +"table JSON response: " + jsonResponse);
	        JSONArray jsonArray = new JSONArray(jsonResponse);
	        int objectCount = jsonArray.length();

	        int recordCountFromService = service.getRecord(s).size();
	        assertEquals(objectCount,recordCountFromService);
		}

	}
}
