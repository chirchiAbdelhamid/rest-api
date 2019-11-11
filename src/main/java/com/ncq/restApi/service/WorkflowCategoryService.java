package com.ncq.restApi.service;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.ncq.restApi.model.Category;

@Transactional
public interface WorkflowCategoryService extends CrudRepository<Category, Long> {
	
	public Category findById(Long e);

}
