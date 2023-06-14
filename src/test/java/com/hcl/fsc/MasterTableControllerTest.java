package com.hcl.fsc;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.*;
import org.json.JSONArray;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.json.JSONObject;

import com.hcl.fsc.controllers.MasterTableController;
import com.hcl.fsc.mastertables.CollegeTiering;
import com.hcl.fsc.mastertables.Gender;
import com.hcl.fsc.mastertables.L1;
import com.hcl.fsc.mastertables.L2;
import com.hcl.fsc.mastertables.L3;
import com.hcl.fsc.mastertables.L4;
import com.hcl.fsc.mastertables.Lob;
import com.hcl.fsc.mastertables.Location;
import com.hcl.fsc.mastertables.OfferedBand;
import com.hcl.fsc.mastertables.OfferedDesignation;
import com.hcl.fsc.mastertables.OfferedSubBand;
import com.hcl.fsc.mastertables.OnboardingStatus;
import com.hcl.fsc.mastertables.Region;
import com.hcl.fsc.mastertables.State;
import com.hcl.fsc.mastertables.UgDegree;
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
        // mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

     @Test
    public void getRecordAllTables() throws Exception {

        List<String> tablesList = Arrays.asList("gender", "lob", "location", "region", "collegeTiering", "state", "l1",
                "l2", "l3", "l4", "ugdegree", "offeredband", "OfferedSubBand", "offereddesignation",
                "onboardingstatus");
        for (String s : tablesList) {
            MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/master/" + s)).andReturn();
            String jsonResponse = result.getResponse().getContentAsString();

            System.out.println(s + "table JSON response: " + jsonResponse);
            JSONArray jsonArray = new JSONArray(jsonResponse);
            int objectCount = jsonArray.length();

            int recordCountFromService = service.getRecord(s).size();
            assertEquals(objectCount, recordCountFromService);
        }

    }

    @Test
    public void getRecordByKey() throws Exception {
        List<String> tablesList = Arrays.asList("Gender", "Lob", "Location", "Region", "CollegeTiering", "State", "L1",
                "L2", "L3", "L4", "UgDegree", "OfferedBand", "OfferedSubBand", "OfferedDesignation",
                "OnboardingStatus");

        List<String> errorMessages = new ArrayList<>(); 

        for (String tableName : tablesList) {
            String className = "com.hcl.fsc.mastertables." + tableName;
            Class<?> pojoClass = Class.forName(className);

            // Get records from master table
            List<?> records = service.getRecord(tableName.toLowerCase());

            // Add records' key into keyList
            for (Object record : records) {
                try {
                    // get Key from each mastertable's record.
                    Method getKeyMethod = pojoClass.getMethod("getKey");
                    String key = (String) getKeyMethod.invoke(record);

                    // get response from API
                    MvcResult result = mockMvc
                            .perform(MockMvcRequestBuilders.get("/master/" + tableName + "/" + key)).andReturn();
                    if (result.getResponse().getStatus() == HttpStatus.OK.value()) {
                        String jsonResponse = result.getResponse().getContentAsString();

                        JSONObject apiObject = new JSONObject(jsonResponse);

                        Optional<?> serviceObject = service.getRecordbyKey(tableName, key);

                        if (serviceObject.isPresent()) {
                            Object object = serviceObject.get();
                            if (pojoClass.isInstance(object)) {
                                Object pojoObject = pojoClass.cast(object);

                                Method getUid = pojoClass.getMethod("getUid");
                                Method getKey = pojoClass.getMethod("getKey");
                                Method getValue = pojoClass.getMethod("getValue");

                                int tempUid = (int) getUid.invoke(pojoObject);
                                String tempKey = (String) getKey.invoke(pojoObject);
                                String tempValue = (String) getValue.invoke(pojoObject);

                                JSONObject jsonObject = new JSONObject();
                                jsonObject.put("uid", tempUid);
                                jsonObject.put("key", tempKey);
                                jsonObject.put("value", tempValue);

                                JSONObject optionalObject = new JSONObject(jsonObject.toString());

                                if (!apiObject.toString().equals(optionalObject.toString())) {
                                    String errorMessage = "Result from API and Service does not match at " + tableName
                                            + "/" + key;
                                    errorMessages.add(errorMessage);
                                }
                            }

                        }

                    } else {
                        String errorMessage = "API Not responding at " + "/master/" + tableName + "/" + key;
                        errorMessages.add(errorMessage); 
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        
        if (!errorMessages.isEmpty()) {
            fail(String.join("\n", errorMessages)); 
        } else {
            System.out.println("All testcases passed."); 
        }
    }
}
