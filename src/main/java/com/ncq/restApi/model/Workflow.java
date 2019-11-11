package com.ncq.restApi.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Workflow")
public class Workflow {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "Name")
	private String name;

	@Column(name = "Description")
	private String description;

	@Column(name = "Enabled")
	private Boolean enabled;

	@ManyToMany
	@JoinTable(
			  name = "workflows_categories", 
			  joinColumns = @JoinColumn(name = "Workflow_id"), 
			  inverseJoinColumns = @JoinColumn(name = "Category_id"))
	private Set<Category> categories;
	@lombok.Generated
	public Workflow() {
		super();
	}
	@lombok.Generated
	public Workflow(String name, String description, Boolean enabled) {
		super();
		this.name = name;
		this.description = description;
		this.enabled = enabled;
	}
	@lombok.Generated
	public Workflow(String name, String description, Boolean enabled, Set<Category> categories) {
		super();
		this.name = name;
		this.description = description;
		this.enabled = enabled;
		this.categories = categories;
	}
	@lombok.Generated
	public Long getIdWorkflow() {
		return id;
	}
	@lombok.Generated
	public void setIdWorkflow(Long idWorkflow) {
		this.id = idWorkflow;
	}
	@lombok.Generated
	public String getName() {
		return name;
	}
	@lombok.Generated
	public void setName(String name) {
		this.name = name;
	}
	@lombok.Generated
	public String getDescription() {
		return description;
	}
	@lombok.Generated
	public void setDescription(String description) {
		this.description = description;
	}
	@lombok.Generated
	public Boolean getEnabled() {
		return enabled;
	}
	@lombok.Generated
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	@lombok.Generated
	public Set<Category> getCategories() {
		return categories;
	}
	@lombok.Generated
	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

}
