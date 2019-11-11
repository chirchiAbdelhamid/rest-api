package com.ncq.restApi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import com.ncq.restApi.Representation.WorkflowCategoryRepresentation;

public interface WorkflowCategoryController {
	public List<WorkflowCategoryRepresentation> getCategories();
}
