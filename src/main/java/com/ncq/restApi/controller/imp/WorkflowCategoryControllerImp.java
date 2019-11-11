package com.ncq.restApi.controller.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ncq.restApi.Representation.WorkflowCategoryRepresentation;
import com.ncq.restApi.controller.WorkflowCategoryController;
import com.ncq.restApi.mapper.CategoryToRepresentationMapper;
import com.ncq.restApi.model.Category;
import com.ncq.restApi.service.WorkflowCategoryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "RestController")
@RestController
public class WorkflowCategoryControllerImp implements WorkflowCategoryController {

	@Autowired
	private WorkflowCategoryService workflowCategoryService;
	
	@Autowired
	private CategoryToRepresentationMapper categoryToRepresentationMapper;
	
	
	@Override
	@ApiOperation(value = "Get list of workflows categories in the System ", response = Iterable.class, tags = "Category")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Suceess|OK") })
	@RequestMapping(value = "/category", method = RequestMethod.GET)
	public List<WorkflowCategoryRepresentation> getCategories() {
		List<WorkflowCategoryRepresentation> workflowCategoryRepresentations = new ArrayList<>();
		Iterable<Category> workflowCategories = workflowCategoryService.findAll();
		workflowCategories.forEach(e -> {
			workflowCategoryRepresentations.add(new WorkflowCategoryRepresentation(e.getName(), e.getDescription(), e.getCreateAt(), e.getUpdateAt(), e.getEnabled(),categoryToRepresentationMapper.toRepresentation( e.getParentCategory())));
		});
		
		return workflowCategoryRepresentations;

	}

}
