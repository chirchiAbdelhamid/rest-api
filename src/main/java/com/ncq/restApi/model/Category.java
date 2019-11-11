package com.ncq.restApi.model;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Category")
public class Category {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "Name")
	private String name;

	@Column(name = "Description")
	private String description;

	@Column(name = "CreateAt")
	private Date createAt;

	@Column(name = "UpdateAt")
	private Date updateAt;

	@Column(name = "Enabled")
	private Boolean enabled;

	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "ParentCategory")
	private Category parentCategory;
	
	
	
	@ManyToMany(mappedBy = "categories")
	private Set<Workflow> workflows;
	
	@lombok.Generated
	public Category() {
		super();
	}
	@lombok.Generated
	public Category(String name, String description, Date createAt, Date updateAt, Boolean enabled) {
		super();
		this.name = name;
		this.description = description;
		this.createAt = createAt;
		this.updateAt = updateAt;
		this.enabled = enabled;
	}
	
	
	@lombok.Generated
	public Category(String name, String description, Date createAt, Date updateAt, Boolean enabled,
			Category parentCategory) {
		super();
		this.name = name;
		this.description = description;
		this.createAt = createAt;
		this.updateAt = updateAt;
		this.enabled = enabled;
		this.parentCategory = parentCategory;
	}
	@lombok.Generated
	public Long getIdCategory() {
		return id;
	}
	@lombok.Generated
	public void setIdCategory(Long idCategory) {
		this.id = idCategory;
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
	public Date getCreateAt() {
		return createAt;
	}
	@lombok.Generated
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	@lombok.Generated
	public Date getUpdateAt() {
		return updateAt;
	}
	@lombok.Generated
	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
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
	public Category getParentCategory() {
		return parentCategory;
	}
	@lombok.Generated
	public void setParentCategory(Category parentCategory) {
		this.parentCategory = parentCategory;
	}
	@lombok.Generated
	public Set<Workflow> getWorkflows() {
		return workflows;
	}
	@lombok.Generated
	public void setWorkflows(Set<Workflow> workflows) {
		this.workflows = workflows;
	}
	
	

}
