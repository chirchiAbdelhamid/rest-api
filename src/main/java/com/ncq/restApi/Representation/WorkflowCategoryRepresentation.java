package com.ncq.restApi.Representation;

import java.sql.Date;

import com.ncq.restApi.model.Category;

public class WorkflowCategoryRepresentation {

	
	private String name;

	private String description;

	private Date createAt;

	private Date updateAt;

	private Boolean enabled;

	private WorkflowCategoryRepresentation parentCategory;

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

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public Date getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public WorkflowCategoryRepresentation getParentCategory() {
		return parentCategory;
	}

	public void setParentCategory(WorkflowCategoryRepresentation parentCategory) {
		this.parentCategory = parentCategory;
	}

	public WorkflowCategoryRepresentation() {
		super();
	}

	public WorkflowCategoryRepresentation(String name, String description, Date createAt, Date updateAt,
			Boolean enabled, WorkflowCategoryRepresentation parentCategory) {
		super();
		this.name = name;
		this.description = description;
		this.createAt = createAt;
		this.updateAt = updateAt;
		this.enabled = enabled;
		this.parentCategory = parentCategory;
	}
	
	
}
