package com.ncq.restApi.Representation;

import java.util.List;

import com.ncq.restApi.model.Category;

public class WorkflowRepresentation {

	
	private String name;

	private String description;

	private Boolean enabled;

	private List<WorkflowCategoryRepresentation> categories;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}


	public List<WorkflowCategoryRepresentation> getCategories() {
		return categories;
	}

	public void setCategories(List<WorkflowCategoryRepresentation> categories) {
		this.categories = categories;
	}

	public WorkflowRepresentation() {
		super();
	}

	public WorkflowRepresentation(String name, String description, Boolean enabled, List<WorkflowCategoryRepresentation> Categories) {
		super();
		this.name = name;
		this.description = description;
		this.enabled = enabled;
		this.categories = Categories;
	}
	
	
	
	
}
