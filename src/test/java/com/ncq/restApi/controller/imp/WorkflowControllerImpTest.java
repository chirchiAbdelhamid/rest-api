package com.ncq.restApi.controller.imp;

import static org.junit.Assert.assertEquals;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ncq.restApi.RestApiIntegrationTest;
import com.ncq.restApi.Representation.WorkflowRepresentation;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class WorkflowControllerImpTest extends RestApiIntegrationTest {



	@When("^I get the list of workflows$")
	public void iGetCategories() throws Throwable {
		executeGet("http://localhost:" + port + "/ncqDev/workflow");
	}

	@Then("^The list of workflows contains (\\d+) elements$")
	public void TheListContains(int size) throws Throwable {
		ObjectMapper mapper = new ObjectMapper();
		WorkflowRepresentation[] workflows = mapper.readValue(latestResponse.getBody(), WorkflowRepresentation[].class);
		assertEquals(workflows.length, size);
	}


}
