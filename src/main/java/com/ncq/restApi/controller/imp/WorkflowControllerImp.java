package com.ncq.restApi.controller.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ncq.restApi.Representation.WorkflowCategoryRepresentation;
import com.ncq.restApi.Representation.WorkflowRepresentation;
import com.ncq.restApi.controller.WorkflowController;
import com.ncq.restApi.mapper.CategoryToRepresentationMapper;
import com.ncq.restApi.model.Workflow;
import com.ncq.restApi.service.WorkflowService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "RestController")
@RestController
public class WorkflowControllerImp implements WorkflowController {

	@Autowired
	private WorkflowService workflowService;

	@Autowired
	private CategoryToRepresentationMapper categoryToRepresentationMapper;


	@ApiOperation(value = "Get list of workflows in the System ", response = Iterable.class, tags = "Workflow")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Suceess|OK") })
	@RequestMapping(value = "/workflow", method = RequestMethod.GET)
	public List<WorkflowRepresentation> getWorkflows(@RequestParam(value = "name",required = false) String name,
			@RequestParam(value = "status",required = false) Boolean status,
			@RequestParam(value = "categoryIds",required = false) List<Long> categoryIds) {
		List<WorkflowCategoryRepresentation> categories = new ArrayList<>();
		Iterable<Workflow> workflowCategories = workflowService.findAll();
		List<WorkflowRepresentation> workflowCategoryRepresentations = new ArrayList<>();
		workflowCategories.forEach(e -> {

			e.getCategories().forEach(category -> {
				categories.add(categoryToRepresentationMapper.toRepresentation(category));
			});
			workflowCategoryRepresentations
					.add(new WorkflowRepresentation(e.getName(), e.getDescription(), e.getEnabled(), categories));
		});

		return workflowCategoryRepresentations;

	}

}
