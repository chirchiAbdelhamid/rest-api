package com.ncq.restApi.controller.imp;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.ncq.restApi.RestApiIntegrationTest;
import com.ncq.restApi.model.Category;
import com.ncq.restApi.model.Workflow;
import com.ncq.restApi.service.WorkflowCategoryService;
import com.ncq.restApi.service.WorkflowService;

import cucumber.api.java.Before;
import cucumber.api.java.en.Then;

public class CommonSteps extends RestApiIntegrationTest {

	@Autowired
	private WorkflowCategoryService workflowCategoryService;

	@Autowired
	private WorkflowService workflowService;

	private static boolean isCalled = false;

	@Before
	public void setup() {
		if (!isCalled) {
			workflowCategoryService.save(new Category("name", "description", null, null, true));
			workflowCategoryService.save(new Category("name2", "description", null, null, true));
			workflowCategoryService.save(new Category("name3", "description", null, null, true));
			workflowCategoryService.save(new Category("name4", "description", null, null, true));

			workflowService.save(new Workflow("name", "description", true));
			workflowService.save(new Workflow("name1", "description", true));
			Category category = new Category("name", "description", null, null, true);
			workflowCategoryService.save(category);
			Set<Category> categories = new HashSet<Category>();
			categories.add(category);
			workflowService.save(new Workflow("name2", "description", true, categories));
			isCalled=true;
		}


	}

	@Then("^I receive status code of (\\d+)$")
	public void iReceiveStatusCodeOf(int statusCode) throws Throwable {
		final HttpStatus currentStatusCode = latestResponse.getTheResponse().getStatusCode();
		assertThat("status code is incorrect : " + latestResponse.getBody(), currentStatusCode.value(), is(statusCode));
	}

}
