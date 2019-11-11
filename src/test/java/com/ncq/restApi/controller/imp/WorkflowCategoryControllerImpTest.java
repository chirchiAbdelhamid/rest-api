package com.ncq.restApi.controller.imp;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ncq.restApi.RestApiIntegrationTest;
import com.ncq.restApi.Representation.WorkflowCategoryRepresentation;
import com.ncq.restApi.model.Category;
import com.ncq.restApi.model.Workflow;
import com.ncq.restApi.service.WorkflowCategoryService;
import com.ncq.restApi.service.WorkflowService;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class WorkflowCategoryControllerImpTest extends RestApiIntegrationTest{
	
	


    @When("^I get the list of workflow categories$")
    public void iGetCategories() throws Throwable {
        executeGet("http://localhost:"+port+"/ncqDev/category");
    }


    @Then("^The list of categories contains (\\d+) elements$")
    public void TheListContains(int size) throws Throwable {
        ObjectMapper mapper = new ObjectMapper();
        WorkflowCategoryRepresentation[] categories = mapper.readValue(latestResponse.getBody(), WorkflowCategoryRepresentation[].class);
        assertEquals(categories.length,size);
    }
    

}
